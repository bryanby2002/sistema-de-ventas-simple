package capa_logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import cap_datos.MySQL;
import interfaces.interfaceListarDetalle;

public class modelListarDetalleVenta implements interfaceListarDetalle {
	public static String sql = "";

	@Override
	public void listarDetalleVenta(DefaultTableModel miModelo, String[] datos, String consulta) {
		// TODO Auto-generated method stub
		
		Connection conex = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			miModelo.setRowCount(0);
			
			conex = MySQL.conexion();
			stm = conex.createStatement();
			rs = stm.executeQuery(consulta);
			
			while(rs.next()) {
				
				datos[0] = rs.getString("pDescripcion");
				datos[1] = rs.getString("dvCantidad");
				datos[2] = rs.getString("dvPrecio");

				
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
