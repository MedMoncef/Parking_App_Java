/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

/**
 *
 * @author Nesrine MEDDEB
 */
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import metier.entity.Client;
import metier.entity.user;
public class TableModele extends AbstractTableModel{
    List<user> etudiants=new ArrayList<>();
    String titre[]={"Id","Nom","Prenom","Email","Password","Role"};
    
    @Override
    public int getColumnCount()
    {
        return titre.length;
    }
    @Override
    public int getRowCount()
    {
        return etudiants.size();
    }
    @Override
    public Object getValueAt(int l,int c)
    {
        switch(c){
            case 0:
                return etudiants.get(l).getId();
            case 1:
                return etudiants.get(l).getNom();
            case 2:
                return etudiants.get(l).getPrenom();
            case 3:
                return etudiants.get(l).getEmail();
            case 4:
                return etudiants.get(l).getPassword();
            case 5:
                return etudiants.get(l).getRole();
        }
        return null;
    }
    
     @Override
    public String getColumnName(int column)
    {
        return titre[column];
    }
    
    public void chargerTable(List<user> liste)
    {
        etudiants=liste;
        fireTableDataChanged();
    }
}
