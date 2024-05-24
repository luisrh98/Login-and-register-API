
package admin_user.repositories;

import admin_user.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    User findByCorreo (String correo);
    
    List<User> findAll();
}
