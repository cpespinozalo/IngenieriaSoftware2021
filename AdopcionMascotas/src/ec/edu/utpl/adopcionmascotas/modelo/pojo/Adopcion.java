package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import java.io.Serializable;

public class Adopcion implements Serializable{
    
    private Auditoria auditoria;
    
    private static final long serialVersionUID = 1L;
    private Integer sesionId;
    private Integer cadopcion;
    private Integer cmascota;
    private String cusuarioadopcion;
    private String fadopcion;
    private String estadoadopcion;

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Integer getSesionId() {
        return sesionId;
    }

    public void setSesionId(Integer sesionId) {
        this.sesionId = sesionId;
    }

    public Integer getCadopcion() {
        return cadopcion;
    }

    public void setCadopcion(Integer cadopcion) {
        this.cadopcion = cadopcion;
    }

    public Integer getCmascota() {
        return cmascota;
    }

    public void setCmascota(Integer cmascota) {
        this.cmascota = cmascota;
    }

    public String getCusuarioadopcion() {
        return cusuarioadopcion;
    }

    public void setCusuarioadopcion(String cusuarioadopcion) {
        this.cusuarioadopcion = cusuarioadopcion;
    }

    public String getFadopcion() {
        return fadopcion;
    }

    public void setFadopcion(String fadopcion) {
        this.fadopcion = fadopcion;
    }

    public String getEstadoadopcion() {
        return estadoadopcion;
    }

    public void setEstadoadopcion(String estadoadopcion) {
        this.estadoadopcion = estadoadopcion;
    }
    
    
    
}
