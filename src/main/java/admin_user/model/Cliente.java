package admin_user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Cliente {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;

    public Cliente() {
        super();
    }

    public Cliente(int id_cliente, String nombre, String Apellido1, String Apellido2, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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