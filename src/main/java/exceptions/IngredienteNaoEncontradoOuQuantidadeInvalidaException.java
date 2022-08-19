package exceptions;

public class IngredienteNaoEncontradoOuQuantidadeInvalidaException extends IllegalArgumentException {

    static final String mensagem = "Ingrediente não encontrado ou quantidade inválida";

    public IngredienteNaoEncontradoOuQuantidadeInvalidaException() {
        super(mensagem);
    }
}
