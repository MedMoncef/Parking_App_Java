/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Nesrine Meddeb
 */
import java.util.List;
import metier.entity.*;
public interface IScolarite {
    public void addEtudiant(user e);
    public user getEtudiantByID (int id);
    public List<user> getAllEtudiant();
    public List<parkingspots> getAllParkings();
    public List<user> getEtudiantRecherche(String rech);
    
    
    public void modifierEtudiant(String nom,String prenom,String email,String password, String role,int id);
    public void supprimerEtudiant(int id);
    
    
}
