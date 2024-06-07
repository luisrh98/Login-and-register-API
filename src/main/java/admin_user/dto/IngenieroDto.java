package admin_user.dto;

public class IngenieroDto {
    private int id_ingeniero;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;

    public IngenieroDto() {
    }

    public IngenieroDto(String nombre, String apellido1, String apellido2, String telefono, String correo) {
        super();
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
    }    

    public int getId_ingeniero() {
        return id_ingeniero;
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

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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
