package com.webigode.cursospringionic.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa física"),
	PESSOAJURIDICA(2, "Pessoa jurídica");
	
	private int code;
	private String descricao;
	
	private TipoCliente(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente valueOf(Integer code) {
		
		if(code == null) {
			return null;
		}
		
		for(TipoCliente value : TipoCliente.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código do TipoCliente inválido");
	}
	
}

