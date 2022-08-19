package exceptions;

public class IngredienteNaoEncontradoException extends IllegalArgumentException {

    static final String mensagem = "Ingrediente não encontrado";

    public IngredienteNaoEncontradoException() {
        super(mensagem);
    }
}
