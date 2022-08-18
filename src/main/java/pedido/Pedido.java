package pedido;

import ingredientes.Adicional;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens, Cliente cliente) {
        this.id = id;
        this.itens = itens;
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio) {
        double total = 0;

        for (ItemPedido item : itens) {
            var multiplicadorTamanhoShake = item.getShake().getTipoTamanho().multiplicador;
            var precoBase = cardapio.buscarPreco(item.getShake().getBase());

            if (item.getShake().getAdicionais() != null) {
                var adicionais = item.getShake().getAdicionais();
                for (Adicional adicional : adicionais) {
                    var valorAdicional = (cardapio.buscarPreco(adicional)) * item.getQuantidade();
                    total += valorAdicional;
                }
            }
            var totalItem = ((multiplicadorTamanhoShake * precoBase) * item.getQuantidade());
            total += totalItem;
        }

        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado) {
        var existe = false;
        var quantidade = 0;
        var index = 0;
        for (ItemPedido item : itens) {
            if (item.getShake() == itemPedidoAdicionado.getShake()) {
                existe = true;
                quantidade = item.getQuantidade();
                index = itens.indexOf(item);
                break;
            }
        }
        if (existe) {
            itemPedidoAdicionado.setQuantidade(quantidade + itemPedidoAdicionado.getQuantidade());
            itens.set(index, itemPedidoAdicionado);
        } else {
            itens.add(itemPedidoAdicionado);
        }
    }


    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {

        var existe = false;
        var quantidade = 0;
        var index = 0;
        for (ItemPedido item : itens) {
            if (item.getShake().toString().equals(itemPedidoRemovido.getShake().toString())) {
                existe = true;
                quantidade = item.getQuantidade();
                index = itens.indexOf(item);
                break;
            }
        }

        if (existe) {
            itemPedidoRemovido.setQuantidade(quantidade - 1);
            itens.set(index, itemPedidoRemovido);
            if (quantidade - 1 <= 0) {
                itens.remove(itemPedidoRemovido);
            }
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
        return false;
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
