
package admin_user.Service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private  UserRepository userRepository;
    
    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsuario(),passwordEncoder.encode(userDto.getPassword()), userDto.getCorreo(),userDto.getRoles());
        return userRepository.save(user);
    }
    
    @Override
    public User update(User user) {
        Optional<User> existingUsuario = userRepository.findById(user.getId_usuario());
        if (existingUsuario.isPresent()) {
            User updatedUsuario = existingUsuario.get();
            updatedUsuario.setId_cliente(user.getId_cliente());
            updatedUsuario.setUsuario(user.getUsuario());
            updatedUsuario.setCorreo(user.getCorreo());
            updatedUsuario.setRoles(user.getRoles());
            return userRepository.save(updatedUsuario);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: " + user.getId_usuario());
        }
    }
    
    @Override
    public void eliminarUsuario(int id_usuario) {
        userRepository.deleteById(id_usuario);
    }
    
    @Override
    public List<User> getAllUsuarios() {
        return userRepository.findAll();
    }
    
    @Override
    public List<User> getUsuarioByUsuarioOrCorreo(String usuario, String correo) {
        
        // Llamar al método de búsqueda en el repositorio
        return userRepository.findByUsuarioOrCorreo(usuario, correo);
    }

    @Override
    public User obtenerUsuarioPorId(int id_usuario) {
        Optional<User> usuarioOpt = userRepository.findById(id_usuario);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            throw new RuntimeException("Cliente no encontrado con id: " + id_usuario);
        }
    }
    
}
