package br.com.fiap.livraria.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.*;

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
	private Integer quantidadePaginas;
	
	@Column
	private String isbn;
	
	@Column
	private BigDecimal preco;
	
	@Column
	private ZonedDateTime dataLancamento;
	
	@Column
	private String autor;
}
