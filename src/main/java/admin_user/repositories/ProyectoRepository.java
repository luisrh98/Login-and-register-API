package admin_user.repositories;

import admin_user.model.Cliente;
import admin_user.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    List<Proyecto> findById_proyectoOrId_clienteOrId_ingenieroOrId_tecnicoOrId_comercialOrFecha_inicioOrFecha_fin(int id_proyecto,int id_cliente, int id_ingeniero, int id_tecnico, int id_comercial,int fecha_inicio, int fecha_fin);
    
    @Query(value="delete from proyecto where id_proyecto = :id_proyecto", nativeQuery =true)
     void deleteproyecto(@Param("id_proyecto") int id_proyecto);
     
}