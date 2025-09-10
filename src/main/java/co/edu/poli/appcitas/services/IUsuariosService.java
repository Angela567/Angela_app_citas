package co.edu.poli.appcitas.services;

import java.util.List;

import co.edu.poli.appcitas.dto.UsuariosDTO;

public interface IUsuariosService {
	public List<UsuariosDTO> consultarUsuarios();
	
	public UsuariosDTO crearUsuario(UsuariosDTO usuario);
}
