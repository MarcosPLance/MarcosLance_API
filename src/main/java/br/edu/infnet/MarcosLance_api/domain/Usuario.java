package br.edu.infnet.MarcosLance_api.domain;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

public abstract class Usuario implements Identificavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nome;
	private String sobrenome;
	@Email
	private String email;
	private LocalDateTime dataNascimento;
	
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public Usuario(Long ID, String nome, String sobrenome, String email) {
		super();
		this.ID = ID;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return String.format("Usuario {nome='%s', sobrenome='%s', email='%s' ",
				nome,
				sobrenome,
				email
				);
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		this.ID = iD;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
