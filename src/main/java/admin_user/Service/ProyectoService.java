package admin_user.Service;

import admin_user.dto.ProyectoDto;
import admin_user.model.Proyecto;

import java.util.List;

public interface ProyectoService {
    
    List<Proyecto> getAllProyecto();
    
    Proyecto saveProyecto(ProyectoDto ProyectoDto);
    
    void eliminarProyecto(int id_proyecto);
    
    Proyecto obtenerProyectoPorId(int proyecto);
    
    List<Proyecto> getProyectoById_clienteOrId_ingenieroOrId_tecnicoOrId_comercial(int id_proyecto,int id_cliente, int id_ingeniero, int id_tecnico, int id_comercial,int fecha_inicio,int fecha_fin);
    Proyecto update(Proyecto proyecto);
}