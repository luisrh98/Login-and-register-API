package admin_user.Service;

import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;

import java.util.List;

public interface ClienteService {
    
    List<Cliente> getAllClientes();
    
    Cliente getClienteById(int id);
    
    Cliente saveCliente(ClienteDto clienteDto);
    
    void eliminarCliente(int id_cliente);
    
    Cliente obtenerClientePorId(int id_cliente);
    
    List<Cliente> getClienteByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellidos, String telefono);
}