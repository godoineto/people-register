package com.people.register.api.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "person not found")
public class PersonNotFound extends RuntimeException  {
}