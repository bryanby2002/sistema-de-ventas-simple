package capa_logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import cap_datos.MySQL;
import interfaces.interfaceProdCodigos;

/**
 * Model producto codigos va presentar la creacion de una clase y  un  metodo que va listar codigos del producto en una tabla
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelProdCodigos implements interfaceProdCodigos {
	
	public static String sql = "";

	@Override
	public void listarCodigosProd(DefaultTableModel miModelo, String[] datos, String consulta) {
		
		Connection conex = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			miModelo.setRowCount(0);
			
			conex = MySQL.conexion();
			stm = conex.createStatement();
			rs = stm.executeQuery(consulta);
			
			while(rs.next()) {
				datos[0] = rs.getString("pCodigo");
				datos[1] = rs.getString("pDescripcion");
				
				miModelo.addRow(datos);
			}
		} catch (Exception e) {
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
