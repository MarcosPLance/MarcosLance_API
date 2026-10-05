package br.edu.infnet.arq.trofeu;

public class IdentificadorDuplicadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public IdentificadorDuplicadoException(Long id) {
		super("Ja existe um trofeu com esse ID: " + id);
	}
}
