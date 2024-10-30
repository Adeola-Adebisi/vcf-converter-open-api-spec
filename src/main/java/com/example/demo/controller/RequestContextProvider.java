package com.example.demo.controller;

import java.util.Optional;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

public class RequestContextProvider {
  public Optional<NativeWebRequest> getRequest() {
    return getNativeRequest();
  }

  private Optional<NativeWebRequest> getNativeRequest() {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    if (requestAttributes instanceof ServletRequestAttributes attributes) {
      jakarta.servlet.http.HttpServletRequest request = attributes.getRequest();
      jakarta.servlet.http.HttpServletResponse response = attributes.getResponse();
      if (response != null) {
        return Optional.of(new ServletWebRequest(request, response));
      }
      return Optional.of(new ServletWebRequest(request));
    }
    return Optional.empty();
  }
}
