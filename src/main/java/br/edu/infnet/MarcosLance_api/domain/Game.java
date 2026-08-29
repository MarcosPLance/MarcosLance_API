package br.edu.infnet.MarcosLance_api.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game implements Identificavel {
	private String nome;
	private String lancamento;
	private String distribuidora;
	
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
