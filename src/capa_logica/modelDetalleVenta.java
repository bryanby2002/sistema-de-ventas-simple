package capa_logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import Clases.classDetalle_venta;
import cap_datos.MySQL;
import interfaces.interfaceDetalleVenta;

/**
 * Model cliente codigos va presentar la creacion de una clase y  un  metodo que va registrar, eliminar y listar  el detalle de la venta
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class modelDetalleVenta implements interfaceDetalleVenta {
	public static String sql="";

	@Override
	public int registrarDetalleVenta(classDetalle_venta dv) {
		// TODO Auto-generated method stub
		
		int salida = -1;
		
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "insert into detalle_venta values(?,?,?,?,?,?)";
			pstm = conex.prepareStatement(sql);
			
			pstm.setInt(1, dv.getCodDetalleVenta());
			pstm.setInt(2, dv.getCodVenta());
			pstm.setInt(3, dv.getCodProd());
			pstm.setInt(4, dv.getCantidad());
			pstm.setDouble(5, dv.getPrecio());
			pstm.setDouble(6, dv.getPrecioTotal());
			
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
	public int eliminarDetalleVenta(classDetalle_venta dv) {
		// TODO Auto-generated method stub
		int salida = -1;
		
		Connection conex = null;
		PreparedStatement pstm = null;
		
		try {
			conex = MySQL.conexion();
			sql = "delete from detalle_venta where dvCodigo = ?";
			pstm = conex.prepareCall(sql);
			
			pstm.setInt(1, dv.getCodDetalleVenta());
			
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
	public void listarDetalle(DefaultTableModel miModelo, String[] datos, String consulta) {
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
				
				datos[0] = rs.getString("venta.vCodigo");
				datos[1] = rs.getString("pDescripcion");
				datos[2] = rs.getString("vFecha");
				datos[3] = rs.getString("dvCantidad");
				datos[4] = rs.getString("dvPrecio");

				
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
