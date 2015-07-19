/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DatabaseCredentials.database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinayak
 */
public class homepage1 extends HttpServlet {

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
            out.println("<title>Servlet homepage1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homepage1 at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
   
         response.setContentType("text/html;charset=UTF-8");
        Connection con = database.getConnection();
        PrintWriter out = response.getWriter();

        out.write("hiiiiiiiiiiiiii123");
       

        JsonObjectBuilder json = Json.createObjectBuilder();
        JsonArrayBuilder productarray = Json.createArrayBuilder();

       // JsonObjectBuilder json = Json.createObjectBuilder();
       // JsonArrayBuilder productarray = Json.createArrayBuilder();
    
        
        String query = "select * from master_data";
        
        try{
        
                      Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);
                                
                  
       while (rs.next()) {

         
            json = Json.createObjectBuilder()
                       .add("productID", rs.getString(1))
                       .add("name", rs.getString(2))
                       .add("description", rs.getString(3));
                       
              productarray.add(json);
       }        

       out.write(productarray.toString());
        
        }  catch (SQLException e) {

            e.printStackTrace();
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
