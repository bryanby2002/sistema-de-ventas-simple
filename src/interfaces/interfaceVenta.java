package interfaces;

import javax.swing.table.DefaultTableModel;

import Clases.classVenta;

public interface interfaceVenta {
	
	public int registrarVenta(classVenta v);
	public int eliminarVenta(classVenta v);
	public void listarVenta(DefaultTableModel miModelo, String datos[], String consulta);

}
