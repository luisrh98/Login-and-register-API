package admin_user.Service;

import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;
import admin_user.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido1(clienteDto.getApellido1());
        cliente.setApellido2(clienteDto.getApellido2());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCorreo(clienteDto.getCorreo());
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> getClienteByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellidos, String telefono) {
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
        return clienteRepository.findByNombreOrApellido1OrApellido2OrTelefono(nombre, apellido1, apellido2, telefono);
    }
}
