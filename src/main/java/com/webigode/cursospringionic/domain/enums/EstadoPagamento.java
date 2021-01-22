package com.webigode.cursospringionic.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int code;
	private String descricao;
	
	private EstadoPagamento(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento valueOf(Integer code) {
		
		if(code == null) {
			return null;
		}
		
		for(EstadoPagamento value : EstadoPagamento.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código do TipoCliente inválido");
	}
	
}

