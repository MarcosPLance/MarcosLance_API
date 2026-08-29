package br.edu.infnet.MarcosLance_api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "manuais")
public class Manual implements Identificavel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String titulo;
	private String descricao;
	private boolean perdivel;
	private String dificuldade;
	
	@JsonBackReference
	@Transient
	private Trofeu trofeu;
	
	protected Manual() {
		// TODO Auto-generated constructor stub
	}
	
	public Manual(Long ID, String titulo, String descricao, boolean perdivel, String dificuldade) {
		super();
		this.ID = ID;
		this.titulo = titulo;
		this.descricao = descricao;
		this.perdivel = perdivel;
		this.dificuldade = dificuldade;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPerdivel() {
		return perdivel;
	}

	public void setPerdivel(boolean perdivel) {
		this.perdivel = perdivel;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Trofeu getTrofeu() {
		return trofeu;
	}

	public void setTrofeu(Trofeu trofeu) {
		this.trofeu = trofeu;
	}
	
	@Override
	public String toString() {
		
		String nomeTrofeu = trofeu != null ? trofeu.getNome() : "Sem trofeu";
		
		return String.format("Manual {Titulo='%s', Descricao='%s', Perdivel='%s', Dificuldade='%s', Trofeu='%d'}",
				titulo,
				descricao,
				perdivel ? "sim": "não",
				dificuldade,
				nomeTrofeu
				);
		
	}

	@Override
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public boolean isPublicado() {
		// TODO Auto-generated method stub
		return false;
	}	
}
