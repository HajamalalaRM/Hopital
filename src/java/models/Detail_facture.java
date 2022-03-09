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
public class Detail_facture {
    Integer iddetail;
    Integer idfacture;
    String objet;
    Double prixunit;

    public Detail_facture(){
    }
public Integer getMaxidDetail_facture()throws Exception{
         String req = "select MAX(iddetail) from detail_facture;";
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
    public Integer getIddetail() {
        return iddetail;
    }

    public void setIddetail(Integer iddetail) {
        this.iddetail = iddetail;
    }

    public Integer getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Double getPrixunit() {
        return prixunit;
    }

    public void setPrixunit(Double prixunit) {
        this.prixunit = prixunit;
    }
    
    
}
