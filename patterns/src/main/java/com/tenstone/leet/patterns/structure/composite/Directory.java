package com.tenstone.leet.patterns.structure.composite;

import java.util.ArrayList;

/**
 * Created by liuyuancheng on 2021/7/18  <br/>
 */
public class Directory extends Entry {

    private String name;

    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * 递归获取文件大小（目录会继续递归）
     *
     * @return
     */
    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }
}
