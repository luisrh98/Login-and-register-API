package admin_user.repositories;

import admin_user.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellido1, String apellido2, String telefono);
    
    @Query(value="delete from cliente where id_cliente = :id_cliente", nativeQuery =true)
     void deleteclientes(@Param("id_cliente") int id_cliente);
     
    Optional<Cliente> findByCorreoOrTelefono(String correo, String telefono);
}