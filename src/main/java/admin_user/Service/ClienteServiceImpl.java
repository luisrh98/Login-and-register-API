package admin_user.Service;

import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;
import admin_user.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void eliminarCliente(int id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }


    @Override
    public Cliente obtenerClientePorId(int id_cliente) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id_cliente);
        if (clienteOpt.isPresent()) {
            return clienteOpt.get();
        } else {
            throw new RuntimeException("Cliente no encontrado con id: " + id_cliente);
        }
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

    @Override
    public Cliente getClienteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
