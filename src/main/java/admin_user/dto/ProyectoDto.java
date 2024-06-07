package admin_user.dto;

import admin_user.model.Proyecto;

public class ProyectoDto {

    private Integer idProyecto;
    private Integer idCliente;
    private Integer idIngeniero;
    private Integer idTecnico;
    private Integer idComercial;
    private String fechaInicio;
    private String fechaFin;
    private String comentario;
    private String codFuncionalidad;

    public ProyectoDto() {
    }

    public ProyectoDto(Integer idCliente, Integer idIngeniero, Integer idTecnico, Integer idComercial, String fechaInicio, String fechaFin, String comentario, String codFuncionalidad) {
        this.idCliente = idCliente;
        this.idIngeniero = idIngeniero;
        this.idTecnico = idTecnico;
        this.idComercial = idComercial;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comentario = comentario;
        this.codFuncionalidad = codFuncionalidad;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }
    
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Integer getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(Integer idComercial) {
        this.idComercial = idComercial;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCodFuncionalidad() {
        return codFuncionalidad;
    }

    public void setCodFuncionalidad(String codFuncionalidad) {
        this.codFuncionalidad = codFuncionalidad;
    }

    
}
