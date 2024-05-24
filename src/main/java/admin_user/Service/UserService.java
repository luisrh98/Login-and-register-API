
package admin_user.Service;

import admin_user.dto.UserDto;
import admin_user.model.User;

public interface UserService {
    
    User save (UserDto userDto);
    
    User delete (UserDto userDto);
    
    User update (UserDto userDto);
}
