package br.edu.infnet.arq.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.edu.infnet.arq.trofeu.IdentificadorDuplicadoException;
import br.edu.infnet.arq.trofeu.TrofeuNaoEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private ResponseEntity<ErroResponse> criarResposta(HttpStatus status, String mensagem){
		
		ErroResponse erro = new ErroResponse(
				status.value(),
				status.getReasonPhrase(),
				mensagem,
				LocalDateTime.now()
				);

		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroResponse> tratarErroValidacao(MethodArgumentNotValidException exception){
		
		String mensagem = exception
						.getBindingResult()
						.getFieldErrors()
						.stream()
						.map(erro -> erro.getField() + ":" + erro.getDefaultMessage())
						.collect(Collectors.joining(";"));
		
		return criarResposta(HttpStatus.BAD_REQUEST, mensagem);
	}

	@ExceptionHandler(TrofeuNaoEncontradoException.class)
	public ResponseEntity<ErroResponse> tratarRecursoNaoEncontrado(TrofeuNaoEncontradoException exception){
		
		return criarResposta(HttpStatus.NOT_FOUND, exception.getMessage());
	}
	
	@ExceptionHandler(IdentificadorDuplicadoException.class)
	public ResponseEntity<ErroResponse> tratarIdentificadorDuplicado(IllegalArgumentException exception){
		return criarResposta(HttpStatus.CONFLICT, exception.getMessage());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErroResponse> tratarArgumentoInvalido(IllegalArgumentException exception){
		return criarResposta(HttpStatus.BAD_REQUEST, exception.getMessage());
	}
	
	
	
}
