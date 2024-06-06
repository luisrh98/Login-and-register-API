package admin_user.dto;

import admin_user.model.Proyecto;

public class ProyectoDto {

    private int id_proyecto;
    private int id_cliente;
    private int id_ingeniero;
    private int id_tecnico;
    private int id_comercial;
    private String fecha_inicio;
    private String fecha_fin;
    private String comentario;
    private int cod_funcionalidad;

    public ProyectoDto() {
    }

    public ProyectoDto(int id_cliente, int id_ingeniero, int id_tecnico, int id_comercial, String fecha_inicio, String fecha_fin, String comentario, int cod_funcionalidad) {
        this.id_cliente = id_cliente;
        this.id_ingeniero = id_ingeniero;
        this.id_tecnico = id_tecnico;
        this.id_comercial = id_comercial;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.comentario = comentario;
        this.cod_funcionalidad = cod_funcionalidad;
    }

    public ProyectoDto(Proyecto p) {
        this.id_cliente = p.getId_cliente();
        this.id_ingeniero = p.getId_ingeniero();
        this.id_tecnico = p.getId_tecnico();
        this.id_comercial = p.getId_comercial();
        this.fecha_inicio = p.getFecha_inicio();
        this.fecha_fin = p.getFecha_fin();
        this.comentario = p.getComentario();
        this.cod_funcionalidad = p.getCod_funcionalidad();
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_ingeniero() {
        return id_ingeniero;
    }

    public void setId_ingeniero(int id_ingeniero) {
        this.id_ingeniero = id_ingeniero;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public int getId_comercial() {
        return id_comercial;
    }

    public void setId_comercial(int id_comercial) {
        this.id_comercial = id_comercial;
    }

    public int getCod_funcionalidad() {
        return cod_funcionalidad;
    }

    public void setCod_funcionalidad(int cod_funcionalidad) {
        this.cod_funcionalidad = cod_funcionalidad;
    }

}
