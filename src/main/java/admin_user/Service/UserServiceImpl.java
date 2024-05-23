
package admin_user.Service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repositories.UserRepository;
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
    
}
