package admin_user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Cliente {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    
    private String nombre;
    private String Apellido1;
    private String Apellido2;
    private String telefono;
    private String correo;

    public Cliente() {
        super();
    }

    public Cliente(int id_cliente, String nombre, String Apellido1, String Apellido2, String telefono, String correo) {
        this.nombre = nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
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
        return Apellido1;
    }

    public void setApellido1(String primerApellido) {
        this.Apellido1 = primerApellido;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String segundoApellido) {
        this.Apellido2 = segundoApellido;
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