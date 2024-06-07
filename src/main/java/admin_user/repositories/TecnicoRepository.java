package admin_user.repositories;

import admin_user.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    List<Tecnico> findByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellido1, String apellido2, String telefono);
    
    @Query(value="delete from tecnico where id_tecnico = :id_tecnico", nativeQuery =true)
     void deletetecnicos(@Param("id_tecnico") int id_tecnico);
     
    Optional<Tecnico> findByCorreoOrTelefono(String correo, String telefono);
}