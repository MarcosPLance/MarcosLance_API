package br.edu.infnet.MarcosLance_api.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "trofeus")
public class Trofeu implements Identificavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nome;
	private String tipo;
	
	@ManyToOne
	private Game game;
	
	@OneToMany(mappedBy = "trofeu")
	@JsonManagedReference
	private List<Manual> manuais = new ArrayList<Manual>();
	
	
	public Trofeu() {
		
	}
	
	public Trofeu(String nome, String tipo, Game game) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.game = game;
	}
	
	
	public void adicionarManual(Manual manual) {
		
		if(manual == null) {
			throw new IllegalArgumentException("Precisa existir um Manual!!!");
		}
		
		manuais.add(manual);
		manual.setTrofeu(this);
	}
	
	@Override
	public String toString() {
		
		String nomeGame = game != null ? game.getNome() : "Sem trofeu";
		
		return String.format("Trofeu {Nome='%s', Tipo='%s', Game='%s', Game 2='%s', manuais=%d}",
				nome,
				tipo,
				game,
				nomeGame,
				manuais.size()
				);
		
	}	
	
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
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

	public List<Manual> getManuais() {
		return manuais;
	}

	public void setManuais(List<Manual> manuais) {
		this.manuais = manuais;
	}

	@Override
	public Long getID() {
		// TODO Auto-generated method stub
		return null;
	}


	
	


}
