package br.edu.infnet.MarcosLance_api.batch;


public class TrofeuRequest {


		private String nome;
		private String tipo;
		

		public TrofeuRequest(String nome, String tipo) {
			
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

	
}
