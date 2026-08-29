package br.edu.infnet.MarcosLance_api.domain;

public class Administrador extends Usuario {
	private boolean aprovaManual;
	private String telefone;
	
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}


	
	
	public Administrador(Long ID, String nome, String sobrenome, String email, boolean aprovaManual, String telefone){
		super(ID, nome, sobrenome, email);
		this.aprovaManual = aprovaManual;
		this.telefone = telefone;
	}




	@Override
	public String toString() {
		return String.format("Admin {%s, aprovaManual='%s', telefone='%s'}",
				super.toString(),
				aprovaManual,
				telefone				
				);
	}


	public boolean isAprovaManual() {
		return aprovaManual;
	}


	public void setAprovaManual(boolean aprovaManual) {
		this.aprovaManual = aprovaManual;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



}
