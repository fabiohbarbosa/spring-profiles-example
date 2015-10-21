package br.com.gsw.example.spring.profiles.web.rest.handler;

public class ErrorDTO {
    private String message;

    public ErrorDTO() {
    }

    public ErrorDTO(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}