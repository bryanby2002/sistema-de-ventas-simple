package capa_logica;

import javax.swing.table.DefaultTableModel;

import cap_datos.MySQL;

import java.sql.*;
import interfaces.interfaceVendCodigos;

/**
 * Model vendedor codigos va presentar la creacion de una clase y  un  metodo que va listar codigos del vendedor en una tabla
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelVendCodigos implements interfaceVendCodigos{
	
	public static String sql = "";
	@Override
	public void listarCodigoVendedor(DefaultTableModel miModelo, String[] datos, String consulta) {
		
		 Connection conex = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 
		 try {
			conex = MySQL.conexion();
			stm = conex.createStatement();
			rs = stm.executeQuery(consulta);
			
			while(rs.next()) {
				datos[0] = rs.getString("eCodigo");
				datos[1] = rs.getString("eNombre");
				
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
