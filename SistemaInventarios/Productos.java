public class Productos {
     //1. DECLARAMOS LOS ATRIBUTOS QUE VAN A IR EN ESTA CLASE Producto 
     String nombre;
     int cantidad;

     //2. INICIALIZAMOS CADA ATRIBUTO EN ESTE CASO SON DOS CUALIDADES CON UN CONSTRUCTOR

     public Productos(int cantidad, String nombre) {
         this.cantidad = cantidad;
         this.nombre = nombre;
     }

     //3. POR MEDIO DE LOS METODOS GET AND SET DAMOS CUERPO

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public int getCantidad() {
         return cantidad;
     }

     public void setCantidad(int cantidad) {
         this.cantidad = cantidad;
     }

     //4. POR ULTIMO UTILIZAMOS UN TOSTRING().

     @Override
     public String toString() {
         return "Productos [nombre=" + nombre + ", cantidad=" + cantidad + "]";
     }
}

