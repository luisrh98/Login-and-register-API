package admin_user.controller;

import admin_user.Service.ClienteService;
import admin_user.Service.TecnicoService;
import admin_user.dto.ClienteDto;
import admin_user.dto.TecnicoDto;
import admin_user.model.Cliente;
import admin_user.model.Tecnico;
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
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @GetMapping("/admin-page")
    public String adminPage (Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
                model.addAttribute("user", userDetails);
        return "admin";}
    
    @PostMapping
    public String saveTecnico(@ModelAttribute("tecnico") TecnicoDto tecnicoDto) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(tecnicoDto.getNombre());
        tecnico.setApellido1(tecnicoDto.getApellido1());
        tecnico.setApellido2(tecnicoDto.getApellido2());
        tecnico.setTelefono(tecnicoDto.getTelefono());
        tecnico.setCorreo(tecnicoDto.getCorreo());

        tecnicoService.saveTecnico(tecnicoDto);
        return "redirect:/tecnico";
    }

    @GetMapping
    public String getAllTecnicos(Model model) {
        List<Tecnico> tecnicos = tecnicoService.getAllTecnicos();
        model.addAttribute("tecnicos", tecnicos);
        model.addAttribute("tecnico", new TecnicoDto());
        return "tecnico";
    }

    @PostMapping("/borrar/{id}")
    public String eliminarTecnico(@PathVariable("id") int id_tecnico) {
        tecnicoService.eliminarTecnico(id_tecnico);
        return "redirect:/tecnico";
    }

    @GetMapping("/buscar")
    public String searchTecnico(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String telefono,
            Model model) {
        List<Tecnico> tecnicos = tecnicoService.getTecnicoByNombreOrApellido1OrApellido2OrTelefono(nombre, apellidos, telefono);
        model.addAttribute("tecnicos", tecnicos);
        model.addAttribute("tecnico", new TecnicoDto());
        return "tecnico";
    }
    
    @PostMapping("/actualizar")
    public String actualizarTecnico(Tecnico tecnico, RedirectAttributes attributes) {
        tecnicoService.update(tecnico);
        attributes.addFlashAttribute("mensaje", "Tecnico actualizado exitosamente");
        return "redirect:/tecnico";
    }
}
