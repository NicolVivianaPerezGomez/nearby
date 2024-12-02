package co.edu.ue.entity;

import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //CREAMOS EL SISTEMA DE INVENTARIO
        SistemaInventario sistema = new SistemaInventario(6);
        sistema.inicializarInventario();

        System.out.println("\n BIENVENIDO A TECNO-ARTE:");
        while (true) {
        	System.out.println("\n ACCESO AL MENU INTERACTIVO:");
            System.out.println("1. Consulta ");
            System.out.println("2. actualiza tu inventario ");
            System.out.println("3. Agrega una orden");
            System.out.println("4. Elimina una orden");
            System.out.println("5. Modifica una orden");
            System.out.println("6. Procesa una orden");
            System.out.println("7. Consulta el almacén");
            System.out.println("8. Distribuye los productos en el almacén");
            System.out.println("9. Salir al menú");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
          //MOSTRAMOS EL INVENTARIO
                case 1:
                	 System.out.println("INVENTARIO ACTUAL:");
                    sistema.consultarInventario();
                    break;
                    
         //ACTUALIZAR EL INVENTARIO           
                case 2:
                	
                        System.out.println("Ingrese el nombre del producto a actualizar:");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese la Nueva cantidad :");
                        int nuevaCantidad = scanner.nextInt();
                        scanner.nextLine();
                        break;
                   
         // HACEMOS QUE EL USUARIO CREE UNA ORDEN 
                case 3:
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Producto solicitado: ");
                    String productoSolicitado = scanner.nextLine();
                    System.out.print("Cantidad solicitada: ");
                    int cantidadSolicitada = scanner.nextInt();
                    System.out.print("¿Es urgente? (true/false): ");
                    boolean esUrgente = scanner.nextBoolean();
                    scanner.nextLine();
                    Orden nuevaOrden = new Orden(nombreCliente, productoSolicitado, cantidadSolicitada, esUrgente);
                    sistema.agregarOrden(nuevaOrden);
                    break;
         // HACEMOS QUE EL USUARIO ELIMINE UNA ORDEN      
                case 4:
                    System.out.print("Nombre del cliente de la orden a eliminar: ");
                    String clienteEliminar = scanner.nextLine();
                    sistema.ordenes.removeIf(orden -> orden.getNombreCliente().equals(clienteEliminar));
                    System.out.println("Orden eliminada.");
                    break;
                case 5:
       // HACEMOS QUE EL USUARIO MODIFIQUE LA ORDEN SOLICITADA
                    System.out.print("Nombre del cliente de la orden a modificar: ");
                    String clienteModificar = scanner.nextLine();
                    Orden ordenModificar = sistema.ordenes.stream().filter(o -> o.getNombreCliente().equals(clienteModificar)).findFirst().orElse(null);
                    if (ordenModificar != null) {
                        System.out.print("Nuevo producto solicitado: ");
                        String nuevoProducto = scanner.nextLine();
                        System.out.print("Nueva cantidad solicitada: ");
                        int nuevaCantidad1 = scanner.nextInt();
                        scanner.nextLine();
                        sistema.modificarOrden(ordenModificar, nuevoProducto, nuevaCantidad1);
                    }
                    break;
        
        //PROCESAMOS LA ORDEN             
                case 6:
                    sistema.procesarOrdenes();
                    break;
                    
       //CONSULTAMOS ALMACEN CAJAS             
                case 7:
                    sistema.consultarAlmacen();
                    break;
                    
      //CONSULTAMOS DISTRIBUIR CAJAS               
                case 8:
                    sistema.distribuirProductos();
                    break;
     //SALIMOS DEL MENU                
                case 9:
                    System.out.println("GRACIAS POR INGRESAR TE ESPERAMOS PRONTO");
                    return;
                default:
                    System.out.println("Esta opción NO es posible realizarla");
            }
        }
    }
}
