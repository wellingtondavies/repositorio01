package objetos;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private List<Produto> listaProdutos = new ArrayList<Produto>();

    public Cardapio(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Cardapio() {
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void addProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "produtos=" + listaProdutos +"\n"+
                '}';
    }
}
