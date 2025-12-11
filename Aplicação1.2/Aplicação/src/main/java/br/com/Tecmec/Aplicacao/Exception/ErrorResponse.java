package br.com.Tecmec.Aplicacao.Exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private HttpStatus status;
    private int statusCode;
    private List<String> errors;

    public ErrorResponse(String message, String details, HttpStatus status, List<String> errors) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
        this.status = status;
        this.statusCode = status.value();
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<String> getErrors() {
        return errors;
    }
}


