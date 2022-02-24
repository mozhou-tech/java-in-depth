package com.smartrm.smartrmmonolith.infracore.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartrm.smartrmmonolith.infracore.api.CommonError;
import com.smartrm.smartrmmonolith.infracore.api.CommonResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author: liuyuancheng
 * @description:
 */
public class DomainAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, AuthenticationException e)
      throws IOException, ServletException {
//    httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    httpServletResponse.setCharacterEncoding("utf-8");
    httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
    CommonResponse response = CommonResponse.fail(CommonError.NeedAuthentication);
    String resBody = new ObjectMapper().writeValueAsString(response);
    PrintWriter printWriter = httpServletResponse.getWriter();
    printWriter.print(resBody);
    printWriter.flush();
    printWriter.close();
  }
}
