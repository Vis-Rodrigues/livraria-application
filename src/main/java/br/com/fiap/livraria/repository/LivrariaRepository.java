package br.com.fiap.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.livraria.entity.Livro;

public interface LivrariaRepository extends JpaRepository<Livro, Long> {

	List<Livro> findAllByTituloLike(String titulo);
	
	@Query("select l from Livro l where l.titulo like %:titulo%")
	List<Livro> buscarLivroPorTitulo(String titulo);
}
