package com.webigode.cursospringionic.domain.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int code;
	private String descricao;
	
	private Perfil(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil valueOf(Integer code) {
		
		if(code == null) {
			return null;
		}
		
		for(Perfil value : Perfil.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código do Perfil inválido");
	}
	
}

