package br.edu.infnet.arq.exception;

import java.time.LocalDateTime;

public class ErroResponse {
	private int status;
	private String erro;
	private String mensagem;
	private LocalDateTime data;
	
	
	
	public ErroResponse(int status, String erro, String mensagem, LocalDateTime data) {
		super();
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
}
