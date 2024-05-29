package admin_user.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Cliente {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String correo;
    
}