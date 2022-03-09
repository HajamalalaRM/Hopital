/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import util.Connexion;

/**
 *
 * @author Haja
 */
public class Service {
    Integer idservice;
    Integer idpatient;
    String datyentre;

    public Service() {
    }

    public void sortiePatientService(Integer idservice) throws SQLException
    {
        System.out.println("Sortie du patient");
        String req= "INSERT INTO public.finservice(idfinservice, idservice, datefin) VALUES (nextval('finservice_idfinservice_seq'::regclass), "+idservice+", now());";
        System.out.println(req);
        Connexion c=new Connexion();
        java.sql.Statement stmt=c.getConnection().createStatement();
        try{
            stmt.executeUpdate(req);
                        c.commit();

        }catch(Exception e){
            e.printStackTrace();
            c.rollback();
            System.out.println(" Malade non inseree");
        }finally{       
        c.close();
        }  
    }
    public Integer entrePatientService(Patient patient)throws Exception
    {
        Facture fact = new Facture();
        Detail_facture detfact = new Detail_facture();
        Integer idservice = this.getMaxIdService()+1;
        Integer idfacture = fact.getMaxidfacture()+1;
        Integer iddetail_facture = detfact.getMaxidDetail_facture()+1;        
        
        String reqservice = "INSERT INTO public.service(idservice,idpatient,datyentre) VALUES ("+idservice+","+patient.getId()+",now())";
        String reqfacture = "INSERT INTO public.facture(id,idservice,etat) VALUES("+idfacture+","+idservice+",'payé');";
        String reqdet_facture = "INSERT INTO public.detail_facture(iddetail,objet,prixunit,nombre,prixfinal,payement_actu,etat,idfacture)"
                + " VALUES("+iddetail_facture+",'avance',200000.0,1,200000.0,200000.0,'payé',"+idfacture+") ;";
         Connexion c=new Connexion();
        java.sql.Statement stmt=c.getConnection().createStatement();
        try{
            stmt.executeUpdate(reqservice);
            stmt.executeUpdate(reqfacture);           
            stmt.executeUpdate(reqdet_facture);           
            c.commit();
            System.out.println("Malade inserer");
            return idservice;
        }catch(Exception e){
            c.rollback();
            System.out.println(" Malade non inseree");
        }finally{       
        c.close();
        }  
        return idservice;
    }

      public Integer getMaxIdService()throws Exception{
        String req = "select MAX(idservice) from service;";
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

    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public String getDatyentre() {
        return datyentre;
    }

    public void setDatyentre(String datyentre) {
        this.datyentre = datyentre;
    }
    
}
