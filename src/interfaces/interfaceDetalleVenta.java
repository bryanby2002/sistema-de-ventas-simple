package interfaces;

import javax.swing.table.DefaultTableModel;

import Clases.classDetalle_venta;

public interface interfaceDetalleVenta {
	
	public int registrarDetalleVenta(classDetalle_venta dv);
	public int eliminarDetalleVenta(classDetalle_venta dv);
	public void listarDetalle(DefaultTableModel miModelo, String[] datos, String consulta);

}
