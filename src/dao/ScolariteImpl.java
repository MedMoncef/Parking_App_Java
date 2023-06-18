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
    //=================================================================================
        @Override
    public List<parkingspots> getAllParkings()
    {
        Connection con = Connexion.getConnect();
        List <parkingspots> liste=new ArrayList<>();
        try
        {
            PreparedStatement ps = con.prepareStatement("select * from parkingspots WHERE Status = ?");
            ps.setString(1, "Available");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                parkingspots e=new parkingspots();
                e.setId(rs.getInt(1));
                e.setStatus(rs.getString(2));
                e.setEtage(rs.getString(3));

                liste.add(e);
               
            }
            
        }
         catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        return liste;
        
    }
    //=================================================================================
        @Override
        public List<reservation> getAllReservations() {
            Connection con = Connexion.getConnect();
            List<reservation> liste = new ArrayList<>();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT R_ID, PS_ID_R, C_ID, Date_Debut, Date_Fin, Duree, Prix FROM reservation");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int R_ID = rs.getInt("R_ID");
                    int PS_ID_R = rs.getInt("PS_ID_R");
                    int C_ID = rs.getInt("C_ID");
                    String Date_Debut = rs.getString("Date_Debut");
                    String Date_Fin = rs.getString("Date_Fin");
                    int Duree = rs.getInt("Duree");
                    double Prix = rs.getDouble("Prix");

                    reservation reservation = new reservation(R_ID, PS_ID_R, C_ID, Date_Debut, Date_Fin, Duree, Prix);
                    liste.add(reservation);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return liste;
        }
        
        @Override
            public void modifierReservation(String dateDebut, String dateFin, String duree, String prix, int reservationId) {
                Connection con = Connexion.getConnect();

                try {
                    PreparedStatement ps = con.prepareStatement("UPDATE reservation SET Date_Debut=?, Date_Fin=?, Duree=?, Prix=? WHERE R_ID=?");
                    ps.setString(1, dateDebut);
                    ps.setString(2, dateFin);
                    ps.setString(3, duree);
                    ps.setString(4, prix);
                    ps.setInt(5, reservationId);

                    ps.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            public void supprimerReservation(int reservationId) {
                Connection con = Connexion.getConnect();

                try {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM reservation WHERE R_ID=?");
                    ps.setInt(1, reservationId);
                    ps.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }


        public List<reservation> getReservationRecherche(String rech) {
            Connection con = Connexion.getConnect();
            List<reservation> liste = new ArrayList<>();

            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM reservation WHERE nom LIKE ?");
                ps.setString(1, "%" + rech + "%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    reservation reservation = new reservation();
                    reservation.setR_ID(rs.getInt(1));
                    // Set other properties based on the table structure
                    liste.add(reservation);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return liste;
        }

        public reservation getReservationByID(int reservationId) {
            Connection con = Connexion.getConnect();
            reservation reservation = null;

            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM reservation WHERE R_ID=?");
                ps.setInt(1, reservationId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    reservation = new reservation();
                    reservation.setR_ID(rs.getInt(1));
                    // Set other properties based on the table structure
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            return reservation;
        }

    //=================================================================================
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
