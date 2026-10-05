package br.edu.infnet.MarcosLance_api.arq.game;

public class GameNaoEncontradoException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public GameNaoEncontradoException(Long id) {
		super("Game não encontrado.");
	}
}
