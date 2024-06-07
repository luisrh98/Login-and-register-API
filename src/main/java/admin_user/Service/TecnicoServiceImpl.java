package admin_user.Service;

import admin_user.dto.TecnicoDto;
import admin_user.model.Tecnico;
import admin_user.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoServiceImpl implements TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public List<Tecnico> getAllTecnicos() {
        return tecnicoRepository.findAll();
    }

    @Override
    public void eliminarTecnico(int id_tecnico) {
        tecnicoRepository.deleteById(id_tecnico);
    }


    @Override
    public Tecnico obtenerTecnicoPorId(int id_tecnico) {
        Optional<Tecnico> tecnicoOpt = tecnicoRepository.findById(id_tecnico);
        if (tecnicoOpt.isPresent()) {
            return tecnicoOpt.get();
        } else {
            throw new RuntimeException("Tecnico no encontrado con id: " + id_tecnico);
        }
    }

    @Override
    public Tecnico saveTecnico(TecnicoDto tecnicoDto) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(tecnicoDto.getNombre());
        tecnico.setApellido1(tecnicoDto.getApellido1());
        tecnico.setApellido2(tecnicoDto.getApellido2());
        tecnico.setTelefono(tecnicoDto.getTelefono());
        tecnico.setCorreo(tecnicoDto.getCorreo());
        return tecnicoRepository.save(tecnico);
    }


    @Override
    public List<Tecnico> getTecnicoByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellidos, String telefono) {
        String[] apellidoArray = apellidos.split("\\s+"); // Dividir el campo de apellidos en palabras separadas
        String apellido1 = null;
        String apellido2 = null;
        if (apellidoArray.length > 0) {
            apellido1 = apellidoArray[0]; // El primer elemento es el primer apellido
            if (apellidoArray.length > 1) {
                apellido2 = apellidoArray[1]; // El segundo elemento es el segundo apellido
            }
        }
        // Llamar al método de búsqueda en el repositorio
        return tecnicoRepository.findByNombreOrApellido1OrApellido2OrTelefono(nombre, apellido1, apellido2, telefono);
    }
    
    @Override
    public Tecnico update(Tecnico tecnico) {
        Optional<Tecnico> existingTecnico = tecnicoRepository.findById(tecnico.getId_tecnico());
        if (existingTecnico.isPresent()) {
            Tecnico updatedTecnico = existingTecnico.get();
            updatedTecnico.setNombre(tecnico.getNombre());
            updatedTecnico.setApellido1(tecnico.getApellido1());
            updatedTecnico.setApellido2(tecnico.getApellido2());
            updatedTecnico.setTelefono(tecnico.getTelefono());
            updatedTecnico.setCorreo(tecnico.getCorreo());
            return tecnicoRepository.save(updatedTecnico);
        } else {
            throw new IllegalArgumentException("Tecnico no encontrado: " + tecnico.getId_tecnico());
        }
    }
}
