package admin_user.Service;

import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;
import admin_user.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Cliente> searchClientesByNombre(String nombre) {
        return clienteRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Cliente> getClienteByNombre(String nombre) {
        return clienteRepository.findByNombreContaining(nombre);
    }
}