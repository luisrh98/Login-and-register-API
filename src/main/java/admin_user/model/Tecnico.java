package admin_user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnico", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Tecnico {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tecnico;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;

    public Tecnico() {
        super();
    }

    public Tecnico(int id_tecnico, String nombre, String Apellido1, String Apellido2, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String primerApellido) {
        this.apellido1 = primerApellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String segundoApellido) {
        this.apellido2 = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}