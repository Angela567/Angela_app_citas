package co.edu.poli.appcitas.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.poli.appcitas.entities.Usuario;

public interface IUsuariosRepository extends CrudRepository<Usuario, Long> {

}
