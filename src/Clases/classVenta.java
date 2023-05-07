package Clases;


/**
 * Venta va representar declaracion de sus atributos, constructor que va inicializar los atributos de la clase y 
 * los metodos de asignacion y obtencion
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class classVenta {
	
	private int codigoVenta, codigoCli, codigoVend;
	private String tipoPago, fecha;
	
	public classVenta(int codigoVenta, int codigoCli, int codigoVend, String tipoPago, String fecha) {
		this.codigoVenta = codigoVenta;
		this.codigoCli = codigoCli;
		this.codigoVend = codigoVend;
		this.tipoPago = tipoPago;
		this.fecha = fecha;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoCli() {
		return codigoCli;
	}

	public void setCodigoCli(int codigoCli) {
		this.codigoCli = codigoCli;
	}

	public int getCodigoVend() {
		return codigoVend;
	}

	public void setCodigoVend(int codigoVend) {
		this.codigoVend = codigoVend;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
	

}
