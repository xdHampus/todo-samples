package com.todo.backend.service.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class ErrorDTO {
    public ErrorDTO() {
    }

    public ErrorDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDTO errorDTO = (ErrorDTO) o;
        return errorMessage.equals(errorDTO.errorMessage);
    }
    @Override
    public int hashCode() {
        return Objects.hash(errorMessage);
    }
    @Override
    public String toString() {
        return "ErrorDTO{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
