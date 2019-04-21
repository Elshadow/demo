package com.example.demo.servlet;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第一种配置servlet的方法，通过配置ServletRegistrationBean
 * 两种配置servlet的方法可以并存使用
 * 其实创建servlet的方法还可以是实现Servlet接口及继承至抽象类GenericServlet
 */
public class ServletSample extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("servlet is inited");
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

        rep.setContentType("text/html");
        rep.setHeader("refresh", "5");
        try {
            PrintWriter out = rep.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>welcome this is my servlet!!!Page Refresh after 5s</h1>");
            out.println("</body>");
            out.println("</html>");
            out.flush();
        } catch (Exception e) {
            //TODO: handle exception
        }
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
        System.out.println("servlet is destroy");
    }

}