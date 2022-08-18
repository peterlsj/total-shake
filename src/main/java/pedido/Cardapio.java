package pedido;

import ingredientes.Ingrediente;

import java.util.TreeMap;

public class Cardapio {
    private TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        if (preco <= 0.0) {
            throw new IllegalArgumentException("Preco invalido.");
        }
            precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        if(ingrediente == null){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        if (preco <= 0.0) {
            throw new IllegalArgumentException("Preco invalido.");
        }
        return precos.replace(ingrediente, buscarPreco(ingrediente), preco);
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
        if(ingrediente == null){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
       return precos.remove(ingrediente, buscarPreco(ingrediente));
    }

    public Double buscarPreco(Ingrediente ingrediente){
        var preco = precos.get(ingrediente);
        if(preco == null) {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return preco;
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
