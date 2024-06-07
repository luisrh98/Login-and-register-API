package admin_user.Service;

import admin_user.dto.ProyectoDto;
import admin_user.model.Proyecto;

import java.util.List;

public interface ProyectoService {
    
    List<Proyecto> getAllProyecto();
    
    Proyecto saveProyecto(ProyectoDto ProyectoDto);
    
    void eliminarProyecto(Integer id_proyecto);
    
    Proyecto obtenerProyectoPorId(Integer id_proyecto);
    
    List<Proyecto> getProyectoByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercial(Integer idCliente, Integer idIngeniero, Integer idTecnico, Integer idComercial,String fechaInicio,String fechaFin);
    
    Proyecto update(Proyecto proyecto);
}