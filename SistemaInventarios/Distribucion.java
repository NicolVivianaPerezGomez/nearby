import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Distribucion {

    private ArrayDeque<String> almacen;
    private LinkedList<Orden> colaOrdenes;
    private PriorityQueue<Orden> colaUrgente;

    public Distribucion() {
        almacen = new ArrayDeque<>();
        colaOrdenes = new LinkedList<>();
        colaUrgente = new PriorityQueue<>((o1, o2) -> Boolean.compare(o2.isurgente(), o1.isurgente()));
    }

    public void agregarCaja(String caja) {
        almacen.push(caja);
    }

    public void procesarOrden(Orden orden) {
        if (orden.isurgente()) {
            colaUrgente.add(orden);
        } else {
            colaOrdenes.add(orden);
        }
    }

    public void procesarSiguienteOrden() {
        if (!colaUrgente.isEmpty()) {
            System.out.println("Procesando orden urgente: " + colaUrgente.poll());
        } else if (!colaOrdenes.isEmpty()) {
            System.out.println("Procesando orden regular: " + colaOrdenes.poll());
        } else {
            System.out.println("No hay órdenes para procesar.");
        }
    }
}