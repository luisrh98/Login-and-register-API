/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin_user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC-56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    
    private int id_cliente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;
    
}
