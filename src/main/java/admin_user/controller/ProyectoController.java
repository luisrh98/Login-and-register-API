package admin_user.controller;

import admin_user.Service.ProyectoService;
import admin_user.dto.ProyectoDto;
import admin_user.model.Proyecto;
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
    private ProyectoService proyectoService;

    @PostMapping
    public String saveProyecto(@ModelAttribute("proyecto") ProyectoDto proyectoDto) {
        Proyecto proyecto = new Proyecto();
        proyecto.setIdCliente(proyectoDto.getIdCliente());
        proyecto.setIdIngeniero(proyectoDto.getIdIngeniero());
        proyecto.setIdTecnico(proyectoDto.getIdTecnico());
        proyecto.setIdComercial(proyectoDto.getIdComercial());
        proyecto.setFechaInicio(proyectoDto.getFechaInicio());
        proyecto.setFechaFin(proyectoDto.getFechaFin());
        proyecto.setComentario(proyectoDto.getComentario());
        proyecto.setCodFuncionalidad(proyectoDto.getCodFuncionalidad());

        proyectoService.saveProyecto(proyectoDto);  // Asegúrate de que el método del servicio acepte la entidad Proyecto
        return "redirect:/proyecto";
    }

    @GetMapping
    public String getAllProyecto(Model model) {
        List<Proyecto> proyectos = proyectoService.getAllProyecto();
        model.addAttribute("proyectos", proyectos);  // Cambia el nombre del atributo a "proyectos"
        model.addAttribute("proyecto", new ProyectoDto());
        return "proyecto";
    }

    @PostMapping("/borrar/{id}")
    public String eliminarProyecto(@PathVariable("id") int id_proyecto) {
        proyectoService.eliminarProyecto(id_proyecto);
        return "redirect:/proyecto";
    }

    @GetMapping("/buscar")
    public String searchProyecto(
            @RequestParam(required = false) Integer id_cliente,
            @RequestParam(required = false) Integer id_ingeniero,
            @RequestParam(required = false) Integer id_tecnico,
            @RequestParam(required = false) Integer id_comercial,
            @RequestParam(required = false) String fecha_inicio,
            @RequestParam(required = false) String fecha_fin,
            Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectoByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercial(id_cliente, id_ingeniero, id_tecnico, id_comercial, fecha_inicio, fecha_fin);
        model.addAttribute("proyectos", proyectos);  // Cambia el nombre del atributo a "proyectos"
        model.addAttribute("proyecto", new ProyectoDto());
        return "proyecto";
    }

    @PostMapping("/actualizar")
    public String actualizarProyecto(Proyecto proyecto, RedirectAttributes attributes) {
        proyectoService.update(proyecto);
        attributes.addFlashAttribute("mensaje", "Proyecto actualizado exitosamente");
        return "redirect:/proyecto";
    }

}
