package admin_user.Service;

import admin_user.dto.ProyectoDto;
import admin_user.model.Proyecto;

import java.util.List;

public interface ProyectoService {
    
    List<Proyecto> getAllProyecto();
    
    Proyecto saveProyecto(ProyectoDto ProyectoDto);
    
    void eliminarProyecto(int id_proyecto);
    
    Proyecto obtenerProyectoPorId(int id_proyecto);
    
    List<Proyecto> getProyectoByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercial(int idCliente, int idIngeniero, int idTecnico, int idComercial,String fechaInicio,String fechaFin);
    
    Proyecto update(Proyecto proyecto);
}