package admin_user.Service;

import admin_user.dto.IngenieroDto;
import admin_user.model.Ingeniero;
import admin_user.repositories.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngenieroServiceImpl implements IngenieroService {

    @Autowired
    private IngenieroRepository ingenieroRepository;

    @Override
    public List<Ingeniero> getAllIngenieros() {
        return ingenieroRepository.findAll();
    }

    @Override
    public void eliminarIngeniero(int id_ingeniero) {
        ingenieroRepository.deleteById(id_ingeniero);
    }


    @Override
    public Ingeniero obtenerIngenieroPorId(int id_ingeniero) {
        Optional<Ingeniero> ingenieroOpt = ingenieroRepository.findById(id_ingeniero);
        if (ingenieroOpt.isPresent()) {
            return ingenieroOpt.get();
        } else {
            throw new RuntimeException("Ingeniero no encontrado con id: " + id_ingeniero);
        }
    }

    @Override
    public Ingeniero saveIngeniero(IngenieroDto ingenieroDto) {
        Ingeniero ingeniero = new Ingeniero();
        ingeniero.setNombre(ingenieroDto.getNombre());
        ingeniero.setApellido1(ingenieroDto.getApellido1());
        ingeniero.setApellido2(ingenieroDto.getApellido2());
        ingeniero.setTelefono(ingenieroDto.getTelefono());
        ingeniero.setCorreo(ingenieroDto.getCorreo());
        return ingenieroRepository.save(ingeniero);
    }


    @Override
    public List<Ingeniero> getIngenieroByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellidos, String telefono) {
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
        return ingenieroRepository.findByNombreOrApellido1OrApellido2OrTelefono(nombre, apellido1, apellido2, telefono);
    }
    
    @Override
    public Ingeniero update(Ingeniero ingeniero) {
        Optional<Ingeniero> existingIngeniero = ingenieroRepository.findById(ingeniero.getId_ingeniero());
        if (existingIngeniero.isPresent()) {
            Ingeniero updatedIngeniero = existingIngeniero.get();
            updatedIngeniero.setNombre(ingeniero.getNombre());
            updatedIngeniero.setApellido1(ingeniero.getApellido1());
            updatedIngeniero.setApellido2(ingeniero.getApellido2());
            updatedIngeniero.setTelefono(ingeniero.getTelefono());
            updatedIngeniero.setCorreo(ingeniero.getCorreo());
            return ingenieroRepository.save(updatedIngeniero);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: " + ingeniero.getId_ingeniero());
        }
    }

}
