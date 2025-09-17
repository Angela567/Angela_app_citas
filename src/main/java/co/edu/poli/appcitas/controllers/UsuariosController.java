package co.edu.poli.appcitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.poli.appcitas.dto.UsuariosDTO;
import co.edu.poli.appcitas.services.IUsuariosService;
import jakarta.validation.Valid;

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
	
	@GetMapping("/registro")
	public String mostrarFormularioRegistro(Model model) {
		model.addAttribute("usuarioRegistroDTO", new UsuariosDTO());
		return "registro";
	}
	
	@PostMapping("/guardar")
	public String registrarUsuario(@Valid @ModelAttribute("usuarioRegistroDTO")UsuariosDTO usuario,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {
		if(result.hasErrors()) {
			return "registro";
	}
		try {
			usuariosService.crearUsuario(usuario);
			redirectAttributes.addFlashAttribute("mensajeExito", "Registro Exitoso!");
			return "redirect:/usuarios/listar";
		}catch(Exception e) {
			model.addAttribute("errorGeneral","Ocurrió un error en el registro: "+e.getMessage());
			return "registro";
		}
	}
}
