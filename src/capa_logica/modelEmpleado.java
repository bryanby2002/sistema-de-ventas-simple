package capa_logica;

import javax.swing.table.DefaultTableModel;

import Clases.classEmpleado;

import java.sql.*;

import cap_datos.MySQL;
import interfaces.interfaceEmpleado;

/**
 * Model empleado  va presentar la creacion de una clase y metodos  que va registra, actualizar,eliminar y listar empleados
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelEmpleado implements interfaceEmpleado{
	
	public static String  sql = "";

	@Override
	public int registroDeEmpleado(classEmpleado e) {
		int salida = -1;
		Connection conex = null;
		PreparedStatement pstm = null;
		try {
			conex = MySQL.conexion();
			sql = "insert into empleado values(?,?,?,?,?)";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, e.getCodigo());
			pstm.setString(2, e.getNombre());
			pstm.setString(3, e.getCargo());
			pstm.setString(4, e.getCorreo());
			pstm.setString(5, e.getContraseña());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			try {
				if(conex != null) conex.close();
				if(pstm != null) pstm.close();
			} catch (Exception e3) {
			}
		}
		return salida;
	}

	@Override
	public void listarEmpleado(DefaultTableModel miModelo, String[] datos, String consulta) {
		
		Connection conex = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			miModelo.setRowCount(0);
			
			conex = MySQL.conexion();
			stm = conex.createStatement();
			rs = stm.executeQuery(consulta);
			
			while(rs.next()) {
				datos[0] = rs.getString("eCodigo");
				datos[1] = rs.getString("eNombre");
				datos[2] = rs.getString("eCargo");
				datos[3] = rs.getString("eCorreo");
				
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

	@Override
	public int eliminarEmpleado(classEmpleado e) {
		int salida = -1;
		
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "delete from empleado where eCodigo = ?";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, e.getCodigo());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			try {
				conex.close();
				pstm.close();
			} catch (Exception e2) {}
		}
				
		return salida;
	}	

}
