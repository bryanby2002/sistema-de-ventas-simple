package Clases;

/**
 * Empleado va representar declaracion de sus atributos, constructor que va inicializar los atributos de la clase y 
 * los metodos de asignacion y obtencion
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class classEmpleado {
	private int codigo;
	private String nombre;
	private String cargo;
	private String correo;
	private String contraseña;
	
	public classEmpleado(int codigo, String nombre, String cargo, String correo, String contraseña) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cargo = cargo;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
