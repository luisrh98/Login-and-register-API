package admin_user.controller;

import admin_user.Service.UserService;
import admin_user.dto.UserDto;
import admin_user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
 
    @Autowired
    private UserService usuarioService;
 
    @PostMapping
    public String saveUsuario(@ModelAttribute("usuarios") UserDto usuarioDto) {
        User usuario = new User();
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario.setId_cliente(usuarioDto.getId_cliente());
        usuario.setCorreo(usuarioDto.getCorreo());
        usuario.setRoles(usuarioDto.getRoles());
 
        usuarioService.save(usuarioDto);
        return "redirect:/usuarios";
    }
 
    @GetMapping
    public String getAllClientes(Model model) {
        List<User> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new UserDto());
        return "usuario";
    }
 
 
    @PostMapping("/borrar/{id}")
    public String eliminarUsuario(@PathVariable("id") int id_usuario) {
        usuarioService.eliminarUsuario(id_usuario);
        return "redirect:/usuario";
    }
 
    @GetMapping("/buscar")
    public String searchUsuarios(
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String correo,
            Model model) {
        List<User> usuarios = usuarioService.getUsuarioByUsuarioOrCorreo(usuario, correo);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new UserDto());
        return "usuarios";
    }
    @PostMapping("/actualizar")
    public String actualizarUsuario(User usuario, RedirectAttributes attributes) {
        usuarioService.update(usuario);
        attributes.addFlashAttribute("mensaje", "Usuario actualizado exitosamente");
        return "redirect:/usuarios";
    }
}
