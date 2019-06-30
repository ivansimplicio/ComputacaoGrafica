package cg.exceptions;

/**
 *  Exceção que será lançada caso ocorra algum erro no processo de recorte da reta.
 * 
 * @author Ivanildo Simplício
 */
public class RecorteException extends Exception {

    public RecorteException(String mensagem) {
        super(mensagem);
    } 
}