/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin_user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "ingeniero", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Ingeniero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ingeniero;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;

    public Ingeniero (){
        super();
    }

    public Ingeniero(int id_ingeniero, String nombre, String Apellido1, String Apellido2, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_ingeniero() {
        return id_ingeniero;
    }

    public void setId_ingeniero(int id_ingeniero) {
        this.id_ingeniero = id_ingeniero;
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

