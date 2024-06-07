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
    @Query("SELECT p FROM Proyecto p WHERE " +
           "(:id_cliente = -1 OR p.idCliente = :idCliente) OR " +
           "(:id_ingeniero = -1 OR p.idIngeniero = :idIngeniero) OR " +
           "(:id_tecnico = -1 OR p.idTecnico = :idTecnico) OR " +
           "(:id_comercial = -1 OR p.idComercial = :idComercial) OR " +
           "(:fecha_inicio = '' OR p.fechaInicio = :fechaInicio) OR " +
           "(:fecha_fin = '' OR p.fechaFin = :fechaFin)")
    List<Proyecto> findByIdClienteOrIdIngenieroOrIdTecnicoOrIdComercialOrFechaInicioOrFechaFin(int idCliente, int idIngeniero, int idTecnico, int idComercial,String fechaInicio, String fechaFin);
    
    @Query(value="delete from proyecto where id_proyecto = :id_proyecto", nativeQuery =true)
     void deleteproyecto(@Param("id_proyecto") int id_proyecto);
     
}