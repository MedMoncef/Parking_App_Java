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
import metier.entity.parkingspots;

import metier.entity.parkingspots;
public class TableParkingspots extends AbstractTableModel{
    List<parkingspots> parkingspots=new ArrayList<>();
    String titre[]={"PS_ID","Status","Etage"};
    
    @Override
    public int getColumnCount()
    {
        return titre.length;
    }
    @Override
    public int getRowCount()
    {
        return parkingspots.size();
    }
    @Override
    public Object getValueAt(int l, int c)
    {
        switch(c){
            case 0:
                return parkingspots.get(l).getId();
            case 1:
                return parkingspots.get(l).getStatus();
            case 2:
                return parkingspots.get(l).getEtage();
        }
        return null;
    }
    
     @Override
    public String getColumnName(int column)
    {
        return titre[column];
    }
    
    public void chargerTable(List<parkingspots> liste)
    {
        parkingspots=liste;
        fireTableDataChanged();
    }
}
