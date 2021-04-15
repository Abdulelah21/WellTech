/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gg
 */
public class login extends HttpServlet {

    public static String md5(String input) {
        String md5 = null;
        if (null == input) {
            return null;
        }
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet login</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);              //????????????

        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("Password");

        try {

            //the connection ...
            dbConnntion db = new dbConnntion();
            Connection con = db.getConnection();

            PreparedStatement st
                    = con.prepareStatement(
                            "select * from users where UserName =  ? and  Password = ?");
            st.setString(1, UserName);
            st.setString(2, md5(Password));

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();

                session.setAttribute("UserName", UserName);
                request.getRequestDispatcher("/indexLoggedin.html").forward(request, response);
            } else {
                request.getRequestDispatcher("/login.html").forward(request, response);
            }
            st.close();

        } catch (Exception ex) {
            out.println("<p class=\"error\"> There was an error exception meesage: " + ex + "</p>");
            ex.printStackTrace();

          // request.getRequestDispatcher("/errRegister.html").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
