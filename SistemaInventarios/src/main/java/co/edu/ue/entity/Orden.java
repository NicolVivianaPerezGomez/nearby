package co.edu.ue.entity;

public class Orden {
	
	//DECLARAMOS LOS ATRIBUTOS DE CLASE ORDEN
	
	private  String nombreCliente;
    public String productoSolicitado;
    public int cantidadSolicitada;
    private boolean esUrgente;
    
    //HACEMOS UN CONSTRUCTOR PARA INICIALIZAR LOSA TRIBUTOS
    
	public Orden(String nombreCliente, String productoSolicitado, int cantidadSolicitada, boolean esUrgente) {
		super();
		this.nombreCliente = nombreCliente;
		this.productoSolicitado = productoSolicitado;
		this.cantidadSolicitada = cantidadSolicitada;
		this.esUrgente = esUrgente;
	}
	
	
	//CREAMOS EL METODO GET AND SET 
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getProductoSolicitado() {
		return productoSolicitado;
	}
	public void setProductoSolicitado(String productoSolicitado) {
		this.productoSolicitado = productoSolicitado;
	}
	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public boolean isEsUrgente() {
		return esUrgente;
	}
	public void setEsUrgente(boolean esUrgente) {
		this.esUrgente = esUrgente;
	}
	
	
	// EL OVERRIDE ME PERMITE PLASMAR LOS ATRIBUTOS MENCIONADOS
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orden [nombreCliente=");
		builder.append(nombreCliente);
		builder.append(", productoSolicitado=");
		builder.append(productoSolicitado);
		builder.append(", cantidadSolicitada=");
		builder.append(cantidadSolicitada);
		builder.append(", esUrgente=");
		builder.append(esUrgente);
		builder.append("]");
		return builder.toString();
	}

}
