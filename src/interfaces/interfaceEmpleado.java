package interfaces;


import javax.swing.table.DefaultTableModel;

import Clases.classEmpleado;

public interface interfaceEmpleado {
	
	public int registroDeEmpleado(classEmpleado e);
	public void listarEmpleado(DefaultTableModel miModelo, String[] datos, String consulta);
	
	public int eliminarEmpleado(classEmpleado e);
}
