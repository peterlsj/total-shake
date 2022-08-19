

package armazem;

import exceptions.IngredienteDuplicadoException;
import exceptions.IngredienteNaoEncontradoException;
import exceptions.IngredienteNaoEncontradoOuQuantidadeInvalidaException;
import ingrediente.Ingrediente;

import java.util.Map;
import java.util.TreeMap;

public class Armazem {

    private TreeMap<Ingrediente, Integer> estoque;

    public Armazem() {
        this.estoque = new TreeMap<>();
    }

    public Map<Ingrediente, Integer> getEstoque() {
        return estoque;
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) throws IngredienteDuplicadoException {

        if (estoque.containsKey(ingrediente)) {
            throw new IngredienteDuplicadoException();
        }
        estoque.put(ingrediente, 0);
    }

    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) throws IngredienteNaoEncontradoException {
        if (!estoque.containsKey(ingrediente)) {
            throw new IngredienteNaoEncontradoException();
        }
        estoque.remove(ingrediente);
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) throws IngredienteNaoEncontradoOuQuantidadeInvalidaException {
        if (!estoque.containsKey(ingrediente) || quantidade <= 0) {
            throw new IngredienteNaoEncontradoOuQuantidadeInvalidaException();
        }
        var quantidadeExistente = estoque.get(ingrediente);
        estoque.replace(ingrediente, (quantidadeExistente + quantidade));
    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) throws IngredienteNaoEncontradoOuQuantidadeInvalidaException {
        if (!estoque.containsKey(ingrediente) || quantidade <= 0) {
            throw new IngredienteNaoEncontradoOuQuantidadeInvalidaException();
        }
        var quantidadeExistente = estoque.get(ingrediente);
        estoque.replace(ingrediente, (quantidadeExistente - quantidade));
    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) throws IngredienteNaoEncontradoException {

        if (!estoque.containsKey(ingrediente)) {
            throw new IngredienteNaoEncontradoException();
        }

        return estoque.get(ingrediente);
    }

    public boolean consultarIngrediente(Ingrediente ingrediente) {
        return estoque.containsKey(ingrediente);
    }
}