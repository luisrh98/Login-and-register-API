package admin_user.Service;

import admin_user.dto.UserDto;
import admin_user.model.Cliente;
import admin_user.model.User;
import admin_user.repositories.ClienteRepository;
import admin_user.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsuario(), passwordEncoder.encode(userDto.getPassword()), userDto.getCorreo(), userDto.getTelefono(), userDto.getRoles());
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
            updatedUsuario.setTelefono(user.getTelefono());
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

    @Override
    public List<UserDto> obtenerUsuarios() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream().map(usuario -> {
            UserDto usuarioDto = new UserDto(usuario);
            Optional<Cliente> clienteOpt = clienteRepository.findByCorreoOrTelefono(usuario.getCorreo(), usuario.getTelefono());
            clienteOpt.ifPresent(cliente -> usuarioDto.setId_cliente(cliente.getId_cliente()));
            return usuarioDto;
        }).collect(Collectors.toList());
    }
}