/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class Connexion {
    Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public Connexion(){
        try{
            Class.forName("org.postgresql.Driver");

            this.setConnection(DriverManager.getConnection("jdbc:postgresql://localhost:5432/hopital1","postgres","root"));
            this.getConnection().setAutoCommit(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void close(){
        try{
            this.getConnection().close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void rollback(){
        try{
            this.getConnection().rollback();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void commit(){
        try{
            this.getConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}