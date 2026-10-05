package br.edu.infnet.MarcosLance_api.arq.jogador;

import br.edu.infnet.MarcosLance_api.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Jogador extends Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotBlank
	private String nick;
	private String console;
	
	
	public Jogador() {
		// TODO Auto-generated constructor stub
	}

	public Jogador(Long ID, String nome, String sobrenome, String email, String nick, String console) {
		super(ID, nome, sobrenome, email);
		this.nick = nick;
		this.console = console;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Player {'%s', nick='%s', console='%s'}",
				super.toString(),
				nick,
				console
				);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	
	
}
