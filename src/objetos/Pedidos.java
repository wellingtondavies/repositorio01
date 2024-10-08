package objetos;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private int mesa;
    private String garcom;
    private int estoque;
    private double valorPedido;
    private List<Pedidos> listaPedidos = new ArrayList<Pedidos>();

    public Pedidos(int mesa, String garcom, int estoque, double valorPedido, List<Pedidos> listaPedidos) {
        this.mesa = mesa;
        this.garcom = garcom;
        this.estoque = estoque;
        this.valorPedido = valorPedido;
        this.listaPedidos = listaPedidos;
    }

    public Pedidos() {
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getGarcom() {
        return garcom;
    }

    public void setGarcom(String garcom) {
        this.garcom = garcom;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public List<Pedidos> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedidos> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "mesa=" + mesa +
                ", garcom='" + garcom + '\'' +
                ", estoque=" + estoque +
                ", valorPedido=" + valorPedido +
                '}';
    }
    public void addListaPedido(Pedidos pedido) {
        this.listaPedidos.add(pedido);
    }
}
