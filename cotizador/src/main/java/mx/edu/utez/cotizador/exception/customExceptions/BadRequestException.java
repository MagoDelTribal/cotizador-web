package mx.edu.utez.cotizador.exception.customExceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);

    }
}
