package br.com.fiap.livraria.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizaLivroDTO {
	private String titulo;
	private String descricao;
	private String ISBN;
	private double preco;
	private Date dataDePublicacao;
}
