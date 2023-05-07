/**
 * Clase cliente
 */
package Clases;

/**
 * Cliente va representar declaracion  des sus variables, constructor que va inicializar 
 * los atributos y los metodos de obtencion y asignacion de los atributos
 * @author Bryan, Percy, Pilar, Brady y Jhon
 *
 */
public class classCliente {
	private int codigo;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String telefono;
	private String correo;
	

	public classCliente(int codigo, String nombre, String apellido, String tipoDocumento, String telefono,
			String correo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.telefono = telefono;
		this.correo = correo;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int  codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
