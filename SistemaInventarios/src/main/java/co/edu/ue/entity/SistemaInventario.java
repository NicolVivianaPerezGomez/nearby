package co.edu.ue.entity;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
    
    class SistemaInventario {
    	// LISTA DE ORDENES
        private static Producto[] inventario;

        // PILA PARA CAJAS ALMACEN
        ArrayList<Orden> ordenes;

        // LISTA DE ORDENES
        private ArrayDeque<Producto> almacen;

        // COLA ORDEN NORMAL
        private LinkedList<Orden> colaOrdenesRegulares;

        // COLA PRIORIZADA ORDEN URGENTE
        private PriorityQueue<Orden> colaOrdenesUrgentes;

        public SistemaInventario(int numProductos) {
            //INCIALIZAR EL ARREGLO CON SU TAMAÑO
            this.inventario = new Producto[numProductos];  // INICIALIZAR EL ARREGLO CON NUMERO DE PRODUCTOS
            this.ordenes = new ArrayList<>();
            this.almacen = new ArrayDeque<>();
            this.colaOrdenesRegulares = new LinkedList<>();
            this.colaOrdenesUrgentes = new PriorityQueue<>(Comparator.comparingInt(o -> o.isEsUrgente() ? 0 : 1));  // URGENTES
        }

        // INICIALIZAR INVENTARIO
        public void inicializarInventario() {
        // LLENAR EL INVENTARIO
            if (this.inventario != null) {
                inventario[0] = new Producto("Lavadoras", 52);
                inventario[1] = new Producto("Estufas", 20);
                inventario[2] = new Producto("Secadoras", 15);
                inventario[3] = new Producto("Neveras", 35);
                inventario[4] = new Producto("Microondas", 22);
                inventario[5] = new Producto("Televisores", 56);
            } else {
                System.out.println("Error: El inventario no está correctamente inicializado.");
            }
        }

        //CONSULTA INVENTARIO
        public void consultarInventario() {
            System.out.println("Inventario:");
            for (Producto p : inventario) {
                if (p != null) {
                    System.out.println(p.getNombre() + " - Cantidad: " + p.getCantidad());
                }
            }
        }
        
        //ACTUALIZAR EL INVENTARIO
        private static void actualizarInventario(Scanner scanner) {
        	for (Producto producto : inventario) {
                String nombre = null;
				if (producto.nombre.equalsIgnoreCase(nombre)) {
                    Object nuevaCantidad = null;
					producto.cantidad = (int) nuevaCantidad;
                    System.out.println("el inventario ha sido actualizado con éxito.");
                    return;
                }
            }
            System.out.println("Lo siento no he podido encontrar el producto.");
        }
        
        

        // AGREGAR UNA ORDEN
        public void agregarOrden(Orden orden) {
            ordenes.add(orden);
            if (orden.isEsUrgente()) {
                colaOrdenesUrgentes.offer(orden);
            } else {
                colaOrdenesRegulares.offer(orden);
            }
        }

        // ELIMINAR UNA ORDEN
        public void eliminarOrden(Orden orden) {
            ordenes.remove(orden);
            if (orden.isEsUrgente()) {
                colaOrdenesUrgentes.remove(orden);
            } else {
                colaOrdenesRegulares.remove(orden);
            }
        }

        // MODIFICAR UNA ORDEN
        public void modificarOrden(Orden orden, String nuevoProducto, int nuevaCantidad) {
            ordenes.stream()
                    .filter(o -> o.equals(orden))
                    .forEach(o -> {
                        o.productoSolicitado = nuevoProducto;
                        o.cantidadSolicitada = nuevaCantidad;
                    });
        }

        // PROCESAR UNA ORDEN SI ES URGENTE O NO
        public void procesarOrdenes() {
            // URGENTE
            while (!colaOrdenesUrgentes.isEmpty()) {
                Orden ordenUrgente = colaOrdenesUrgentes.poll();
                System.out.println("Procesando orden urgente de " + ordenUrgente.getNombreCliente() + " para " + ordenUrgente.getProductoSolicitado());
            }

            // ORDEN NORMAL
            while (!colaOrdenesRegulares.isEmpty()) {
                Orden ordenRegular = colaOrdenesRegulares.poll();
                System.out.println("Procesando orden regular de " + ordenRegular.getNombreCliente() + " para " + ordenRegular.getProductoSolicitado());
            }
        }

        // ALMACEN DE CAJAS 
        public void distribuirProductos() {
            for (Producto p : inventario) {
                if (p != null) {
                    almacen.push(p);  //PRODUCTOS A LA PILA
                }
            }
            System.out.println("Productos distribuidos en el almacén.");
        }

        // ESTADO DEL ALMACEN
        public void consultarAlmacen() {
            System.out.println("Contenido del almacén:");
            for (Producto p : almacen) {
                System.out.println(p.getNombre() + " - Cantidad: " + p.getCantidad());
            }
        }
        
}