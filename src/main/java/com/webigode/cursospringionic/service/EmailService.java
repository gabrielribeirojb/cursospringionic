package com.webigode.cursospringionic.service;

import org.springframework.mail.SimpleMailMessage;

import com.webigode.cursospringionic.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
	
}
