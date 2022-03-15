/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ToDo;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = "/send", name = "Insert")

public class InsertCard extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/viraj", "root", "system manager");

            String title = request.getParameter("title");
            String disc = request.getParameter("desc");
            String query = "insert into inode values (null, '" + title + "', '" + disc + "', current_timestamp)";

            Statement st = conn.createStatement();
            int n = st.executeUpdate(query);
            if (n > 0) {
                response.sendRedirect("index.jsp");

//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
            } else {
                out.append("Not inserted ");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(InsertCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
