package co.edu.poli.appcitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.poli.appcitas.services.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private IUsuariosService usuariosService;
}
