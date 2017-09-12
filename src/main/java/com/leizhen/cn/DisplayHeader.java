package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by leizhen on '2017/9/6'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class DisplayHeader extends HttpServlet {
    private static final long serialVersionUID = 797448133989420836L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        String title = "HTTP Header 请求";
        String docType = "<!DOCTYPE html> \n";
        writer.println(docType +
                "<html>\n" +
                "<head><meta charset =\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<table width = \"100\" border = \"1\" align =\"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>Header 名称</th>" +
                "<th>Header 值</th>\n" +
                "</tr>\n");

        Enumeration headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String paramName = (String) headerNames.nextElement();
            writer.println("<tr><td>" + paramName + "</td>\n");
            String paramValue = req.getHeader(paramName);
            writer.println("<td>" + paramValue + "</td></tr>\n");
        }
        writer.println("</table>\n" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
