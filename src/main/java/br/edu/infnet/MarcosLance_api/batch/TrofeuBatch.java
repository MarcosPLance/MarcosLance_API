package br.edu.infnet.MarcosLance_api.batch;

public class TrofeuBatch {
	private Long id;
	private String nome;
	private String tipo;
	
	public TrofeuBatch(Long id2, String upperCase, String tipo2) {
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		return String.format("TrofeuBatch {id=%d, nome=$d, tipo=%d, id,nome, tipo");
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

