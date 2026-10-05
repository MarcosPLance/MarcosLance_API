package br.edu.infnet.arq.trofeu;

public class TrofeuNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TrofeuNaoEncontradoException(Long id) {
		super("Trofeu não encontrado. ID: " + id);
	}
}
