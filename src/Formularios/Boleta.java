package Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import Menu.menu;
import cap_datos.MySQL;
import capa_logica.modelDetalleVenta;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Boleta va representar un formulario diseñado para generar la boleta de la venta un cliente
 * Para ello está implementado Jbutons
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class Boleta extends JInternalFrame {
	public static String bol;
	public static  JTextField txtCodigoVenta;
	private JButton btnGenerar;
	private JButton btnBuscar;
	private JTable table;
	private JLabel lblCliente;
	private JLabel lblVendedor;
	private JLabel lblTotal;
	private JLabel lblMensaje;
	
	DefaultTableModel miModelo;
	modelDetalleVenta mdD = new modelDetalleVenta();
	String datos[] = new String[5];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boleta frame = new Boleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Boleta() {
		setTitle("Generar boleta");
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				bol = null;
			}
		});
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 547, 433);
		getContentPane().setLayout(null);
		
		bol = "bol";
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 534, 403);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(0, 0, 194, 403);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Boleta.class.getResource("/Imagenes/factura.png")));
		lblNewLabel.setBounds(33, 114, 128, 137);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(191, 0, 341, 403);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GENERAR BOLETA");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 256, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo de venta");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 36, 117, 19);
		panel_2.add(lblNewLabel_2);
		
		txtCodigoVenta = new JTextField();
		txtCodigoVenta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarBoleta(txtCodigoVenta);
			}
		});
		txtCodigoVenta.setForeground(Color.DARK_GRAY);
		txtCodigoVenta.setFont(new Font("Roboto", Font.ITALIC, 10));
		txtCodigoVenta.setBackground(Color.WHITE);
		txtCodigoVenta.setBorder(null);
		txtCodigoVenta.setBounds(10, 56, 104, 26);
		panel_2.add(txtCodigoVenta);
		txtCodigoVenta.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 82, 104, 2);
		panel_2.add(separator);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBoleta(txtCodigoVenta);
				lblCliente.setText("Cliente:       "+cliente());
				lblVendedor.setText("Vendedor:  "+vendedor());
				lblTotal.setText("Total: "+total());
				lblMensaje.setText("GRACIAS POR SU COMPRA");
			}
		});
		btnGenerar.setForeground(Color.WHITE);
		btnGenerar.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 12));
		btnGenerar.setBackground(Color.DARK_GRAY);
		btnGenerar.setBorder(null);
		btnGenerar.setBounds(253, 48, 82, 36);
		panel_2.add(btnGenerar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cvt =  codigosVenta.codVenta;
				try {
					if(cvt == null) {
						codigosVenta cVenta = new codigosVenta();
						menu.escritorio.add(cVenta);
						cVenta.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "El formulario está en pantalla");
					}
				} catch (Exception e2) {
				}
			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 12));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.DARK_GRAY);
		btnBuscar.setBounds(176, 49, 68, 36);
		panel_2.add(btnBuscar);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 9));
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(false);
		table.setBounds(22, 212, 313, 102);
		panel_2.add(table);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 10));
		lblNewLabel_3.setBounds(22, 187, 30, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PRODUCTO");
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 10));
		lblNewLabel_4.setBounds(81, 187, 68, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FECHA");
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 10));
		lblNewLabel_5.setBounds(156, 187, 35, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CANTIDAD");
		lblNewLabel_6.setFont(new Font("Roboto", Font.BOLD, 10));
		lblNewLabel_6.setBounds(201, 187, 56, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PRECIO.U");
		lblNewLabel_7.setFont(new Font("Roboto", Font.BOLD, 10));
		lblNewLabel_7.setBounds(267, 187, 48, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PONTIFARMA");
		lblNewLabel_8.setFont(new Font("Roboto", Font.PLAIN, 19));
		lblNewLabel_8.setBounds(20, 95, 152, 28);
		panel_2.add(lblNewLabel_8);
		
		lblCliente = new JLabel("");
		lblCliente.setFont(new Font("Roboto", Font.PLAIN, 10));
		lblCliente.setBounds(22, 134, 172, 14);
		panel_2.add(lblCliente);
		
		lblVendedor = new JLabel("");
		lblVendedor.setFont(new Font("Roboto", Font.PLAIN, 10));
		lblVendedor.setBounds(22, 159, 172, 14);
		panel_2.add(lblVendedor);
		
		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Roboto", Font.BOLD, 10));
		lblTotal.setBounds(253, 325, 62, 14);
		panel_2.add(lblTotal);
		
		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblMensaje.setBounds(111, 366, 152, 26);
		panel_2.add(lblMensaje);
		
		crearEncabezados();
	}
	
	/**
	 * Metodo que crea el encabezado al DefaulTable model
	 */
	void crearEncabezados() {
		
		miModelo = new DefaultTableModel();
		
		miModelo.addColumn("id");
		miModelo.addColumn("producto");
		miModelo.addColumn("fecha");
		miModelo.addColumn("pago");
		miModelo.addColumn("cantidad");
		
		table.setModel(miModelo);
	}
	
	/**
	 * Metodo que muestra la boleta a traves de un consulta sql desde la base de datos
	 * @param busca
	 */
	void listarBoleta(JTextField busca) {
		try {
			mdD.sql = "select venta.vCodigo, pDescripcion,vFecha, dvCantidad, dvPrecio from venta inner join detalle_venta on detalle_venta.vCodigo = venta.vCodigo inner join producto on detalle_venta.pCodigo = producto.pCodigo where(detalle_venta.vCodigo like '"+busca.getText()+"%') order by detalle_venta.vCodigo";
			mdD.listarDetalle(miModelo, datos, mdD.sql);
		} catch (Exception e) {
		}
	}
	
	/**
	 * Va retornar el nombre del cliente que hizo  la venta 
	 * @return Nombre del cliente
	 */
	String cliente() {
		
		String cliente = "";
		int codigoV = Integer.parseInt(txtCodigoVenta.getText());
		Connection conex = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conex = MySQL.conexion();
			String sql = "select concat(cNombre,' ',cApellido)  from detalle_venta inner join venta on detalle_venta.vCodigo = venta.vCodigo inner join cliente on venta.cCodigo = cliente.cCodigo where detalle_venta.vCodigo = '"+codigoV+"'";
			stm = conex.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				cliente = rs.getString(1);
			}
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}finally {
			try {
				conex.close();
				stm.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return cliente;
	}
	
	/**
	 * Va retornar el nombre del vendedor que  realizó la venta
	 * @return Nombre del vendedor
	 */
	String vendedor() {
		
		String vendedor = "";
		int codigoV = Integer.parseInt(txtCodigoVenta.getText());
		Connection conex = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conex = MySQL.conexion();
			String sql = "select eNombre from detalle_venta inner join venta on detalle_venta.vCodigo = venta.vCodigo inner join empleado on venta.eCodigo = empleado.eCodigo where detalle_venta.vCodigo = '"+codigoV+"'";
			stm = conex.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				vendedor = rs.getString(1);
			}
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}finally {
			try {
				conex.close();
				stm.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return vendedor;
	}
	
	/**
	 * Va retornar el precio total de la venta
	 * @return Precio total
	 */
	double total() {
		
		double total = 0;
		int codigoV = Integer.parseInt(txtCodigoVenta.getText());
		Connection conex = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conex = MySQL.conexion();
			String sql = "select sum(dvPrecio_total) from detalle_venta where vCodigo = '"+codigoV+"'";
			stm = conex.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				total = rs.getDouble(1);
			}
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}finally {
			try {
				conex.close();
				stm.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
