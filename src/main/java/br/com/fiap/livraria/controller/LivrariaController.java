package br.com.fiap.livraria.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
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
	
	@GetMapping
	public List<LivroDTO> buscarLivros(@RequestParam(required=false,value="titulo")String titulo){
		
		return lstLivros().stream()
				.filter(dto -> titulo == null || dto.getTitulo()
				.contains(titulo)).collect(Collectors.toList());
		
	}
	
	@GetMapping("{id}")
	public LivroDTO buscarPorId(@PathVariable int id) {
		List<LivroDTO> livros = lstLivros();
		switch (id) {
		case 1:
			return livros.get(0);
		case 2:
			return livros.get(1);
		default:
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
		}
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroDTO criar(@RequestBody CreateUpdateLivroDTO createUpdateLivroDTO) {
		LivroDTO livro = new LivroDTO();
		livro.setId(3);
		livro.setTitulo(createUpdateLivroDTO.getTitulo());
		livro.setDescricao(createUpdateLivroDTO.getDescricao());
		livro.setISBN(createUpdateLivroDTO.getISBN());
		livro.setPreco(createUpdateLivroDTO.getPreco());
		livro.setDataDePublicacao(new Date());
		return livro;
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public LivroDTO atualizar(@PathVariable int id,
							  @RequestBody CreateUpdateLivroDTO createUpdateLivroDTO) {
		LivroDTO livro = new LivroDTO();
		livro.setId(id);
		livro.setTitulo(createUpdateLivroDTO.getTitulo());
		livro.setDescricao(createUpdateLivroDTO.getDescricao());
		livro.setISBN(createUpdateLivroDTO.getISBN());
		livro.setPreco(createUpdateLivroDTO.getPreco());
		livro.setDataDePublicacao(new Date());
		return livro;
	}
	
	@PatchMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public LivroDTO atualizarPreco(@PathVariable int id,
								   @RequestBody UpdatePrecoLivroDTO dto) {
		LivroDTO livro = buscarPorId(id);
		livro.setPreco(dto.getPreco());
		
		return livro;
		
	}
	
	private List<LivroDTO> lstLivros(){
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
		
		List<LivroDTO> livros = new ArrayList<LivroDTO>();
		
		livros.add(livro);
		livros.add(livro1);
		
		return livros;
	}
}
