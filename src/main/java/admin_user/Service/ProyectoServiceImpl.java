package admin_user.Service;

import admin_user.dto.ProyectoDto;
import admin_user.model.Proyecto;
import admin_user.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> getAllProyecto() {
        return proyectoRepository.findAll();
    }

    @Override
    public void eliminarProyecto(int id_proyecto) {
        proyectoRepository.deleteById(id_proyecto);
    }


    @Override
    public Proyecto obtenerProyectoPorId(int id_proyecto) {
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
        return proyectoRepository.save(proyecto);
    }
    
    @Override
    public List<Proyecto> getProyectoByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercial(int idCliente, int idIngeniero, int idTecnico, int idComercial,String fechaInicio,String fechaFin) {
        // Llamar al método de búsqueda en el repositorio
        return proyectoRepository.findByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercialOrFechaInicioOrFechaFin(idCliente,idIngeniero,idTecnico,idComercial,fechaInicio,fechaFin);
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
