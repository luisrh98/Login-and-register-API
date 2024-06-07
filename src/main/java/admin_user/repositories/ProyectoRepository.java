package admin_user.repositories;

import admin_user.model.Cliente;
import admin_user.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    List<Proyecto> findByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercialOrFechaInicioOrFechaFin(Integer idCliente, Integer idIngeniero, Integer idTecnico, Integer idComercial,String fechaInicio, String fechaFin);
    
    @Query(value="delete from proyecto where id_proyecto = :id_proyecto", nativeQuery =true)
     void deleteproyecto(@Param("id_proyecto") Integer id_proyecto);
     
}