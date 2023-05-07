package capa_logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import cap_datos.MySQL;
import interfaces.interfaceCodVenta;

/**
 * Model cliente codigos va presentar la creacion de una clase y  un  metodo que va listar codigos de  la venta en una tabla
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelCodVenta implements interfaceCodVenta{
	
	public static String sql = "";

	@Override
	public void listarCodigosVenta(DefaultTableModel miModelo, String[] datos, String consulta) {
		// TODO Auto-generated method stub
		
		 Connection conex = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 
		 try {
			conex = MySQL.conexion();
			stm = conex.createStatement();
			rs = stm.executeQuery(consulta);
			
			while(rs.next()) {
				datos[0] = rs.getString("vCodigo");
				
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
