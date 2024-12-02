package co.edu.ue.entity;

public class Producto {
	
	//DECLARAMOS LOS ATRIBUTOS REQUERIDOS EN EL TALLER
	String nombre;
    int cantidad;
    
    
    //CREAMOS UN METODO CONSTRUCTOR PARA INICIALIZAR 
    
	public Producto(String nombre, int cantidad) {
		
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	//METODOS GET AND SET 
	
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
	
	
	// HACEMOS EL OVERRIDE PARA PLASMAR TODOS LOS ATRIBUTOS
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [nombre=");
		builder.append(nombre);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append("]");
		return builder.toString();
	} 
}
