package com.example.demo.zoo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Zoo not found")
public class ZooNotFoundException extends RuntimeException {
}