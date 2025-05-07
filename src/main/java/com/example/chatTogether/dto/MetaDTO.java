package com.example.chatTogether.dto;


import java.io.Serializable;
import java.util.Objects;

public class MetaDTO implements Serializable {

    private String code;
    private String message;
    private String displayMessage;
    private Boolean success;

    public MetaDTO(String code, String message, String displayMessage) {
        this.code = code;
        this.message = message;
        this.displayMessage = displayMessage;
    }

    public MetaDTO(Boolean success, String code, String message, String displayMessage) {
        this.code = code;
        this.message = message;
        this.success=success;
        this.displayMessage=displayMessage;
    }


    public MetaDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetaDTO)) return false;
        MetaDTO metaDTO = (MetaDTO) o;
        return Objects.equals(getCode(), metaDTO.getCode()) && Objects.equals(getMessage(), metaDTO.getMessage()) && Objects.equals(getDisplayMessage(), metaDTO.getDisplayMessage()) && getSuccess().equals(metaDTO.getSuccess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage(), getDisplayMessage(), getSuccess());
    }
}

