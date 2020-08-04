package com.test.demo.alcomarket.security.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AppAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        request.setAttribute("error", e.getLocalizedMessage());
        request.setAttribute("message", "It seems you have not enough rights to see this page. GERARAHEARE MAN, GERARAHER!!!");

//        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
}
