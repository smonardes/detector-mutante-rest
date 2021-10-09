package cl.mercadolibre.xmen.detectormutante.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class MutanteException extends Exception implements Serializable {

    private static final long serialVersionUID = 4911789872653323071L;
    private final String errorCode;
    private final String[] errorParams;
    private final HttpStatus httpStatus;

    public MutanteException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorParams = new String[0];
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public MutanteException(String message, Throwable cause, String errorCode, String[] errorParams) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorParams = errorParams.clone();
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public MutanteException(String message, Throwable cause, String errorCode, HttpStatus httpStatus) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorParams = new String[0];
        this.httpStatus = httpStatus;
    }

    public MutanteException(String message, Throwable cause,
                            String errorCode, String[] errorParams, HttpStatus httpStatus) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorParams = errorParams.clone();
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String[] getErrorParams() {
        return this.errorParams.clone();
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
