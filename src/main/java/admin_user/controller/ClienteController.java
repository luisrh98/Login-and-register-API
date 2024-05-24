package admin_user.controller;

import admin_user.Service.ClienteService;
import admin_user.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String getAllClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "cliente";
    }

    @GetMapping("/cliente/{id_cliente}")
    @ResponseBody
    public Cliente getClienteById(@PathVariable int id) {
        return clienteService.getClienteById(id).orElse(null);
    }

    @PostMapping
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente";
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
}