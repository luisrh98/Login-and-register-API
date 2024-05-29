package admin_user.controller;

import admin_user.Service.ClienteService;
import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService; // Cambiado a ClienteService

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping
    public String saveCliente(@ModelAttribute("cliente") ClienteDto clienteDto, Model model) {
        // Crear un nuevo cliente utilizando el DTO
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido1(clienteDto.getApellido1());
        cliente.setApellido2(clienteDto.getApellido2());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCorreo(clienteDto.getCorreo());

        // Guardar el cliente utilizando el servicio
        clienteService.saveCliente(clienteDto);
        return "redirect:/cliente";
    }

    @GetMapping
    public String getAllClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new ClienteDto()); // Agregar objeto cliente al modelo
        return "cliente";
    }

    @GetMapping("/cliente/{id_cliente}")
    @ResponseBody
    public Cliente getClienteById(@PathVariable int id) {
        return clienteService.getClienteById(id);
    }

    @GetMapping("/cliente")
    public String showCliente(@RequestParam String nombre, Model model) {
        // Suponiendo que tienes un método para recuperar el cliente desde el servicio
        List<Cliente> cliente = clienteService.getClienteByNombre(nombre);
        model.addAttribute("cliente", cliente);
        return "cliente"; // Suponiendo que el nombre de tu plantilla es "cliente.html"
    }

    @DeleteMapping("/cliente/{id_cliente}")
    public String deleteCliente(@PathVariable int id) {
        clienteService.deleteCliente(id);
        return "redirect:/cliente";
    }

    @GetMapping("/cliente/search")
    public String searchClientes(@RequestParam String nombre, Model model) {
        List<Cliente> clientes = clienteService.searchClientesByNombre(nombre);
        model.addAttribute("clientes", clientes);
        return "cliente";
    }

    @GetMapping("/user-page")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "cliente";
    }

    @GetMapping("/admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "cliente";
    }
}
