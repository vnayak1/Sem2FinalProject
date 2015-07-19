/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DatabaseCredentials.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinayak
 */
public class home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
      //  processRequest(request, response);
        
        
    PrintWriter out = response.getWriter();
   
            out.write("exception coccure123");
    JsonObjectBuilder json = Json.createObjectBuilder();
   JsonArrayBuilder productarray = Json.createArrayBuilder();
   Connection conn = database.getConnection();
        
   
              try {
           Statement smt = conn.createStatement();
           
           
           ResultSet rs = smt.executeQuery("select * from master_data ");
      

     
       while (rs.next()) {

          
            json = Json.createObjectBuilder()
                        .add("name", rs.getString(1))
                       .add("description", rs.getString(2))
                       .add("quantity", rs.getString(3));
              productarray.add(json);
       }
       
       out.write(productarray.toString());
       
       
         } catch (SQLException ex) {
             
             out.write("exception coccure");
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
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
       // processRequest(request, response);
        
          PrintWriter out = response.getWriter();
   
            out.write("exception coccure123");
    JsonObjectBuilder json = Json.createObjectBuilder();
   JsonArrayBuilder productarray = Json.createArrayBuilder();
   Connection conn = database.getConnection();
        
   
              try {
           Statement smt = conn.createStatement();
           
           
           ResultSet rs = smt.executeQuery("select * from master_data ");
      

     
       while (rs.next()) {

          
            json = Json.createObjectBuilder()
                        .add("name", rs.getString(1))
                       .add("description", rs.getString(2))
                       .add("quantity", rs.getString(3));
              productarray.add(json);
       }
       
       out.write(productarray.toString());
       
       
         } catch (SQLException ex) {
             
             out.write("exception coccure");
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
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
