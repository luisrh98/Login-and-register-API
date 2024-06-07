package admin_user.controller;

import admin_user.Service.IngenieroService;
import admin_user.dto.IngenieroDto;
import admin_user.model.Ingeniero;
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
@RequestMapping("/ingeniero")
public class IngenieroController {

    @Autowired
    private IngenieroService ingenieroService;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @GetMapping("/admin-page")
    public String adminPage (Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
                model.addAttribute("user", userDetails);
        return "admin";}
    
    @PostMapping
    public String saveCliente(@ModelAttribute("ingeniero") IngenieroDto ingenieroDto) {
        Ingeniero ingeniero = new Ingeniero();
        ingeniero.setNombre(ingenieroDto.getNombre());
        ingeniero.setApellido1(ingenieroDto.getApellido1());
        ingeniero.setApellido2(ingenieroDto.getApellido2());
        ingeniero.setTelefono(ingenieroDto.getTelefono());
        ingeniero.setCorreo(ingenieroDto.getCorreo());

        ingenieroService.saveIngeniero(ingenieroDto);
        return "redirect:/ingeniero";
    }

    @GetMapping
    public String getAllIngenieros(Model model) {
        List<Ingeniero> ingenieros = ingenieroService.getAllIngenieros();
        model.addAttribute("ingenieros", ingenieros);
        model.addAttribute("ingeniero", new IngenieroDto());
        return "ingeniero";
    }

    @PostMapping("/borrar/{id}")
    public String eliminarIngeniero(@PathVariable("id") int id_ingeniero) {
        ingenieroService.eliminarIngeniero(id_ingeniero);
        return "redirect:/ingeniero";
    }

    @GetMapping("/buscar")
    public String searchIngenieros(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String telefono,
            Model model) {
        List<Ingeniero> ingenieros = ingenieroService.getIngenieroByNombreOrApellido1OrApellido2OrTelefono(nombre, apellidos, telefono);
        model.addAttribute("ingenieros", ingenieros);
        model.addAttribute("ingeniero", new IngenieroDto());
        return "ingeniero";
    }
    
    @PostMapping("/actualizar")
    public String actualizarIngeniero(Ingeniero ingeniero, RedirectAttributes attributes) {
        ingenieroService.update(ingeniero);
        attributes.addFlashAttribute("mensaje", "Ingeniero actualizado exitosamente");
        return "redirect:/ingeniero";
    }
}
