package br.edu.infnet.MarcosLance_api.arq.trofeu.exception;

public class TrofeuRemotoNaoEncontradoException extends RuntimeException {
	public TrofeuRemotoNaoEncontradoException(Long trofeuID) {
		super("O trofeu id: " + trofeuID + " nao foi encontrado no trofeu-service");
	}
}
