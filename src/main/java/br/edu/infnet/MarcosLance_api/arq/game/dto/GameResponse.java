package br.edu.infnet.MarcosLance_api.arq.game.dto;

import java.util.Set;

public record GameResponse(Long id, String nome, String lancamento, String distribuidora, Set<Long> trofeusIds) {
	
}
