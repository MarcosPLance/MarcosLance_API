package br.edu.infnet.arq.trofeu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Trofeu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
    @NotBlank(message = "O nome é obrigatório")
	private String nome;
    @NotBlank(message = "O tipo é obrigatório")
    private String tipo;
	

	public Trofeu() {
		
	}
	
	
	public void setID(Long iD) {
		ID = iD;
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

	public Long getID() {
		return ID;
	}


	
	


}
