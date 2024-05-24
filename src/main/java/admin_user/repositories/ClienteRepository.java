package admin_user.repositories;

import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    Cliente findByCorreo(String correo);
    
    List<Cliente> findAll();
}