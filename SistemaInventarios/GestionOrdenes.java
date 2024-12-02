import java.util.ArrayList;

public class GestionOrdenes {
    private ArrayList<Orden> ordenes;

    public GestionOrdenes() {
        ordenes = new ArrayList<>();
    }

    public void agregarOrden(String cliente, String producto, int cantidad, boolean urgente) {
        ordenes.add(new Orden(cliente, producto, cantidad, urgente));
    }

    public void modificarOrden(int indice, String cliente, String producto, int cantidad, boolean urgente) {
        if (indice >= 0 && indice < ordenes.size()) {
            ordenes.set(indice, new Orden(cliente, producto, cantidad, urgente));
        }
    }

    public void eliminarOrden(int indice) {
        if (indice >= 0 && indice < ordenes.size()) {
            ordenes.remove(indice);
        }
    }

    public void mostrarOrdenes() {
        for (Orden orden : ordenes) {
            System.out.println(orden);
        }
    }
}

class Orden {
    private String cliente;
    private String producto;
    private int cantidad;
    private boolean urgente;

    public Orden(String cliente, String producto, int cantidad, boolean urgente) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.urgente = urgente;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + ", Producto: " + producto + ", Cantidad: " + cantidad + ", Urgente: " + urgente;
    }
}