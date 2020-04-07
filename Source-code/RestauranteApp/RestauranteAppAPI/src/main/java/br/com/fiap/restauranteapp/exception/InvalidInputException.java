package br.com.fiap.restauranteapp.exception;

import java.util.List;

import br.com.fiap.restauranteapp.vo.ErrorInfo;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1074726881651431946L;
	
	private List<ErrorInfo> errors;

    public List<ErrorInfo> getErrors() {
        return this.errors;
    }

    public InvalidInputException(List<ErrorInfo> errors) {
        super();
        this.errors = errors;
    }

    public InvalidInputException(String message, List<ErrorInfo> errors) {
        super(message);
        this.errors = errors;
    }

}