/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import util.Connexion;

/**
 *
 * @author Haja
 */
public class Patient {
    Integer id;
    String nom;
    String prenom;
    String date_naissance;
    String sexe;
    String contact;
    
    String chambrenumero;
    String datyentre;
    Integer idservice;
    

    public Patient() {
    }
    
    public Vector<Patient> getPatientActuel()
    {
        Vector<Patient> vect = new Vector<Patient>();
        Connexion con = new Connexion();
        try{
            String reqserv = "SELECT * from patient_actu;";           
            System.out.println(reqserv);
            PreparedStatement stat = con.getConnection().prepareStatement(reqserv);
            ResultSet res = stat.executeQuery();            
            while(res.next())
            {               
                Patient p = new Patient();
                p.setId(res.getInt("id"));                               
                p.setNom(res.getString("nom"));  
                p.setPrenom(res.getString("prenom"));                               
                p.setDate_naissance(res.getString("datenaissance"));
                p.setSexe(res.getString("sexe"));
                p.setContact(res.getString("contact"));
                p.setChambrenumero(res.getString("numero"));
                p.setDatyentre(res.getString("datyentre"));
                p.setIdservice(res.getInt("idservice"));
                vect.add(p);                
            }            
        }catch(Exception e)
        {            
            e.printStackTrace();
        }
        finally{
            con.close();
        }
        return vect;
    }
    
    public Integer insertPatient()throws Exception
    {      
        System.out.println("Insertion patient :");
        Integer iddeb = this.getMaxIdPatient() +1;
        String req="INSERT INTO public.patient(id, nom, prenom, datenaissance, sexe, contact) VALUES ( "+iddeb+""
                + ", '"+this.getNom()+"', '"+this.getPrenom()+"', '"+this.getDate_naissance()+"', '"+this.getSexe()+"',"+this.getContact()+");";
        System.out.println(req);
        Connexion c=new Connexion();
        java.sql.Statement stmt=c.getConnection().createStatement();
        try{
            stmt.executeUpdate(req);          
            c.commit();
            System.out.println("PATIENT inseree");
            return this.getMaxIdPatient();
        }catch(Exception e){
            c.rollback();
            System.out.println("PATIENT non inseree");
            e.printStackTrace();
        }finally{       
        c.close();
        }                      
        return this.getMaxIdPatient();
    }
    public Integer getMaxIdPatient()throws Exception{
        String req = "select MAX(id) from patient;";
        System.out.println(req);
        Integer rep=null;
         Connexion c=new Connexion();
        java.sql.Statement stmt=c.getConnection().createStatement();
        ResultSet res =stmt.executeQuery(req);
        while(res.next()){           
            rep=res.getInt("max");           
        }
        c.close();
        return rep;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSexe() {
        return sexe;
    }

    public String getChambrenumero() {
        return chambrenumero;
    }

    public void setChambrenumero(String chambrenumero) {
        this.chambrenumero = chambrenumero;
    }

    public String getDatyentre() {
        return datyentre;
    }

    public void setDatyentre(String datyentre) {
        this.datyentre = datyentre;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}
