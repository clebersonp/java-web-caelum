package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
	
	private Long id;
	
	@Size(min=5)
	private String descricao;
	
	private boolean finalizado;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy") // para o spring saber transformar o texto em Calendar
	private Calendar dataFinalizado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(Calendar dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}
}
