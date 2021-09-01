package br.com.fiap.livraria.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.livraria.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.model.dto.LivroDTO;
import br.com.fiap.livraria.model.dto.UpdatePrecoLivroDTO;

@RestController
@RequestMapping("livros")
public class LivrariaController {
	
	//mock
	private List<LivroDTO> livros;
	
	//mock
	public LivrariaController() {
		LivroDTO livro = new LivroDTO();
		livro.setId(1);
		livro.setTitulo("Aprenda Spring");
		livro.setDescricao("Passo a passo com Spring Framework");
		livro.setDataDePublicacao(new Date());
		livro.setISBN("987134354354654");
		livro.setPreco(20.4);
		
		LivroDTO livro1 = new LivroDTO();
		livro1.setId(2);
		livro1.setTitulo("Java");
		livro1.setDescricao("Tudo sobre Java");
		livro1.setDataDePublicacao(new Date());
		livro1.setISBN("132465789456321");
		livro1.setPreco(30.4);
		
		livros = new ArrayList<LivroDTO>();
		livros.add(livro);
		livros.add(livro1);
	}
	
	@GetMapping
	public List<LivroDTO> buscarLivros(@RequestParam(required=false,value="titulo")String titulo){
		return livros.stream()
				.filter(dto -> titulo == null || dto.getTitulo()
				.contains(titulo)).collect(Collectors.toList());
		
	}
	
	@GetMapping("{isbn}")
	public LivroDTO buscarPorId(@PathVariable String isbn) {
		return buscarLivroPorISBN(isbn);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroDTO criar(@RequestBody CreateUpdateLivroDTO createUpdateLivroDTO) {
		LivroDTO livro = new LivroDTO();
		livro.setId(livros.size()+1);
		livro.setTitulo(createUpdateLivroDTO.getTitulo());
		livro.setDescricao(createUpdateLivroDTO.getDescricao());
		livro.setISBN(createUpdateLivroDTO.getISBN());
		livro.setPreco(createUpdateLivroDTO.getPreco());
		livro.setDataDePublicacao(new Date());
		livros.add(livro);
		return livro;
	}
	
	@PutMapping("{isbn}")
	@ResponseStatus(HttpStatus.OK)
	public LivroDTO atualizar(@PathVariable String isbn,
							  @RequestBody CreateUpdateLivroDTO createUpdateLivroDTO) {
		
		LivroDTO livro = buscarLivroPorISBN(isbn);
		livro.setTitulo(createUpdateLivroDTO.getTitulo());
		livro.setDescricao(createUpdateLivroDTO.getDescricao());
		livro.setISBN(createUpdateLivroDTO.getISBN());
		livro.setPreco(createUpdateLivroDTO.getPreco());
		livro.setDataDePublicacao(new Date());
		return livro;
	}
	
	@PatchMapping("{isbn}")
	@ResponseStatus(HttpStatus.OK)
	public LivroDTO atualizarPreco(@PathVariable String isbn,
								   @RequestBody UpdatePrecoLivroDTO dto) {
		LivroDTO livro = buscarLivroPorISBN(isbn);
		livro.setPreco(dto.getPreco());
		
		return livro;
		
	}
	
	@DeleteMapping("{isbn}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLivro(@PathVariable String isbn) {
		LivroDTO livro = buscarLivroPorISBN(isbn);
		livros.remove(livro);
	}
	
	private LivroDTO buscarLivroPorISBN(String isbn) {
		return livros.stream().filter(dto -> dto.getISBN().equals(isbn))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
