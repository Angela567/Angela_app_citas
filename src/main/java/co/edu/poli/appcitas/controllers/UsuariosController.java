package co.edu.poli.appcitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.poli.appcitas.services.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private IUsuariosService usuariosService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios",usuariosService.consultarUsuarios());
		return "listar";
	}
}
