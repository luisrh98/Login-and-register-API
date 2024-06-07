package admin_user.Service;

import admin_user.dto.TecnicoDto;
import admin_user.model.Tecnico;

import java.util.List;

public interface TecnicoService {
    
    List<Tecnico> getAllTecnicos();
    
    Tecnico saveTecnico(TecnicoDto TecnicoDto);
    
    void eliminarTecnico(int id_tecnico);
    
    Tecnico obtenerTecnicoPorId(int id_tecnico);
    
    List<Tecnico> getTecnicoByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellidos, String telefono);
    
    Tecnico update(Tecnico tecnico);
}