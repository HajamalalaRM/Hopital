/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import util.Connexion;

/**
 *
 * @author Haja
 */
public class Facture {
    Integer id;
    Integer idservice;
    String etat;

    public Facture() {
    }
 public Integer getMaxidfacture()throws Exception{
         String req = "select MAX(id) from facture;";
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
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
}
