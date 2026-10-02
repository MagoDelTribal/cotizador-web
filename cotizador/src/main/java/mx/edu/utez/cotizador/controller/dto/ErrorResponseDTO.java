package mx.edu.utez.cotizador.controller.dto;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private int status;
    private String error;
    private Object message;
    private LocalDateTime timestamp;

    public ErrorResponseDTO(int status, String error, Object message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Getters y Setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public Object getMessage() { return message; }
    public void setMessage(Object message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}