package interfaces;

import javax.swing.table.DefaultTableModel;

import Clases.classProducto;

public interface interfaceProducto {
	
	public int registrarProducto(classProducto p);
	public int actualizarProducto(classProducto p);
	public int elimninarProducto(classProducto p);
	public void listarProducto(DefaultTableModel miModelo, String[] datos, String consulta);

}
