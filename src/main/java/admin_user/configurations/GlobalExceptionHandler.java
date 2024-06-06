package admin_user.configurations;

import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = "Error: ";
        Throwable rootCause = ex.getRootCause(); // Obtener la causa raíz de la excepción
        if (rootCause instanceof SQLIntegrityConstraintViolationException) {
            SQLIntegrityConstraintViolationException sqlException = (SQLIntegrityConstraintViolationException) rootCause;
            int errorCode = sqlException.getErrorCode(); // Obtener el código de error SQL
            if (errorCode == 1062) { // Código de error específico para violación de restricción única en MySQL
                String message = sqlException.getMessage().toLowerCase(); // Convertir a minúsculas para una comparación sin distinción entre mayúsculas y minúsculas
                if (message.contains("correo_unique")) {
                    errorMessage += "El correo electrónico ya está registrado.";
                } else if (message.contains("telefono_unique")) {
                    errorMessage += "El teléfono ya está registrado.";
                } else if (message.contains("username_unique")) {
                    errorMessage += "El nombre de usuario ya está registrado.";
                } else {
                    errorMessage += "El dato ya está registrado.";
                }
            }
        } else {
            errorMessage += "Ocurrió un error al procesar la solicitud.";
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
