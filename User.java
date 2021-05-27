/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TPC
 */
public class User {
    private int id;
    private String nom,prenom,login,mdp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public User(String nom, String prenom, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
    }

    public User() {
    }
    
      public boolean authentifier() throws SQLException
    {
      Connexion c = new Connexion(); //appel de connexion à la BD
        PreparedStatement pst; 
        pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM `utilisateur` WHERE `login`='"+this.getLogin()+"' AND mdp='"+this.mdp+"' "); // lister les admins
        pst.executeQuery(); // lister les admins
        ResultSet rs = (ResultSet) pst.executeQuery(); // stocker le résultat dans un resultset
        if(rs.next()) {
           // System.out.println(rs.getString("nom")); //teste d’affichage
           return true;
        }
        else
            return false;
    
    
    }

       public void ajout() {
        try {
// TODO add your handling code here:
            Connexion c = new Connexion();
            java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `utilisateur`(`nom`, `prenom`, `login`, `mdp`) VALUES('" + this.getNom()+ "','" + this.getPrenom() + "','" + this.getLogin() + "','" + this.getMdp() + "')");
            statement.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex);

        }

    }
    
}
