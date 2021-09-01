package br.com.fiap.livraria.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateLivroDTO {
	private String titulo;
	private String descricao;
	private String ISBN;
	private double preco;
}
