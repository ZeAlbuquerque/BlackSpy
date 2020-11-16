package br.com.fiap.BlackSpy.service.exeption;

public class SenhaInvalidaException extends RuntimeException {

    public SenhaInvalidaException() {
        super("Senha Invalida");
    }
}
