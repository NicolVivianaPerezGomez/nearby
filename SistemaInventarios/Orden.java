public class Orden {
    
    //DECLARAMOS LOS ATRIBUTOS QUE VAMOS A UTILIZAR EN ESTA CLASE ORDEN
    private String nombreCliente;
    private String producSolicitado;
    private int CantidadSolicitada;
    private boolean Urgente;

    //INICIALIZAMOS CON UN CONSTRUCTOR

    public Orden(int CantidadSolicitada, boolean Urgente, String nombreCliente, String producSolicitado) {
        this.CantidadSolicitada = CantidadSolicitada;
        this.Urgente = Urgente;
        this.nombreCliente = nombreCliente;
        this.producSolicitado = producSolicitado;
    }

    //METODO GET AND SET

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getProducSolicitado() {
        return producSolicitado;
    }

    public void setProducSolicitado(String producSolicitado) {
        this.producSolicitado = producSolicitado;
    }

    public int getCantidadSolicitada() {
        return CantidadSolicitada;
    }

    public void setCantidadSolicitada(int CantidadSolicitada) {
        this.CantidadSolicitada = CantidadSolicitada;
    }

    public boolean isUrgente() {
        return Urgente;
    }

    public void setUrgente(boolean Urgente) {
        this.Urgente = Urgente;
    }

    //UTILIZAMOS UN TOSTRING

    @Override
    public String toString() {
        return "Orden [nombreCliente=" + nombreCliente + ", producSolicitado=" + producSolicitado
                + ", CantidadSolicitada=" + CantidadSolicitada + ", Urgente=" + Urgente + "]";
    }


}


