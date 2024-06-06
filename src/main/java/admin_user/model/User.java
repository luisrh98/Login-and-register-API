package admin_user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_usuario;

    private Integer id_cliente;
    private String usuario;
    private String password;
    private String correo;
    private String roles;
    private String telefono;

    public User() {
        super();
    }

    public User(String usuario, String password, String correo, String telefono, String roles) {
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.roles = "USER";
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}