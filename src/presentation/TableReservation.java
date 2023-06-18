package presentation;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import metier.entity.reservation;

public class TableReservation extends AbstractTableModel {
    List<reservation> reservations = new ArrayList<>();
    String[] columnNames = {"R_ID", "PS_ID_R", "C_ID", "Date_Debut", "Date_Fin", "Duree", "Prix"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return reservations.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        reservation reservation = reservations.get(row);
        switch (column) {
            case 0:
                return reservation.getR_ID();
            case 1:
                return reservation.getPS_ID_R();
            case 2:
                return reservation.getC_ID();
            case 3:
                return reservation.getDate_Debut();
            case 4:
                return reservation.getDate_Fin();
            case 5:
                return reservation.getDuree();
            case 6:
                return reservation.getPrix();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setReservations(List<reservation> reservations) {
        this.reservations = reservations;
        fireTableDataChanged();
    }
}