package br.com.fiap.livraria.model.dto;

import java.util.Date;

import br.com.fiap.livraria.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String ISBN;
	private Date dataDePublicacao;
	private double preco;

	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.ISBN = livro.getIsbn();
		this.titulo = livro.getTitulo();
		this.descricao = livro.getDescricao();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.preco = livro.getPreco();
	}
}
