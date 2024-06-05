
package admin_user.repositories;

import admin_user.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    User findByCorreo (String correo);
    
    List<User> findAll();
    
    List<User> findByUsuarioOrCorreo(String usuario, String correo);
    
    @Query(value="delete from cliente where id_cliente = :id_cliente", nativeQuery =true)
     void deleteclientes(@Param("id_usuario") int id_usuario);
}
