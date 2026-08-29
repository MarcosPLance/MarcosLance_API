package br.edu.infnet.MarcosLance_api.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "games")
public class Game implements Identificavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nome;
	private String lancamento;
	private String distribuidora;
	
	
	@OneToMany(mappedBy = "game")
	private final List<Trofeu> trofeus = new ArrayList<Trofeu>();
	
	
	public Game() {
		
	}
	
	public Game(String nome, String string, String distribuidora) {
		super();
		this.nome = nome;
		this.lancamento = string;
		this.distribuidora = distribuidora;
	}
	
	public void adicionarTrofeu(Trofeu trofeu){
		
		if(trofeu == null) {
			throw new IllegalArgumentException("Precisa existir Trofeus!!!");
		}
		
		trofeus.add(trofeu);
		trofeu.setGame(this);
	}
	
	@Override
	public String toString() {
		return String.format("Game {nome='%s', Distribuidora='%s', lancamento='%d'}",
				nome,
				distribuidora,
				lancamento
				//trofeus.size()
				);
		
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
	public String getLancamento() {
		return lancamento;
	}
	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}
	public String getDistribuidora() {
		return distribuidora;
	}
	public void setDistribuidora(String distribuidora) {
		distribuidora = distribuidora;
	}

	public List<Trofeu> getTrofeus() {		
		return Collections.unmodifiableList(trofeus);
	}

	@Override
	public Long getID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
