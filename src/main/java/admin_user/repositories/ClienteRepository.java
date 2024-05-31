package admin_user.repositories;

import admin_user.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNombreOrApellido1OrApellido2OrTelefono(String nombre, String apellido1, String apellido2, String telefono);
}