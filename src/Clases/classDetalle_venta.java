package Clases;

/**
 * Detalle venta va presentar la declaracion de sus atributos, constructor que va inicilizar los abributos y
 * los metodos de asignacion y obtencion.
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class classDetalle_venta {
	private int codDetalleVenta, codVenta, codProd, cantidad;
	private double precio, precioTotal;
	
	public classDetalle_venta(int codDetalleVenta, int codVenta, int codProd, int cantidad, double precio,
			double precioTotal) {
		this.codDetalleVenta = codDetalleVenta;
		this.codVenta = codVenta;
		this.codProd = codProd;
		this.cantidad = cantidad;
		this.precio = precio;
		this.precioTotal = precioTotal;
	}

	public int getCodDetalleVenta() {
		return codDetalleVenta;
	}

	public void setCodDetalleVenta(int codDetalleVenta) {
		this.codDetalleVenta = codDetalleVenta;
	}

	public int getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}

	public int getCodProd() {
		return codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	

	

}
