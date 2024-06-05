
package admin_user.Service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import java.util.List;

public interface UserService {
    
    User save (UserDto userDto);
    
    void eliminarUsuario(int id_usuario);
    
    User obtenerUsuarioPorId(int id_usuario);
    
    List<User> getUsuarioByUsuarioOrCorreo(String usuario, String correo);
    
    User update(User user);
    
    List<User> getAllUsuarios();
}
