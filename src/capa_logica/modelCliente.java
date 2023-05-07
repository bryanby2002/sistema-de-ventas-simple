package capa_logica;

import java.sql.PreparedStatement;

import javax.swing.table.DefaultTableModel;

import java.sql.*;
import Clases.classCliente;
import cap_datos.MySQL;
import interfaces.interfaceCliente;

/**
 * Model cliente  va presentar la creacion de una clase y  un  metodo que va registra, actualizar,eliminar y listar clientes
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelCliente implements interfaceCliente{
	
	public static String sql = "";

	@Override
	public int registrarCliente(classCliente c) {
		int salida = -1;
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "insert into cliente values(?,?,?,?,?,?)";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, c.getCodigo());
			pstm.setString(2, c.getNombre());
			pstm.setString(3, c.getApellido());
			pstm.setString(4, c.getTipoDocumento());
			pstm.setString(5, c.getTelefono());
			pstm.setString(6, c.getCorreo());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conex.close();
				pstm.close();
			} catch (Exception e2) {}
		}
		return salida;
	}

	@Override
	public int actualizarCliente(classCliente c) {
		int salida = -1;
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "update cliente set cNombre = ?, cApellido = ?, cTipoDocumento = ?, cTelefono = ?, cCorreo = ? where cCodigo = ?";
			pstm = conex.prepareStatement(sql);
			
			pstm.setString(1, c.getNombre());
			pstm.setString(2, c.getApellido());
			pstm.setString(3, c.getTipoDocumento());
			pstm.setString(4, c.getTelefono());
			pstm.setString(5, c.getCorreo());
			pstm.setInt(6, c.getCodigo());
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conex.close();
				pstm.close();
			} catch (Exception e2) {}
		}
		return salida;

	}

	@Override
	public int eliminarCliente(classCliente c) {
		int salida = -1;
		
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "delete from cliente where cCodigo = ?";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, c.getCodigo());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conex.close();
				pstm.close();
			} catch (Exception e2) {}
		}
				
		return salida;
	}

	@Override
	public void listarCliente(DefaultTableModel miModelo, String[] datos, String consulta) {
		
		Connection conex = null;
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
				datos[2] = rs.getString("cApellido");
				datos[3] = rs.getString("cTipoDocumento");
				datos[4] = rs.getString("cTelefono");
				datos[5] = rs.getString("cCorreo");
				
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
