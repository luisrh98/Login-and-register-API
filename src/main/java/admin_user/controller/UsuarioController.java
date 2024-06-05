package admin_user.controller;

import admin_user.Service.ClienteService;
import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;
import admin_user.repositories.ClienteRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
 
    @Autowired
    private ClienteService clienteService;
 
    @PostMapping
    public String saveUsuario(@ModelAttribute("usuarios") UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido1(usuarioDto.getApellido1());
        usuario.setApellido2(usuarioDto.getApellido2());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setCorreo(usuarioDto.getCorreo());
 
        clienteService.saveUsuario(usuarioDto);
        return "redirect:/usuarios";
    }
 
    @GetMapping
    public String getAllClientes(Model model) {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", clientes);
        model.addAttribute("usuario", new UsuarioDto());
        return "usuario";
    }
 
    @GetMapping("/{id_usuario}")
    @ResponseBody
    public Usuario getUsuarioById(@PathVariable int id_usuario) {
        return usuarioService.getUsuarioById(id_usuario);
    }
 
    @PostMapping("/borrar/{id}")
    public String eliminarUsuario(@PathVariable("id") int id_usuario) {
        usuarioService.eliminarUsuario(id_usuario);
        return "redirect:/usuario";
    }
 
    @GetMapping("/buscar")
    public String searchUsuarios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String telefono,
            Model model) {
        List<Usuario> usuarios = usuarioService.getUsuariosByNombreOrApellido1OrApellido2OrTelefono(nombre, apellidos, telefono);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new UsuarioDto());
        return "usuarios";
    }
    @PostMapping("/actualizar")
    public String actualizarUsuario(Usuario usuario, RedirectAttributes attributes) {
        usuarioService.update(usuario);
        attributes.addFlashAttribute("mensaje", "Usuario actualizado exitosamente");
        return "redirect:/usuarios";
    }
}
