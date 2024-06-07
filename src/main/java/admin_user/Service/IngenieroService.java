package admin_user.Service;

import admin_user.dto.IngenieroDto;
import admin_user.model.Ingeniero;

import java.util.List;

public interface IngenieroService {
    
    List<Ingeniero> getAllIngenieros();
    
    Ingeniero saveIngeniero(IngenieroDto ingenieroDto);
    
    void eliminarIngeniero(int id_ingeniero);
    
    Ingeniero obtenerIngenieroPorId(int id_ingeniero);
    
    List<Ingeniero> getIngenieroByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellidos, String telefono);
    
    Ingeniero update(Ingeniero ingeniero);
}