package co.edu.poli.appcitas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.appcitas.dto.UsuariosDTO;
import co.edu.poli.appcitas.entities.Usuario;
import co.edu.poli.appcitas.repositories.IUsuariosRepository;
import co.edu.poli.appcitas.services.IUsuariosService;

@Service
public class UsuariosServiceImpl implements IUsuariosService {
	
	@Autowired
	private IUsuariosRepository usuariosRepo;

	@Override
	public List<UsuariosDTO> consultarUsuarios() {
		List<Usuario> lstUsuarios = new ArrayList<Usuario>();
		List<UsuariosDTO> lstUsuariosDTO = new ArrayList<UsuariosDTO>();
		UsuariosDTO usuario;
		
		for(Usuario u : lstUsuarios) {
			usuario = new UsuariosDTO();
			usuario.setIdUsuario(u.getIdUsuario());
			usuario.setTipoIdentificacion(u.getTipoIdentificacion());
			usuario.setNombres(u.getNombres());
			usuario.setApellidos(u.getApellidos());
			usuario.setFechaNacimiento(u.getFechaNacimiento());
			usuario.setSexo(u.getSexo());
			usuario.setCelular(u.getCelular());
			usuario.setCorreo(u.getCorreo());
			usuario.setContrasena(u.getContrasena());
			usuario.setEstado(u.getEstado());
			usuario.setTipoUsuario(u.getTipoUsuario());
			lstUsuariosDTO.add(usuario);
		}
		return lstUsuariosDTO;
	}

	@Override
	public UsuariosDTO crearUsuario(UsuariosDTO usuario) {
		Usuario u = new Usuario();
		u.setIdUsuario(usuario.getIdUsuario());
		u.setTipoIdentificacion(usuario.getTipoIdentificacion());
		u.setNombres(usuario.getNombres());
		u.setApellidos(usuario.getApellidos());
		u.setFechaNacimiento(usuario.getFechaNacimiento());
		u.setSexo(usuario.getSexo());
		u.setCelular(usuario.getCelular());
		u.setCorreo(usuario.getCorreo());
		u.setContrasena(usuario.getContrasena());
		u.setEstado(usuario.getEstado());
		u.setTipoUsuario(usuario.getTipoUsuario());
		usuariosRepo.save(u);
		return usuario;
	}

}
