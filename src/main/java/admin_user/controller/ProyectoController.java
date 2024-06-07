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
    public String eliminarProyecto(@PathVariable("id") Integer id_proyecto) {
        proyectoService.eliminarProyecto(id_proyecto);
        return "redirect:/proyecto";
    }

    @GetMapping("/buscar")
    public String searchProyecto(
            @RequestParam(required = false) Integer idCliente,
            @RequestParam(required = false) Integer idIngeniero,
            @RequestParam(required = false) Integer idTecnico,
            @RequestParam(required = false) Integer idComercial,
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectoByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercial(idCliente, idIngeniero, idTecnico, idComercial, fechaInicio, fechaFin);
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
