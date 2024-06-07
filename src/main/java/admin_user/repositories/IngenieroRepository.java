package admin_user.repositories;

import admin_user.model.Ingeniero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface IngenieroRepository extends JpaRepository<Ingeniero, Integer> {
    List<Ingeniero> findByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellido1, String apellido2, String telefono);
    
    @Query(value="delete from cliente where id_ingeniero = :id_ingeniero", nativeQuery =true)
     void deleteingenieros(@Param("id_ingeniero") int id_ingeniero);
     
    Optional<Ingeniero> findByCorreoOrTelefono(String correo, String telefono);
}