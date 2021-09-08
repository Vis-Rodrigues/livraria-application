package br.com.fiap.livraria.entity;

import java.util.Date;

import javax.persistence.*;

import br.com.fiap.livraria.model.dto.NovoLivroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_LIVRO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column
	private String isbn;
	
	@Column
	private double preco;
	
	@Column
	private Date dataDePublicacao;
	
	@Column
	private String descricao;

	public Livro(NovoLivroDTO livroDTO) {
		this.isbn = livroDTO.getISBN();
		this.preco = livroDTO.getPreco();
		this.titulo = livroDTO.getTitulo();
		this.descricao = livroDTO.getDescricao();
		this.dataDePublicacao = new Date();
	}
}
