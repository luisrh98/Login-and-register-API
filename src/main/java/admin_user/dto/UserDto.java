package admin_user.dto;

import admin_user.model.User;

public class UserDto {
    private int id_cliente;
    private String usuario;
    private String password;
    private String correo;
    private String roles;
    private String telefono;

    public UserDto() {
    }

    public UserDto(String usuario, String password, String correo, String telefono, String roles) {
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.roles = roles;
    }

    public UserDto(User user) {
        this.id_cliente = user.getId_cliente();
        this.usuario = user.getUsuario();
        this.password = user.getPassword();
        this.correo = user.getCorreo();
        this.telefono = user.getTelefono();
        this.roles = user.getRoles();
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
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