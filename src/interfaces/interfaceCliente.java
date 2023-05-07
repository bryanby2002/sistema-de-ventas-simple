package interfaces;

import javax.swing.table.DefaultTableModel;

import Clases.classCliente;

public interface interfaceCliente {
	
	public int registrarCliente(classCliente c);
	public int actualizarCliente(classCliente c);
	public int eliminarCliente(classCliente c);
	public void listarCliente(DefaultTableModel miModelo, String[] datos, String consulta);
}
