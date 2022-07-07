/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ToDo;

import com.entities.Note;
import com.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = "/delete", name = "Delete")
public class DeleteCard extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out;
        
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        out.println("hii");
        
        int id = Integer.parseInt(request.getParameter("id"));
        out.println(id);
        
        Note delNote = new Note();
        delNote.setSr_no(id);
        
        SessionFactory factory = FactoryProvider.getFactory();
        Session session = factory.openSession();
        
        Transaction tr = session.beginTransaction();
        session.delete(delNote);
        tr.commit();
        response.sendRedirect("index.jsp");
    }
    
}
