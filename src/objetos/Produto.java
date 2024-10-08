package objetos;

public class Produto {
    private String nomeOrder;
    private int codigoItem;
    private double precoItem;
    private boolean disponivel;
    private int estoqueTotal;

    public Produto(String nomeOrder, int codigoItem, double precoItem, boolean disponivel,int estoqueTotal) {
        this.nomeOrder = nomeOrder;
        this.codigoItem = codigoItem;
        this.precoItem = precoItem;
        this.disponivel = disponivel;
        this.estoqueTotal = estoqueTotal;
    }

    public Produto() {

    }

    public String getNomeOrder() {
        return nomeOrder;
    }

    public void setNomeOrder(String nomeOrder) {
        this.nomeOrder = nomeOrder;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public int getEstoqueTotal() {
        return estoqueTotal;
    }
    public void setEstoqueTotal(int estoqueTotal) {
        this.estoqueTotal = estoqueTotal;
    }
    @Override
    public String toString() {
        return "Produto{" +
                "nomeOrder='" + nomeOrder + '\'' +
                ", codigoItem=" + codigoItem +
                ", precoItem=" + precoItem +
                ", disponivel=" + disponivel +
                ", estoqueTotal=" + estoqueTotal +
                '}';
    }
}
