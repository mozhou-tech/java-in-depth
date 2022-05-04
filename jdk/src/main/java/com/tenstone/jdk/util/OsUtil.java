package com.tenstone.jdk.util;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OsUtil {

    /**
     * 获取空闲端口号
     */
    public static int getFreePort(int defaultPort) throws Exception {
        int port;
        ServerSocket serverSocket1 = null;
        try {
            serverSocket1 = new ServerSocket(defaultPort);
            port = serverSocket1.getLocalPort();
        } catch (Exception e) {
            ServerSocket serverSocket2 = null;
            try {
                serverSocket2 = new ServerSocket(0);
                port = serverSocket2.getLocalPort();
            } catch (IOException e1) {
                throw e1;
            } finally {
                if (serverSocket2 != null) {
                    serverSocket2.close();
                }
            }
        } finally {
            if (serverSocket1 != null) {
                serverSocket1.close();
            }
        }
        return port;
    }

    /**
     * 检查端口号是否被占用
     */
    public static boolean isBusyPort(int port) {
        boolean ret = true;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            ret = false;
        } catch (Exception e) {
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    public static void openBrowse(String url) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        boolean flag = Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE);
        if (flag) {
            try {
                URI uri = new URI(url);
                desktop.browse(uri);
            } catch (Exception e) {
                throw new Exception("can't open browse", e);
            }
        } else {
            throw new Exception("don't support browse");
        }
    }

    public static void execFile(InputStream inputStream, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            try (
                    FileOutputStream fos = new FileOutputStream(file)
            ) {
                byte[] bts = new byte[8192];
                int len;
                while ((len = inputStream.read(bts)) != -1) {
                    fos.write(bts, 0, len);
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        Desktop.getDesktop().open(file);
    }

    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return OS.indexOf("win") >= 0;
    }

    public static boolean isMac() {
        return OS.indexOf("mac") >= 0;
    }

    public static boolean isUnix() {
        return OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") >= 0;
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

    private static final String ARCH = System.getProperty("sun.arch.data.model");

    public static boolean is64() {
        return "64".equals(ARCH);
    }

    public static boolean is32() {
        return "32".equals(ARCH);
    }

    static {
        if (isWindows()) {
            Preferences prefs = Preferences.systemRoot();
            PrintStream systemErr = System.err;
            synchronized (systemErr) {    // better synchroize to avoid problems with other threads that access System.err
                System.setErr(null);
                try {
                    prefs.put("pd_test", "1"); // SecurityException on Windows
                    prefs.remove("pd_test");
                    prefs.flush(); // BackingStoreException on Linux
                    isAdmin = true;
                } catch (Exception e) {
                    isAdmin = false;
                } finally {
                    System.setErr(systemErr);
                }
            }
        } else {
            try {
                isAdmin = "0".equals(getProcessPrint("id -u").trim());
            } catch (IOException e) {
                isAdmin = false;
            }
        }
    }

    private static boolean isAdmin;

    public static boolean isAdmin() {
        return isAdmin;
    }

    public static String getProcessPrint(String shell) throws IOException {
        Process process = Runtime.getRuntime().exec(shell);
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + System.lineSeparator());
            }
        } finally {
            process.destroy();
        }
        return sb.toString();
    }

    public static Map<String, List<String>> getInterfacesInfo() throws SocketException {
        Map<String, List<String>> interfacesInfo = new HashMap<>();
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress nextElement = addresses.nextElement();
                String name = networkInterface.getDisplayName();
                List<String> ipList = interfacesInfo.get(name);
                if (ipList == null) {
                    ipList = new ArrayList<>();
                    interfacesInfo.put(name, ipList);
                }
                ipList.add(nextElement.getHostAddress());
            }
        }
        return interfacesInfo;
    }

    public static String getRemoteInterface() throws IOException {
        Map<String, List<String>> interfacesInfo = getInterfacesInfo();
        Socket socket = new Socket("www.baidu.com", 80);
        for (Entry<String, List<String>> entry : interfacesInfo.entrySet()) {
            if (entry.getValue().contains(socket.getLocalAddress().getHostAddress())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String getRemoteInterfaceName() throws IOException {
        String remoteInterface = getRemoteInterface();
        String result = getProcessPrint("networksetup -listnetworkserviceorder");
        Pattern pattern = Pattern.compile("\\(Hardware\\sPort:\\s(.*),\\sDevice:\\s(.*)\\)");
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            if (matcher.group(2).equalsIgnoreCase(remoteInterface)) {
                return matcher.group(1);
            }
        }
        return null;
    }

    /**
     * 判断证书是否存在
     */
    public static boolean existsCert(String name, String sha1) throws IOException {
        if (OsUtil.isWindows()) {
            if (findCertList(name, true).toUpperCase().replaceAll("\\s", "")
                    .indexOf(":" + sha1.toUpperCase()) != -1) {
                return true;
            } else {
                if (findCertList(name, false).toUpperCase().replaceAll("\\s", "")
                        .indexOf(":" + sha1.toUpperCase()) != -1) {
                    return true;
                }
            }
            return false;
        } else if (OsUtil.isMac()) {
            if (findCertList(name).toUpperCase().replaceAll("\\s", "").indexOf(":" + sha1.toUpperCase())
                    != -1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断证书是否存在
     */
    public static boolean existsCert(String name) throws IOException {
        if (OsUtil.isWindows()) {
            if (isAdmin()
                    && existsWindowsCert(name, true)) {
                return true;
            } else {
                if (existsWindowsCert(name, false)) {
                    return true;
                }
            }
            return false;
        } else if (OsUtil.isMac()) {
            if (findCertList(name).toUpperCase().indexOf("BEGIN CERTIFICATE") != -1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断证书是否存在
     */
    public static boolean existsWindowsCert(String name, boolean isAdmin) throws IOException {
        return findCertList(name, isAdmin).indexOf("=====") != -1;
    }

    /**
     * 安装证书
     */
    public static void installCert(String path) throws IOException {
        if (OsUtil.isWindows()) {
            Runtime.getRuntime().exec("certutil "
                    + "-addstore "
                    + (isAdmin() ? "" : "-user ")
                    + "root "
                    + "\"" + path + "\""
            );
        } else if (OsUtil.isMac()) {
            Runtime.getRuntime().exec("security "
                    + "add-trusted-cert "
                    + "-d "
                    + "-r trustRoot "
                    + "-k /Library/Keychains/System.keychain "
                    + path
            );
        }
    }

    /**
     * 卸载证书
     */
    public static void uninstallCert(String name) throws IOException {
        if (isWindows()) {
            Pattern pattern = Pattern.compile("(?i)\\(sha1\\):\\s(.*)\r?\n");
            String certList = findCertList(name, false);
            Matcher matcher = pattern.matcher(certList);
            while (matcher.find()) {
                String hash = matcher.group(1).replaceAll("\\s", "");
                Runtime.getRuntime().exec("certutil "
                        + "-delstore "
                        + "-user "
                        + "root "
                        + hash);
            }
            if (isAdmin()) {
                certList = findCertList(name, true);
                matcher = pattern.matcher(certList);
                while (matcher.find()) {
                    String hash = matcher.group(1);
                    Runtime.getRuntime().exec("certutil "
                            + "-delstore "
                            + "root "
                            + hash);
                }
            }
        } else if (isMac()) {
            String certList = findCertList(name);
            Pattern pattern = Pattern.compile("(?i)SHA-1 hash:\\s(.*)\r?\n");
            Matcher matcher = pattern.matcher(certList);
            while (matcher.find()) {
                String hash = matcher.group(1);
                Runtime.getRuntime().exec("security "
                        + "delete-certificate "
                        + "-Z " + hash
                        + " /Library/Keychains/System.keychain");
            }
        }
    }

    private static String findCertList(String name, boolean isAdmin) throws IOException {
        if (isWindows()) {
            return getProcessPrint("certutil "
                    + "-store "
                    + (isAdmin ? "" : "-user ")
                    + "root "
                    + name);
        } else if (isMac()) {
            return getProcessPrint(
                    "security find-certificate "
                            + "-a "
                            + "-c " + name + " "
                            + "-p "
                            + "-Z "
                            + "/Library/Keychains/System.keychain");
        }
        return null;
    }

    private static String findCertList(String name) throws IOException {
        return findCertList(name, true);
    }

}
