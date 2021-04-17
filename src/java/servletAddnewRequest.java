/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
//request.getRequestDispatcher("/AddRequest.html").forward(request, response);
public class servletAddnewRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("UserName");

        if (userName != null) {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>\n"
                        + "<html dir=\"ltr\">\n"
                        + "    \n"
                        + "    <head>\n"
                        + "        <meta charset=\"utf-8\">  \n"
                        + "        <title>Books</title>\n"
                        + "        <meta name=\"description\" content=\"An interactive getting started guide for Brackets.\">\n"
                        + "        <link rel=\"stylesheet\" href=\"css/style.css\">\n"
                        + "        <script src=\"js/Site.js\"></script>\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "        <header>\n"
                        + "        <div class=\"container\">\n"
                        + "            <a href=\"#\" id=\"logo\">\n"
                        + "                <img src=\"images/logo.png\">\n"
                        + "                \n"
                        + "            </a>\n"
                        + "            <nav id=\"navbar\">\n"
                        + "                <ul>\n"
                        + "                    <li>\n"
                        + "                    <a href=\"servletIndex\">Home</a>\n"
                        + "                    </li>\n"
                        + "                    <li class=\"current\">\n"
                        + "                    <a href=\"servletAddnewRequest\">Add New Repair Request</a>\n"
                        + "                    \n"
                        + "                    </li>\n"
                        + "                    <li>\n"
                        + "                    <a href=\"BrowseAllRepairRecords\">Browse All Repair Records</a>\n"
                        + "                    \n"
                        + "                    </li>\n"
                        + "                    <li>\n"
                        + "                    <a href=\"servletFeedback\">Feedback</a>\n"
                        + "                    \n"
                        + "                    </li>\n"
                        + "                    <li>\n"
                        + "                    <a href=\"logout\">Logout</a>\n"
                        + "                    \n"
                        + "                    </li>\n"
                        + "                    \n"
                        + "                \n"
                        + "                </ul>\n"
                        + "                \n"
                        + "            </nav>\n"
                        + "            \n"
                        + "            \n"
                        + "            </div>\n"
                        + "        </header>\n"
                        + "        <div id=\"addReq\">\n"
                        + "            <div class=\"container\">\n"
                        + "                <h1>Add New Repair Request</h1>\n"
                        + "                <form id=\"AddRequest\" action=\"AddNewRepairRequest\" method=\"POST\" onsubmit=\"return validateAddRequest();\">\n"
                        + "                    <div class=\"container\">\n"
                        + "                        \n"
                        + "                        <label>Computer Owner: </label>\n"
                        + "                        <span class=\"error\" id=\"errName\"> </span>\n"
                        + "                        <br/>\n"
                        + "                        <input type=\"text\" id=\"fname\" name=\"Computer_Owner\" placeholder=\"Your name...\">\n"
                        + "                        <br/>\n"
                        + "                        <br/>\n"
                        + "                        <label>Computer Serial Number: </label>\n"
                        + "                        <span class=\"error\" id=\"errCoputerSerialNumber\"> </span>\n"
                        + "                        <br/>\n"
                        + "                        <input type=\"text\" id=\"ComputerNumber\" name=\"Computer_Number\" placeholder=\"The Serial Number...\">\n"
                        + "                        <br/>\n"
                        + "                        <br/>\n"
                        + "                        \n"
                        + "                        <label>Type: </label>\n"
                        + "                        <span class=\"error\" id=\"errType\"> </span>\n"
                        + "                        <br/>\n"
                        + "                        <select name=\"typeOfDevice\" id=\"typeOfDevice\">\n"
                        + "                            <br/>\n"
                        + "                            <option> Please select your device... </option>\n"
                        + "                            <option value=\"desktop\">Desktop</option>\n"
                        + "                            <option value=\"laptop\">Labtop</option>\n"
                        + "                            <option value=\"tablet\">Tablet</option>\n"
                        + "                        </select>\n"
                        + "                        <br/>\n"
                        + "                        <br/>\n"
                        + "                        <label>Model: </label>\n"
                        + "                        <span class=\"error\" id=\"errModel\"> </span>\n"
                        + "                        <br/>\n"
                        + "                        <input type=\"text\" id=\"model\" name=\"Model\" placeholder=\"Your Model...\">\n"
                        + "                        <br/>\n"
                        + "                        <br/>\n"
                        + "                        <label>Memory GB: </label>\n"
                        + "                        <span class=\"error\" id=\"errMemoryGB\"> </span>\n"
                        + "                        <br/>                     <!--here i change the id for the subject becouse the js code is not work  with multblu object with same id -->\n"
                        + "                        <select name=\"memoryList\" id=\"memoryList\">\n"
                        + "                            \n"
                        + "                            <option> Please select your Memory GB... </option>\n"
                        + "                            <option>8</option>\n"
                        + "                            <option>16</option>\n"
                        + "                            <option>32</option>\n"
                        + "                           \n"
                        + "                            \n"
                        + "                        </select>\n"
                        + "                        <br/>\n"
                        + "                        <br/>\n"
                        + "                        <label>HardDisk GB: </label>\n"
                        + "                        <span class=\"error\" id=\"errHardDiskGB\"> </span>\n"
                        + "                        <br/>\n"
                        + "                        <select name=\"hardDiskList\" id=\"hardDiskList\">\n"
                        + "                            \n"
                        + "                            <option> Please select your HardDisk GB... </option>\n"
                        + "                            <option>8</option>\n"
                        + "                            <option>16</option>\n"
                        + "                            <option>32</option>\n"
                        + "                           \n"
                        + "                            \n"
                        + "                        </select>\n"
                        + "\n"
                        + "                        <br/>\n"
                        + "                        <br/>\n"
                        + "\n"
                        + "                        \n"
                        + "                        \n"
                        + "                        \n"
                        + "                        <label>Problems: </label>\n"
                        + "                        <span class=\"error\" id=\"errProblems\"> </span>\n"
                        + "                        <br/>\n"
                        + "                        <textarea id=\"problemstxt\" name=\"Problems\" placeholder=\"Write something..\" style=\"height:200px\"></textarea>\n"
                        + "                        <br/> \n"
                        + "                        <br/>\n"
                        + "                        <input id=\"submit\" type=\"submit\" value=\"Submit\">\n"
                        + "                        \n"
                        + "                        \n"
                        + "                        \n"
                        + "                     \n"
                        + "                    </form>  \n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        \n"
                        + "        \n"
                        + "        <footer>\n"
                        + "            <div class=\"container\">\n"
                        + "            \n"
                        + "            <p>Coded by Abed and Abdulelah with love</p>\n"
                        + "            <p>All rights reserved &copy;</p>\n"
                        + "             \n"
                        + "            </div>\n"
                        + "        </footer>\n"
                        + "        \n"
                        + "        \n"
                        + "    </body>\n"
                        + "</html>\n"
                        + "\n"
                        + "");
            } catch (Exception ex) {
                //throw new ServletException(ex);
                out.println("<p class=\"error\"> There was an error exception meesage: " + ex + "</p>");

            } finally {

                out.close();
            }
        } else {

            response.sendRedirect("ErrAccess.html");
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
