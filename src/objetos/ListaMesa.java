package objetos;

import java.util.ArrayList;
import java.util.List;

public class ListaMesa {
    private List<Mesa> listaMesas = new ArrayList<Mesa>();

    public ListaMesa(List<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }

    public ListaMesa() {
    }

    public List<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(List<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }

    public void addMesa(Mesa mesa) {
        listaMesas.add(mesa);
    }
}
