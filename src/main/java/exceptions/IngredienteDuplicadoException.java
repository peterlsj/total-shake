package exceptions;


public class IngredienteDuplicadoException extends IllegalArgumentException{
    static final String mensagem = "Este ingrediente já foi cadastrado";

    public IngredienteDuplicadoException() {
        super(mensagem);
    }
}
