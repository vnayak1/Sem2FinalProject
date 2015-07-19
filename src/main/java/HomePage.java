/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import javax.json.*;

import DatabaseCredentials.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vinayak
 */


public class HomePage extends HttpServlet {
    
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiii");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        response.setContentType("text/html;charset=UTF-8");
        Connection con = database.getConnection();
        PrintWriter out = response.getWriter();

        out.write("hiiiiiiiiiiiiii");
       

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

        //out.write(productarray.toString());
        
        }
        
        

//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//
//            out.println("<html><body><h2>The Select query has following results : </h2>");
//            out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
//            out.println("<tr>");
//            out.println("<td><b>First Name</b></td>");
//            out.println("<td><b>Last Name</b></td>");
//            out.println("<td><b>Email</b></td>");
//            out.println("</tr>");
//
//            while (rs.next()) {
//                out.println("<tr>");
//                out.println("<td>" + rs.getString(1) + "</td>");
//                out.println("<td>" + rs.getString(2) + "</td>");
//                out.println("<td>" + rs.getString(3) + "</td>");
//                out.println("</tr>");
//
//            }
//
//            out.println("</table></br><hr></body></html>");
//        }
    catch (SQLException e) {

            e.printStackTrace();
       }

//                if(con == null ){
//
//                out.println("connnection is null");
//                }
//
//                else{
//
//                out.println("connnection is success");
//                }
    }

}
