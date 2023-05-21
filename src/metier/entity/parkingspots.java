/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier.entity;

/**
 *
 * @author Halaili
 */
public class parkingspots {
    private int PS_ID;
    private String Status;
    private String Etage;

    public parkingspots()
    {
        
    }
public parkingspots(String Status,String Etage)
{
    this.Status=Status;
    this.Etage=Etage;
}

    public void setId(int PS_ID) {
        this.PS_ID = PS_ID;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setEtage(String Etage) {
        this.Etage = Etage;
    }

    public int getId() {
        return PS_ID;
    }

    public String getStatus() {
        return Status;
    }

    public String getEtage() {
        return Etage;
    }

}
