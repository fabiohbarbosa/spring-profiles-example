package br.com.gsw.example.spring.profiles.web.rest.handler;

import javax.xml.bind.annotation.XmlElement;

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

    @XmlElement
    public void setMessage(final String message) {
        this.message = message;
    }

}