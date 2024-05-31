package admin_user.controller;

import admin_user.Service.ClienteService;
import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;
import admin_user.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ClienteRepository clienteRepository;


    @PostMapping
    public String saveCliente(@ModelAttribute("cliente") ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido1(clienteDto.getApellido1());
        cliente.setApellido2(clienteDto.getApellido2());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCorreo(clienteDto.getCorreo());

        clienteService.saveCliente(clienteDto);
        return "redirect:/cliente";
    }

    @GetMapping
    public String getAllClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new ClienteDto());
        return "cliente";
    }

    @GetMapping("/{id_cliente}")
    @ResponseBody
    public Cliente getClienteById(@PathVariable int id_cliente) {
        return clienteService.getClienteById(id_cliente);
    }

    @PostMapping("/borrar/{id}")
    public String eliminarCliente(@PathVariable("id") int id_cliente) {
        clienteService.eliminarCliente(id_cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/buscar")
    public String searchClientes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String telefono,
            Model model) {
        List<Cliente> clientes = clienteService.getClienteByNombreOrApellido1OrApellido2OrTelefono(nombre, apellidos, telefono);
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new ClienteDto());
        return "cliente";
    }
}
