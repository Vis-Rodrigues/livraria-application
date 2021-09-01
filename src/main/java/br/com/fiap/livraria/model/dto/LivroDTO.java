package br.com.fiap.livraria.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
	
	private int id;
	private String titulo;
	private String descricao;
	private String ISBN;
	private Date dataDePublicacao;
	private double preco;
}
