package br.edu.infnet.MarcosLance_api.arq.trofeu.exception;

public class TrofeuServiceIndisponivelException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public TrofeuServiceIndisponivelException() {
			super("Não foi possivel acessar o trofeu-service");
		}
	
}
