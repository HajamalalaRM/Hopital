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
public class Chambre {
    Integer idchambre;
    String numero;
    
    String categorie;
    Integer nombre_lit;
    Double prixsejour;

    public Chambre() {
    }
    
    public void entreChambrePatient(Integer service,Integer idchambre) throws Exception
    {
        Integer idcp = this.getMaxIdChambrePatient() +1;
        String req="INSERT INTO public.chambrepatient(id, idservice, idchambre, date_entre, date_sortie)VALUES ("+idcp+", "+service+", "+idchambre+", now(), null);";
        System.out.println(req);
        Connexion c=new Connexion();
        java.sql.Statement stmt=c.getConnection().createStatement();
        try{
            stmt.executeUpdate(req);          
            c.commit();
            System.out.println("Chambre patient inseree");
        }catch(Exception e){
            c.rollback();
            System.out.println("Chambre patient non inseree");
            e.printStackTrace();
        }finally{       
        c.close();
        }                      
    }
      public Integer getMaxIdChambrePatient()throws Exception{
        String req = "select MAX(id) from chambrepatient;";
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
    public Vector<Chambre> getAllChambre()
    {
        Vector<Chambre> vect = new Vector<Chambre>();
        Connexion con = new Connexion();
        try{
            String req = "SELECT idchambre, numero, categorie, nombre_lit, prixsejour FROM public.chambre join public.categorie_chambre ON chambre.idcategorie_chambre = categorie_chambre.idcategorie_chambre;";           
            PreparedStatement stat = con.getConnection().prepareStatement(req);
            ResultSet res = stat.executeQuery();            
            while(res.next())
            {               
                Chambre ch = new Chambre();
                ch.setIdchambre(res.getInt("idchambre"));
                ch.setNumero(res.getString("numero"));
                ch.setCategorie(res.getString("categorie"));
                ch.setNombre_lit(res.getInt("nombre_lit"));
                ch.setPrixsejour(res.getDouble("prixsejour"));
                vect.add(ch);                
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
    public Integer getLitLibre() throws SQLException
    {
        String req = "SELECT nombre_lit FROM public.chambre join public.categorie_chambre ON chambre.idcategorie_chambre = categorie_chambre.idcategorie_chambre where idchambre="+this.getIdchambre()+";";
        Integer rep=0;
        Connexion c=new Connexion();
        java.sql.Statement stmt=c.getConnection().createStatement();
        ResultSet res =stmt.executeQuery(req);
        while(res.next()){           
            rep=res.getInt("nombre_lit");           
        }
        rep = rep - this.occupe();
        c.close();
        return rep;
    }
    
    public Integer occupe() throws SQLException
    {
        String req = "SELECT count(*) FROM public.chambrepatient  join public.chambre ON chambre.idchambre=chambrepatient.idchambre where  chambre.idchambre="+this.getIdchambre()+" and chambrepatient.date_sortie is NULL;";
         Integer rep=null;
         Connexion c=new Connexion();
        java.sql.Statement stmt=c.getConnection().createStatement();
        ResultSet res =stmt.executeQuery(req);
        while(res.next()){           
            rep=res.getInt("count");           
        }
        c.close();
        return rep;
    }
    public Integer getIdchambre() {
        return idchambre;
    }

    public void setIdchambre(Integer idchambre) {
        this.idchambre = idchambre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getNombre_lit() {
        return nombre_lit;
    }

    public void setNombre_lit(Integer nombre_lit) {
        this.nombre_lit = nombre_lit;
    }

    public Double getPrixsejour() {
        return prixsejour;
    }

    public void setPrixsejour(Double prixsejour) {
        this.prixsejour = prixsejour;
    }

}
