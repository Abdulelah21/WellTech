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
public class BrowseAllRepairRecords extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("UserName");

        if (userName != null) {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>\n"
                        + "<html dir=\"ltr\">\n"
                        + "\n"
                        + "    <head>\n"
                        + "        <meta charset=\"utf-8\">  \n"
                        + "        <title>About us</title>\n"
                        + "        <meta name=\"description\" content=\"An interactive getting started guide for Brackets.\">\n"
                        + "        <link rel=\"stylesheet\" href=\"css/style.css\">\n"
                        + "    </head>\n"
                        + "    <body  >\n"
                        + "        <header>\n"
                        + "            <div class=\"container\">\n"
                        + "                <a href=\"#\" id=\"logo\">\n"
                        + "                    <img src=\"images/logo.png\">\n"
                        + "\n"
                        + "                </a>\n"
                        + "                <nav id=\"navbar\">\n"
                        + "                    <ul>\n"
                        + "                        <li >\n"
                        + "                            <a href=\"servletIndex\">Home</a>\n"
                        + "                        </li>\n"
                        + "                        <li>\n"
                        + "                            <a href=\"servletAddnewRequest\">Add New Repair Request</a>\n"
                        + "\n"
                        + "                        </li>\n"
                        + "                        <li class=\"current\">\n"
                        + "                            <a href=\"BrowseAllRepairRecords\">Browse All Repair Records</a>\n"
                        + "\n"
                        + "                        </li>\n"
                        + "                        <li ></li>\n"
                        + "                        <a href=\"servletFeedback\">Feedback</a>\n"
                        + "\n"
                        + "                        </li>\n"
                        + "                        <li>\n"
                        + "                        <a href=\"logout\">Logout</a>\n"
                        + "                        \n"
                        + "                      </li>\n"                      
                        + "\n"
                        + "                    </ul>\n"
                        + "\n"
                        + "                </nav>\n"
                        + "\n"
                        + "\n"
                        + "            </div>\n"
                        + "        </header>\n"
                        + "        <div id=\"record\">\n"
                        + "            <div class=\"container\">\n"
                        + "                <h1>\n"
                        + "                    All Repair Records\n"
                        + "                </h1>\n"
                        + "<div class = table>");

                // here we but the table code 
                out.println("<div>");

                dbConnntion db = new dbConnntion();
                Connection conn = db.getConnection();

                String sql = "select * from repairs";

                PreparedStatement pStmt = conn.prepareStatement(sql);
                ResultSet rs = pStmt.executeQuery();

                if (!rs.isBeforeFirst()) {
                    out.println("<p> No registration records in database! </p>");
                } else {
                    out.println("<table border='1'>");

                    out.println("<tr> <th> ID </th> <th> Computer Owner </th> <th> Type </th> <th> Model </th>"
                            + " <th> Problems </th> <th> Repair Status </th> <th> Repair Cost </th> <th> Repair Finish  </th> "
                            + "<th> Repair Delivery </th></tr>");

                    while (rs.next()) {

                        out.println("<tr>");

                        out.println("<td>" + rs.getInt("id") + "</td>");
                        out.println("<td>" + rs.getString("Computer_Owner") + "</td>");
                        out.println("<td>" + rs.getString("Type") + "</td>");
                        out.println("<td>" + rs.getString("Model") + "</td>");
                        out.println("<td>" + rs.getString("Problems") + "</td>");
                        out.println("<td>" + rs.getString("Repair_Status") + "</td>");
                        out.println("<td>" + rs.getFloat("Repair_Cost") + "</td>");
                        out.println("<td>" + rs.getTimestamp("Repair_Finish_DateTime") + "</td>");
                        out.println("<td>" + rs.getTimestamp("Repair_Delivery_DateTime") + "</td>");
                        out.println("</tr>");

                    }
                    out.println("</table>");
                }

                conn.close();

                out.print("</div>"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "        <footer>\n"
                        + "            <div class=\"container\">\n"
                        + "\n"
                        + "                <p>Coded by Abed and Abdulelah with love</p>\n"
                        + "                <p>All rights reserved &copy;</p>\n"
                        + "\n"
                        + "            </div>\n"
                        + "        </footer>\n"
                        + "\n"
                        + "\n"
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
            request.getRequestDispatcher("/ErrAccess.html").forward(request, response);
        }

    }
}
