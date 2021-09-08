package br.com.fiap.livraria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.livraria.model.dto.AtualizaPrecoLivroDTO;
import br.com.fiap.livraria.model.dto.LivroDTO;
import br.com.fiap.livraria.model.dto.NovoLivroDTO;

@Service
public class LivrariaServiceImpl implements LivrariaService {

	@Override
	public List<LivroDTO> listarLivros(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO buscarLivroPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO criar(NovoLivroDTO livroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO atualizar(Long id, NovoLivroDTO livroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO atualizarPreco(Long id, AtualizaPrecoLivroDTO livroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarLivro(Long id) {
		// TODO Auto-generated method stub
		
	}

}
