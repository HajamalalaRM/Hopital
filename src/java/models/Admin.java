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
public class Admin {
    Integer id;
    String nom;
    String password;

    public boolean verrifAdmin(String nom, String password) throws SQLException
    {
        boolean exist = false;
          Connexion c=new Connexion();
         String req="SELECT count(*) FROM public.admin where nom='"+nom+"' and password='"+password+"';";
         System.out.println(req);
        java.sql.Statement stmt=c.getConnection().createStatement();
        ResultSet res =stmt.executeQuery(req);
        while(res.next()){           
            if(res.getInt("count")>0)exist=true;           
        }
        c.close();
        return exist;
    }
    public Admin() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
