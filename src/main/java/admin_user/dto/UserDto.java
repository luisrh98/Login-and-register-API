package admin_user.dto;



public class UserDto {
    private int id_cliente;
    private String usuario;
    private String password;
    private String correo;
    private String roles;
    
    public UserDto() {
    }
    
    public UserDto(String usuario, String password, String correo, String roles) {
        super();
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.roles = roles;
    }
    
    public UserDto(int id_cliente, String usuario, String password, String correo, String roles) {
        super();
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.roles = roles;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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
    
}
