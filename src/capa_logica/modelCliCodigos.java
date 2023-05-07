package capa_logica;

import javax.swing.table.DefaultTableModel;

import cap_datos.MySQL;

import java.sql.*;

import interfaces.interfaceCliCodigos;

/**
 * Model cliente codigos va presentar la creacion de una clase y  un  metodo que va listar codigos del ciente en una tabla
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelCliCodigos implements interfaceCliCodigos {
	
	public static String sql="";

	@Override
	public void listarCodigoCliente(DefaultTableModel miModelo, String[] datos, String consulta) {
		
		Connection conex= null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			miModelo.setRowCount(0);
			conex = MySQL.conexion();
			stm = conex.createStatement();
			rs = stm.executeQuery(consulta);
			
			while(rs.next()) {
				datos[0] = rs.getString("cCodigo");
				datos[1] = rs.getString("cNombre");
				
				miModelo.addRow(datos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conex.close();
				stm.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		
	}

}
