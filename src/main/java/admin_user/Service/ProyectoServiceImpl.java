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
        proyecto.setId_cliente(proyectoDto.getId_cliente());
        proyecto.setId_ingeniero(proyectoDto.getId_ingeniero());
        proyecto.setId_tecnico(proyectoDto.getId_tecnico());
        proyecto.setId_comercial(proyectoDto.getId_comercial());
        proyecto.setFecha_inicio(proyectoDto.getFecha_inicio());
        proyecto.setFecha_fin(proyectoDto.getFecha_fin());
        proyecto.setComentario(proyectoDto.getComentario());
        proyecto.setCod_funcionalidad(proyectoDto.getCod_funcionalidad());
        return proyectoRepository.save(proyecto);
    }
    
    @Override
    public List<Proyecto> getProyectoById_clienteOrId_ingenieroOrId_tecnicoOrId_comercial(int id_proyecto,int id_cliente, int id_ingeniero, int id_tecnico, int id_comercial,int fecha_inicio,int fecha_fin) {
        // Llamar al método de búsqueda en el repositorio
        return proyectoRepository.findById_proyectoOrId_clienteOrId_ingenieroOrId_tecnicoOrId_comercialOrFecha_inicioOrFecha_fin(id_proyecto,id_cliente,id_ingeniero,id_tecnico,id_comercial,fecha_inicio,fecha_fin);
    }
    
    @Override
    public Proyecto update(Proyecto proyecto) {
        Optional<Proyecto> existingProyecto = proyectoRepository.findById(proyecto.getId_proyecto());
        if (existingProyecto.isPresent()) {
            Proyecto updateproyecto = new Proyecto();
        updateproyecto.setId_cliente(proyecto.getId_cliente());
        updateproyecto.setId_ingeniero(proyecto.getId_ingeniero());
        updateproyecto.setId_tecnico(proyecto.getId_tecnico());
        updateproyecto.setId_comercial(proyecto.getId_comercial());
        updateproyecto.setFecha_inicio(proyecto.getFecha_inicio());
        updateproyecto.setFecha_fin(proyecto.getFecha_fin());
        updateproyecto.setComentario(proyecto.getComentario());
        updateproyecto.setCod_funcionalidad(proyecto.getCod_funcionalidad());
        return proyectoRepository.save(updateproyecto);
        
        } else {
            throw new IllegalArgumentException("Proyecto no encontrado: " + proyecto.getId_proyecto());
        }
    }

}
