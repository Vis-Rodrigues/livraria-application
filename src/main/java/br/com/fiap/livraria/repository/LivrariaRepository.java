package br.com.fiap.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.livraria.entity.Livro;

public interface LivrariaRepository extends JpaRepository<Livro, Integer> {

	List<Livro> findAllByTituloLike(String titulo);
}
