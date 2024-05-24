/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package admin_user.Service;

import admin_user.dto.ClienteDto;
import admin_user.model.Cliente;

/**
 *
 * @author PC-56
 */
public interface ClienteService {
    
    Cliente save (ClienteDto clienteDto);
    
    Cliente delete (ClienteDto clienteDto);
    
    Cliente update (ClienteDto clienteDto);
    
}
