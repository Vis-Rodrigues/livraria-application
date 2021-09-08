package br.com.fiap.livraria.service;

import java.util.List;

import br.com.fiap.livraria.model.dto.NovoLivroDTO;
import br.com.fiap.livraria.model.dto.LivroDTO;
import br.com.fiap.livraria.model.dto.AtualizaPrecoLivroDTO;

public interface LivrariaService{
	
	List<LivroDTO> listarLivros(String titulo);
	LivroDTO buscarLivroPorId(Long id);
	LivroDTO criar(NovoLivroDTO livroDTO);
	LivroDTO atualizar(Long id, NovoLivroDTO livroDTO);
	LivroDTO atualizarPreco(Long id, AtualizaPrecoLivroDTO livroDTO);
	void deletarLivro(Long id);
	
}
