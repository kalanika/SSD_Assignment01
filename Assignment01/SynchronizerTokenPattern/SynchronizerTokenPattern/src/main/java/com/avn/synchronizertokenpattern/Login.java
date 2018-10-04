/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avn.synchronizertokenpattern;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erandi
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            //doPost method will generate a Session ID and store sessionID as a cookie
            throws ServletException, IOException { 
        String sessionid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("sessionid", sessionid);
        cookie.setMaxAge(3600);
        cookie.setSecure(false);
        response.addCookie(cookie);
        service(request, response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Cookie[] cookies = req.getCookies();
            cookies[0].setPath("/");

            if (username.equals("admin") && password.equals("secret")) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                Storage.getStorage().addCookie(cookies[0].getValue(), generateCSRFToken());
                System.out.println("Login CSRF token=" + Storage.getStorage().getCookie(cookies[0].getValue()));
                Storage.getStorage().printCookie();
                resp.sendRedirect("HomePage.jsp");
            } else {
                out.println("Please enter the correct username and password ");
            }
        } finally {
            out.close();
        }
    }

    private static String generateCSRFToken() {
        String CertificateToken = null;
        byte[] bytes = new byte[16];
        try {
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            secureRandom.nextBytes(bytes);
            CertificateToken = new String(Base64.getEncoder().encode(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return CertificateToken;
    }

    
   

}
