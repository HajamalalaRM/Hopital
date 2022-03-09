/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Chambre;
import models.Patient;
import models.Service;

/**
 *
 * @author Haja
 */
public class PatientController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           if(((String)request.getParameter("act")).compareTo("insert")==0 ){       
           String nom = request.getParameter("nom");
           String prenom = request.getParameter("prenom");
           String sexe = request.getParameter("sexe");
           String datenaissance = request.getParameter("datenaissance");
           String contact = request.getParameter("contact");
           Patient p = new Patient();
           p.setNom(nom);
           p.setPrenom(prenom);
           p.setSexe(sexe);
           p.setDate_naissance(datenaissance);
           p.setContact(contact);
           try{
                Integer id = p.insertPatient();
                p.setId(id);
                request.setAttribute("patient", p);
                 RequestDispatcher disp = request.getRequestDispatcher("Patient.jsp?patient=true");
                 disp.forward(request, response);
           }catch(Exception e){
            e.printStackTrace();
           }
           }else if( ((String)request.getParameter("act")).compareTo("entre")==0  ){
               Integer id = Integer.parseInt((String)request.getParameter("id"));              
               Patient p = new Patient();
               p.setId(id);             
               Service serv = new Service();
               Chambre ch = new Chambre();
               Vector<Chambre> chambres = new Vector<Chambre>();
               chambres = ch.getAllChambre();
               try{
               Integer idserv = serv.entrePatientService(p);
                request.setAttribute("idpatient", id);
                request.setAttribute("idservice", idserv);
                request.setAttribute("chambres", chambres);
                 RequestDispatcher disp = request.getRequestDispatcher("Chambre.jsp?insertpatient=true");
                 disp.forward(request, response);
               }catch(Exception e){
                   e.printStackTrace();
               }
           }else if(((String)request.getParameter("act")).compareTo("chambre")==0 ){
               Chambre ch = new Chambre();
               try{
               ch.entreChambrePatient(Integer.parseInt((String)request.getParameter("idservice")),Integer.parseInt((String)request.getParameter("idchambre")));
               RequestDispatcher disp = request.getRequestDispatcher("Docteur.jsp?list=true");
                 disp.forward(request, response);
               }catch(Exception e){
                   e.printStackTrace();
               }              
           } else if(((String)request.getParameter("act")).compareTo("sortir")==0 ){          
               Service serv = new Service();
               serv.setIdservice(Integer.parseInt((String)request.getParameter("idservice")));
               try{
               serv.sortiePatientService(serv.getIdservice());
               }catch(Exception e){
                   
               }
                
               
              Patient p =new Patient();
              Vector<Patient> vect = p.getPatientActuel();              
              request.setAttribute("listepatientactu", vect);
               RequestDispatcher disp = request.getRequestDispatcher("Patient.jsp?list=true");
                disp.forward(request, response);
           }else if(((String)request.getParameter("act")).compareTo("list")==0){
               Patient p =new Patient();
              Vector<Patient> vect = p.getPatientActuel();              
              request.setAttribute("listepatientactu", vect);
               RequestDispatcher disp = request.getRequestDispatcher("Patient.jsp?list=true");
                disp.forward(request, response);
           }
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
