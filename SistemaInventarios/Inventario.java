public class Inventario {

    private Producto[] productos;
    
    public Inventario(int tamaño) {
        productos = new Producto[tamaño];
    }

    public void agregarProducto(int indice, String nombre, int cantidad) {
        productos[indice] = new Producto(nombre, cantidad);
    }

    public void actualizarCantidad(int indice, int cantidad) {
        if (productos[indice] != null) {
            productos[indice].setCantidad(cantidad);
        }
    }

    public void mostrarInventario() {
        for (Producto producto : productos) {
            if (producto != null) {
                System.out.println(producto);
            }
        }
    }
}

class Producto {
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + ": " + cantidad;
    }
}

