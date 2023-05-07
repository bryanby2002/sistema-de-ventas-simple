package capa_logica;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import Clases.classVenta;
import cap_datos.MySQL;
import interfaces.interfaceVenta;

/**
 * Model venta  va presentar la creacion de una clase y metodos  que va registrar, eliminar y listar la venta
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelVenta implements interfaceVenta {
	
	public static  String sql = "";

	@Override
	public int registrarVenta(classVenta v) {
		int salida = -1;
		
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "insert into venta values(?,?,?,?,?)";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, v.getCodigoVenta());
			pstm.setInt(2, v.getCodigoCli());
			pstm.setInt(3, v.getCodigoVend()); 
			pstm.setString(4, v.getFecha());
			pstm.setNString(5, v.getTipoPago());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conex.close();
				pstm.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public int eliminarVenta(classVenta v) {
		int salida = -1;
		
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "delete from venta where vCodigo = ?";
			pstm = conex.prepareCall(sql);
			
			pstm.setInt(1, v.getCodigoVenta());
			
			salida = pstm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conex.close();
				pstm.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public void listarVenta(DefaultTableModel miModelo, String[] datos, String consulta) {
		
		Connection conex = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			miModelo.setRowCount(0);
			
			conex = MySQL.conexion();
			stm = conex.createStatement();
			rs = stm.executeQuery(consulta);
			
			while(rs.next()) {
				
				datos[0] = rs.getString("vCodigo");
				datos[1] = rs.getString("cCodigo");
				datos[2] = rs.getString("eCodigo");
				datos[3] = rs.getString("vFecha");
				datos[4] = rs.getString("vTipoPago");

				
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
