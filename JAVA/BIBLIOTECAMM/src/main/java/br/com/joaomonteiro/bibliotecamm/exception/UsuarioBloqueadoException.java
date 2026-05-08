package br.com.joaomonteiro.bibliotecamm.exception;

public class UsuarioBloqueadoException extends RuntimeException {
  public UsuarioBloqueadoException(String message) {
    super(message);
  }
}
