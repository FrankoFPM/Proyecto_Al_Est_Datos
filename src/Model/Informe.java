package Model;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Informe implements Serializable {

    //private int ID;
    private String accionesTomadas;
    private Date fechaRes;
    private String estado;
    private String descripcion;

    public Informe() {
    }

    public Object[] RegistroInforme(int i) {
        Object[] registro = {i, accionesTomadas, estado, descripcion, getFechaResFormateada()};
        return registro;
    }

    public Informe(String accionesTomadas, Date fechaRes, String estado, String descripcion) {
        
        this.accionesTomadas = accionesTomadas;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaRes = fechaRes;
    }

    /*public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }*/

    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public String getAccionesTomadas() {
        return accionesTomadas;
    }

    public void setAccionesTomadas(String accionesTomadas) {
        this.accionesTomadas = accionesTomadas;
    }

    public Date getFechaRes() {
        return fechaRes;
    }

    public void setFechaRes(Date fechaRes) {
        this.fechaRes = fechaRes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public String getFechaResFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaRes);
    }
}
