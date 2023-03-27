package br.com.farmacos.restspringbootcontrolefamacos.services;

import com.auth0.jwt.interfaces.Payload;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidationCPFUserExists.class)
public @interface CpfJaCadastrado{
	
	String message() default "Cpf já cadastrado";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] 	payload() default{};
}

