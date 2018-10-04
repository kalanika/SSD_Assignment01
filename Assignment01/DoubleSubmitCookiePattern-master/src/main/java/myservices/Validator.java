package myservices;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Validator extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            String id = req.getParameter("id");
            String key = req.getParameter("key");
            String CSRFTokenRecieved = req.getParameter("tokentxt");
            out.println("Registration Number :" + id);
            out.println("Password :" + key);
            out.println("Token Received :" + CSRFTokenRecieved);
            Cookie[] cookies = req.getCookies();
            String CSRFToken = cookies[0].getValue();
            out.println("Token :"+CSRFToken);
            if (CSRFTokenRecieved.equals(CSRFToken)) {
                out.println("Verified Successfully !!");
            } else {
                out.println("Verification Failed !!");
            }
        }finally {
            out.close();
        }

    }
}
