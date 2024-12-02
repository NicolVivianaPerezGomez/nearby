import java.util.Scanner;

public class Interfaz {

    public static void main(String[] args) {
        Inventario inventario = new Inventario(10);
        GestionOrdenes gestionOrdenes = new GestionOrdenes();
        Distribucion distribucion = new Distribucion();
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de uso
        inventario.agregarProducto(0, "Producto1", 100);
        inventario.mostrarInventario();

        gestionOrdenes.agregarOrden("Cliente1", "Producto1", 10, false);
        gestionOrdenes.mostrarOrdenes();

        distribucion.agregarCaja("Caja1");
        distribucion.procesarOrden(new Orden("Cliente1", "Producto1", 10, true));
        distribucion.procesarSiguienteOrden();
    }
}
