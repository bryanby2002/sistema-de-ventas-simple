package capa_logica;

import Clases.classProducto;
import cap_datos.MySQL;
import interfaces.interfaceProducto;
import java.sql.*;

import javax.swing.table.DefaultTableModel;


/**
 * Model empleado  va presentar la creacion de una clase y metodos  que va registrar, actualizar,eliminar y listar productos
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelProducto  implements interfaceProducto{
	
	public static String sql = "";

	@Override
	public int registrarProducto(classProducto p) {
		int salida = -1;
		Connection conex = null;
		PreparedStatement pstm = null;
		try {
			conex = MySQL.conexion();
			sql = "insert into producto values(?,?,?,?)";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, p.getCodigo());
			pstm.setString(2, p.getDescripcion());
			pstm.setDouble(3, p.getPrecio());
			pstm.setInt(4, p.getStock());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conex != null) conex.close();
				if(pstm != null) pstm.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public int actualizarProducto(classProducto p) {
		int salida = -1;
		Connection conex = null;
		PreparedStatement pstm = null;
		try {
			conex = MySQL.conexion();
			sql = "update producto set pDescripcion = ?, pPrecio = ?, pStock = ? where pCodigo = ?";
			pstm = conex.prepareStatement(sql);
			
			pstm.setString(1, p.getDescripcion());
			pstm.setDouble(2, p.getPrecio());
			pstm.setInt(3, p.getStock());
			pstm.setInt(4, p.getCodigo());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conex != null) conex.close();
				if(pstm != null) pstm.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public int elimninarProducto(classProducto p) {
		int salida = -1;
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "delete from producto where pCodigo = ?";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, p.getCodigo());
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conex != null) conex.close();
				if(pstm != null) pstm.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public void listarProducto(DefaultTableModel miModelo, String[] datos, String consulta) {
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
				datos[2] = rs.getString("pPrecio");
				datos[3] = rs.getString("pStock");
				
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
