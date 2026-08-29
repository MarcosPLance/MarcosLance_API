package br.edu.infnet.MarcosLance_api.domain;

public class Jogador extends Usuario {
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
	
	
}
