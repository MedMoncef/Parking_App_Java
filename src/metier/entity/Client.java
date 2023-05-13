/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier.entity;

/**
 *
 * @author Nesrine Meddeb
 */

public class Client {
     private int id;
 private String nom;
private String prenom;
public Client()
{}
    public Client(String nom,String prenom)
{
    this.nom=nom;
    this.prenom=prenom;
   
}
public int getId()
{
    return id;
}
public void setId(int id)
{
    this.id=id;
}
public String getNom()
{
    return nom;
}
public void setNom(String nom)
{
    this.nom=nom;
}
public String getPrenom()
{
    return prenom;
}
public void setPrenom(String prenom)
{
    this.prenom=prenom;
}


    
}
