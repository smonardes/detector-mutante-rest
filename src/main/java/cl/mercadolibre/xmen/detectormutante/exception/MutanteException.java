package cl.mercadolibre.xmen.detectormutante.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class MutanteException extends Exception implements Serializable {

    private static final long serialVersionUID = 4911789872653323071L;
    private final String errorCode;
    private final String[] errorParams;
    private final HttpStatus httpStatus;

    public MutanteException(String message, Throwable cause, String errorCode, HttpStatus httpStatus) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorParams = new String[0];
        this.httpStatus = httpStatus;
    }
}
