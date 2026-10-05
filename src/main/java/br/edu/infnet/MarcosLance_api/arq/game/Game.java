package br.edu.infnet.MarcosLance_api.arq.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import br.edu.infnet.MarcosLance_api.arq.trofeu.Trofeu;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;


@Entity
public class Game  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nome;
	private String lancamento;
	private String distribuidora;
	
	@ElementCollection
	@CollectionTable(
			name = "game_trofeu",
			joinColumns = @JoinColumn(name = "game_id") 
			)
	//@Column(name = "trofeu_id")
//	private Set<Long> trofeusIds = new HashSet<Long>();
	private Set<Long> trofeusIds = new HashSet<>();
	
	
	
	public Game() {
	}
	
	
	public Game(String nome, String string, String distribuidora) {
		super();
		this.nome = nome;
		this.lancamento = string;
		this.distribuidora = distribuidora;
	}
	
	public Set<Long> getTrofeusIds() {
		return trofeusIds;
	}
	
	
	
	public void adicionarTrofeu(Long trofeuId){	
		trofeusIds.add(trofeuId);
	}
	
	
	
	@Override
	public String toString() {
		return String.format("Game {nome='%s', Distribuidora='%s', lancamento='%d'}",
				nome,
				distribuidora,
				lancamento
				);	
	}
	
	
	public Long getID() {
		return ID;
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
		this.distribuidora = distribuidora;
	}
}
