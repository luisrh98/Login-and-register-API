package admin_user.controller;

import admin_user.Service.ClienteService;
import admin_user.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteDetailsService clienteDetailsService;
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/registration")
    public String getReStrationPage(@ModelAttribute("user")ClienteDto clienteDto){
        return "register";
    }
    
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user")ClienteDto clienteDto, Model model){
        clienteService.save(clienteDto);
        model.addAttribute("message", "Registered Successfuly!");
        return "redirect:/login";
    }
    
}
