/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import metier.entity.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Nesrine MEDDEB
 */
public class ScolariteImpl implements IScolarite{
    @Override
    public void addEtudiant(user e)
    {
        Connection con = Connexion.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (nom, prenom, email, password, type) VALUES (?, ?, ?, ?, ?)");

            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPassword());
            ps.setString(5, e.getRole());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ajout utilisateur avec succès!");

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
    }
    @Override
    public List<user> getAllEtudiant()
    {
        Connection con = Connexion.getConnect();
        List <user> liste=new ArrayList<>();
        try
        {
            PreparedStatement ps = con.prepareStatement("select * from user");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                user e=new user();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrenom(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPassword(rs.getString(5));
                e.setRole(rs.getString(6));

                liste.add(e);
               
            }
            
        }
         catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        return liste;
        
    }
    @Override
    public void modifierEtudiant(String nom,String prenom,String email,String password, String role,int id)
    {
        Connection con = Connexion.getConnect();

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE user SET nom=?, prenom=?, email=?, password=?, type=? WHERE id=?");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, role);
            ps.setInt(6, id);

            ps.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
    
    public void supprimerEtudiant(int id)
    {
        Connection con = Connexion.getConnect();

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM User WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    public List<user> getEtudiantRecherche(String rech)
    {
        Connection con = Connexion.getConnect();
        List<user> liste = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM User WHERE nom LIKE ?");
            ps.setString(1, "%" + rech + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user e = new user();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrenom(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPassword(rs.getString(5));
                e.setRole(rs.getString(6));
                liste.add(e);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return liste;
    }
    
    
    public user getEtudiantByID(int id) {
        Connection con = Connexion.getConnect();
        user e = null;
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                e = new user();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrenom(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPassword(rs.getString(5));
                e.setRole(rs.getString(6));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
        return e;
    }

}
