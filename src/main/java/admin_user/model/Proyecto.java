package admin_user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "proyecto", uniqueConstraints = @UniqueConstraint(columnNames = "id_proyecto"))
public class Proyecto {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_ingeniero")
    private Integer idIngeniero;

    @Column(name = "id_tecnico")
    private Integer idTecnico;

    @Column(name = "id_comercial")
    private Integer idComercial;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "fecha_fin")
    private String fechaFin;
    
    private String comentario;
    
    @Column(name = "cod_funcionalidad")
    private String codFuncionalidad;

    public Proyecto() {
        super();
    }

    public Proyecto(Integer idCliente, Integer idIngeniero, Integer idTecnico, Integer idComercial, String fechaInicio, String fechaFin, String comentario, String codFuncionalidad) {
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

    public Integer getIdIngeniero() {
        return idIngeniero;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public Integer getIdComercial() {
        return idComercial;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getComentario() {
        return comentario;
    }

    public String getCodFuncionalidad() {
        return codFuncionalidad;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdIngeniero(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public void setIdComercial(Integer idComercial) {
        this.idComercial = idComercial;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setCodFuncionalidad(String codFuncionalidad) {
        this.codFuncionalidad = codFuncionalidad;
    }
    
    

    

    
    
}
