package com.people.register.api.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "CPF is already in use")
public class CPFIsAlreadyInUseException extends RuntimeException {
}
