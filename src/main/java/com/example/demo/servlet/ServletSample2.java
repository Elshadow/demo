package com.example.demo.servlet;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第二种创建servlet的方法，通过使用注解ServletComponentScan和WebServlet
 */
@WebServlet(name = "servletSample2", urlPatterns = "/servlet/sample2")
public class ServletSample2 extends HttpServlet {

    private static final long serialVersionUID = 2124558453090053383L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("servlet2 is inited");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) {
        Map<String, String[]> params = req.getParameterMap();
        System.out.println("*********doGet*********");
        if (params != null && !params.isEmpty()) {
            Iterator<Map.Entry<String, String[]>> entries = params.entrySet().iterator();

            // 读取请求参数信息
            while (entries != null && entries.hasNext()) {
                Map.Entry<String, String[]> entry = entries.next();
                System.out.println("request param name is " + entry.getKey());
                System.out.println("request param value is " + entry.getValue()[0]);
            }
        }
        
        System.out.println("handle doGet request");
        System.out.println("*********doGet*********");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rep) {
        Map<String, String[]> params = req.getParameterMap();
        System.out.println("*********doPost*********");
        if (params != null && !params.isEmpty()) {
            Iterator<Map.Entry<String, String[]>> entries = params.entrySet().iterator();

            // 读取请求参数信息
            while (entries != null && entries.hasNext()) {
                Map.Entry<String, String[]> entry = entries.next();
                System.out.println("request param name is " + entry.getKey());
                System.out.println("request param value is " + entry.getValue()[0]);
            }
        }
        
        System.out.println("handle doPost request");
        System.out.println("*********doPost*********");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet2 is destroy");
    }
    
}