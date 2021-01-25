package com.webigode.cursospringionic.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.webigode.cursospringionic.domain.Cliente;
import com.webigode.cursospringionic.domain.enums.TipoCliente;
import com.webigode.cursospringionic.dto.ClienteNewDTO;
import com.webigode.cursospringionic.repositories.ClienteRepository;
import com.webigode.cursospringionic.resources.exceptions.FieldMessage;
import com.webigode.cursospringionic.service.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		//Lista vazia de FieldMessage para adicionar erros referentes aos campos e suas mensagens
		List<FieldMessage> list = new ArrayList<>();

		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCode()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido!"));
		}

		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCode()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido!"));
		}
		
		Cliente aux = repository.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		//Percorre lista de FieldMessage e inserindo erro corresponte para a lista de erros do framework
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		//Se não houver nenhum erro, a validação foi bem sucedida
		return list.isEmpty();
	}
}
