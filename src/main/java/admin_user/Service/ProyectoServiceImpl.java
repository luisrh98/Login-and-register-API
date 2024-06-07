package admin_user.Service;

import admin_user.dto.ProyectoDto;
import admin_user.model.Proyecto;
import admin_user.repositories.ProyectoRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> getAllProyecto() {
        return proyectoRepository.findAll();
    }

    @Override
    public void eliminarProyecto(Integer id_proyecto) {
        proyectoRepository.deleteById(id_proyecto);
    }

    @Override
    public Proyecto obtenerProyectoPorId(Integer id_proyecto) {
        Optional<Proyecto> proyectoOpt = proyectoRepository.findById(id_proyecto);
        if (proyectoOpt.isPresent()) {
            return proyectoOpt.get();
        } else {
            throw new RuntimeException("Proyecto no encontrado con id: " + id_proyecto);
        }
    }

    @Override
    public Proyecto saveProyecto(ProyectoDto proyectoDto) {
        Proyecto proyecto = new Proyecto();
        proyecto.setIdCliente(proyectoDto.getIdCliente());
        proyecto.setIdIngeniero(proyectoDto.getIdIngeniero());
        proyecto.setIdTecnico(proyectoDto.getIdTecnico());
        proyecto.setIdComercial(proyectoDto.getIdComercial());
        proyecto.setFechaInicio(proyectoDto.getFechaInicio());
        proyecto.setFechaFin(proyectoDto.getFechaFin());
        proyecto.setComentario(proyectoDto.getComentario());
        proyecto.setCodFuncionalidad(proyectoDto.getCodFuncionalidad());
        try {
            return proyectoRepository.save(proyecto);
        } catch (DataIntegrityViolationException e) {
            // Aquí puedes agregar un registro de error más detallado
            System.err.println("Data Integrity Violation: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            // Aquí puedes agregar un registro de error más detallado
            System.err.println("Error al guardar el proyecto: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Proyecto> getProyectoByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercial(Integer idCliente, Integer idIngeniero, Integer idTecnico, Integer idComercial, String fechaInicio, String fechaFin) {
        // Verificar si los parámetros que podrían ser nulos son realmente nulos
        if (idCliente == null && idIngeniero == null && idTecnico == null && idComercial == null && fechaInicio == null && fechaFin == null) {
            // Si todos los parámetros son nulos, podrías devolver una lista vacía o lanzar una excepción, dependiendo de tus requisitos
            return Collections.emptyList(); // Devuelve una lista vacía
        } else {
            // Llamar al método de búsqueda en el repositorio con los parámetros no nulos
            return proyectoRepository.findByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercialOrFechaInicioOrFechaFin(idCliente, idIngeniero, idTecnico, idComercial, fechaInicio, fechaFin);
        }
    }

    @Override
    public Proyecto update(Proyecto proyecto) {
        Optional<Proyecto> existingProyecto = proyectoRepository.findById(proyecto.getIdProyecto());
        if (existingProyecto.isPresent()) {
            Proyecto updateproyecto = new Proyecto();
            updateproyecto.setIdCliente(proyecto.getIdCliente());
            updateproyecto.setIdIngeniero(proyecto.getIdIngeniero());
            updateproyecto.setIdTecnico(proyecto.getIdTecnico());
            updateproyecto.setIdComercial(proyecto.getIdComercial());
            updateproyecto.setFechaInicio(proyecto.getFechaInicio());
            updateproyecto.setFechaFin(proyecto.getFechaFin());
            updateproyecto.setComentario(proyecto.getComentario());
            updateproyecto.setCodFuncionalidad(proyecto.getCodFuncionalidad());
            return proyectoRepository.save(updateproyecto);
        } else {
            throw new IllegalArgumentException("Proyecto no encontrado: " + proyecto.getIdProyecto());
        }
    }

}
