package admin_user.controller;

import admin_user.Service.ProyectoService;
import admin_user.Service.UserService;
import admin_user.dto.ProyectoDto;
import admin_user.dto.UserDto;
import admin_user.model.Proyecto;
import admin_user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService ProyectoService;

    @PostMapping
    public String saveUsuario(@ModelAttribute("proyecto") ProyectoDto proyectoDto) {
        Proyecto proyecto = new Proyecto();
        proyecto.setId_cliente(proyectoDto.getId_cliente());
        proyecto.setId_ingeniero(proyectoDto.getId_ingeniero());
        proyecto.setId_tecnico(proyectoDto.getId_tecnico());
        proyecto.setId_comercial(proyectoDto.getId_comercial());
        proyecto.setFecha_inicio(proyectoDto.getFecha_inicio());
        proyecto.setFecha_fin(proyectoDto.getFecha_fin());
        proyecto.setComentario(proyectoDto.getComentario());
        proyecto.setCod_funcionalidad(proyectoDto.getCod_funcionalidad());

        ProyectoService.saveProyecto(proyectoDto);
        return "redirect:/proyecto";
    }

    @GetMapping
    public String getAllProyecto(Model model) {
        List<Proyecto> proyecto = ProyectoService.getAllProyecto();
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("proyecto", new ProyectoDto());
        return "proyecto";
    }

    @PostMapping("/borrar/{id}")
    public String eliminarProyecto(@PathVariable("id") int id_proyecto) {
        ProyectoService.eliminarProyecto(id_proyecto);
        return "redirect:/proyecto";
    }

    @GetMapping("/buscar")
    public String searchProyecto(
            @RequestParam(required = false) int id_proyecto,
            @RequestParam(required = false) int id_cliente,
            @RequestParam(required = false) int id_ingeniero,
            @RequestParam(required = false) int id_tecnico,
            @RequestParam(required = false) int id_comercial,
            @RequestParam(required = false) int fecha_inicio,
            @RequestParam(required = false) int fecha_fin,
            Model model) {
        List<Proyecto> proyecto = ProyectoService.getProyectoById_clienteOrId_ingenieroOrId_tecnicoOrId_comercial(id_proyecto,id_cliente,id_ingeniero,id_tecnico,id_comercial,fecha_inicio,fecha_fin);
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("proyecto", new ProyectoDto());
        return "proyecto";
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(Proyecto proyecto, RedirectAttributes attributes) {
        ProyectoService.update(proyecto);
        attributes.addFlashAttribute("mensaje", "Proyecto actualizado exitosamente");
        return "redirect:/proyecto";
    }
}
