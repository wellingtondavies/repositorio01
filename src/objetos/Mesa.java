package objetos;

public class Mesa {
    private int idMesa;
    private int capacidade;
    private boolean status;

    public Mesa(int idMesa, int capacidade, boolean status) {
        this.idMesa = idMesa;
        this.capacidade = capacidade;
        this.status = status;
    }

    public Mesa() {

    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "idMesa=" + idMesa +
                ", capacidade=" + capacidade +
                ", status=" + status +
                '}';
    }

}
