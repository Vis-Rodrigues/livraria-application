package br.com.fiap.livraria.controller;

import java.util.List;

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

import br.com.fiap.livraria.model.dto.NovoLivroDTO;
import br.com.fiap.livraria.model.dto.LivroDTO;
import br.com.fiap.livraria.model.dto.AtualizaLivroDTO;
import br.com.fiap.livraria.model.dto.AtualizaPrecoLivroDTO;
import br.com.fiap.livraria.service.LivrariaService;

@RestController
@RequestMapping("livros")
public class LivrariaController {
	
	private LivrariaService livrariaService;
	
	public LivrariaController(LivrariaService livrariaService) {
		this.livrariaService = livrariaService;
	}
	
	@GetMapping
	public List<LivroDTO> buscarLivros(@RequestParam(required=false,value="titulo")String titulo){
		return livrariaService.listarLivros(titulo);
	}
	
	@GetMapping("{id}")
	public LivroDTO buscarPorId(@PathVariable Long id) {
		return livrariaService.buscarLivroPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroDTO criar(@RequestBody NovoLivroDTO createUpdateLivroDTO) {
		return livrariaService.criar(createUpdateLivroDTO);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public LivroDTO atualizar(@PathVariable Long id,
							  @RequestBody AtualizaLivroDTO updateLivroDTO) {
		return livrariaService.atualizar(id, updateLivroDTO);
	}
	
	@PatchMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public LivroDTO atualizarPreco(@PathVariable Long id,
								   @RequestBody AtualizaPrecoLivroDTO dto) {
		return livrariaService.atualizarPreco(id, dto);
		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLivro(@PathVariable Long id) {
		livrariaService.deletarLivro(id);
	}
	
}
