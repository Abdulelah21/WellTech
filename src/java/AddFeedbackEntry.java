/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gg
 */
public class AddFeedbackEntry extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
           //***********
        PrintWriter out = response.getWriter();
        try  {

            String uname = request.getParameter("name");
            String country = request.getParameter("Country");
            String email = request.getParameter("email");
            String phone = request.getParameter("Phone");
            int p = Integer. parseInt(phone);
            String subject = request.getParameter("subject");
            String type = request.getParameter("type");
            String msg = request.getParameter("msg");

            //the connection ...
            dbConnntion db = new dbConnntion();
            Connection con = db.getConnection();

            //INSERT INTO FeedBack table 
            String sql = "INSERT INTO feedbacks (Name, Country, Phone, Email, Subject, Type, Message)"
                    + "Values (?,?,?,?,?,?,?) ";
            PreparedStatement pStmt = con.prepareStatement(sql);

            pStmt.setString(1, uname);
            System.out.println(uname);
            pStmt.setString(2, country);
            System.out.println(country);
             pStmt.setInt(3, p);
            System.out.println(p);
            pStmt.setString(4, email);
            System.out.println(phone);
            pStmt.setString(5, subject);
            System.out.println(subject);
            pStmt.setString(6, type);
            System.out.println(type);
            pStmt.setString(7, msg);
            System.out.println(msg);

            int k = pStmt.executeUpdate();     // returns number of affected rows 

            if (k == 1) {
                //insert a record success
                
            request.getRequestDispatcher("/SuccessFullFeedBack.html").forward(request, response);
                out.println("<p class=\"correct\"> Data was added successfully. </p>");
            } else // i.e.  k = 0
            {
                //insert a record error
                request.getRequestDispatcher("/SuccessFullFeedBack.html").forward(request, response);
                out.println("<p class=\"error\"> There was an error in adding the data! Try again. </p>");
            }

            //-----------catch------------
            con.close();
        } catch (Exception ex) {
            //throw new ServletException(ex);
            out.println("<p class=\"error\"> There was an error exception meesage: " + ex + "</p>");
            out.println("</div>");
            out.println("<hr />");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();

        }

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet AddFeedback</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet AddFeedback at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
    
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        

} catch (SQLException ex) {
            Logger.getLogger(AddFeedbackEntry.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (ClassNotFoundException ex) {
            Logger.getLogger(AddFeedbackEntry.class
.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        

} catch (SQLException ex) {
            Logger.getLogger(AddFeedbackEntry.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (ClassNotFoundException ex) {
            Logger.getLogger(AddFeedbackEntry.class
.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>  
    
}




