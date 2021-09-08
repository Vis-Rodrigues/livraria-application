package br.com.fiap.livraria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.livraria.entity.Livro;
import br.com.fiap.livraria.model.dto.AtualizaLivroDTO;
import br.com.fiap.livraria.model.dto.AtualizaPrecoLivroDTO;
import br.com.fiap.livraria.model.dto.LivroDTO;
import br.com.fiap.livraria.model.dto.NovoLivroDTO;
import br.com.fiap.livraria.repository.LivrariaRepository;

@Service
public class LivrariaServiceImpl implements LivrariaService {
	
	private final LivrariaRepository livrariaRepository;
	
	public LivrariaServiceImpl(LivrariaRepository livrariaRepository) {
		this.livrariaRepository = livrariaRepository;
	}
	
	@Override
	public List<LivroDTO> listarLivros(String titulo) {
		List<Livro> livroList;
		if(titulo!=null) {
			livroList = livrariaRepository.findAllByTituloLike(titulo);
		}else {
			livroList = livrariaRepository.findAll();
		}
		
		return livroList.stream()
				.map(livro -> new LivroDTO(livro))
				.collect(Collectors.toList());
	}

	@Override
	public LivroDTO buscarLivroPorId(Long id) {
		Livro livro = findLivroById(id);
		return new LivroDTO(livro);
	}
	
	private Livro findLivroById(Long id) {
		Livro livro = livrariaRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return livro;
	}

	@Override
	public LivroDTO criar(NovoLivroDTO livroDTO) {
		Livro livro = new Livro(livroDTO);
		Livro livroSalvo = livrariaRepository.save(livro);
		return new LivroDTO(livroSalvo);
	}

	@Override
	public LivroDTO atualizar(Long id, AtualizaLivroDTO livroDTO) {
		Livro livro = findLivroById(id);
		livro.setTitulo(livroDTO.getTitulo());
		livro.setDescricao(livroDTO.getDescricao());
		livro.setIsbn(livroDTO.getISBN());
		livro.setPreco(livroDTO.getPreco());
		livro.setDataDePublicacao(livroDTO.getDataDePublicacao());
		Livro livroSalvo = livrariaRepository.save(livro);
		return new LivroDTO(livroSalvo);
	}

	@Override
	public LivroDTO atualizarPreco(Long id, AtualizaPrecoLivroDTO livroDTO) {
		Livro livro = findLivroById(id);
		livro.setPreco(livroDTO.getPreco());
		Livro livroSalvo = livrariaRepository.save(livro);
		return new LivroDTO(livroSalvo);
	}

	@Override
	public void deletarLivro(Long id) {
		Livro livro = findLivroById(id);
		livrariaRepository.delete(livro);
	}

}
