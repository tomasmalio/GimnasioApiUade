package models;

import persistence.EmpleadoAdminAbm;

public class Administrativo extends Empleado {
	private float sueldo;
	
	public Administrativo(String nombre, int documento, String mail, String telefono, String domicilio, String escalaSalarial, float sueldo) {
		super(nombre, documento, mail, telefono, domicilio, escalaSalarial);
		this.setSueldo(sueldo);
	}
	
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * getCalcularSueldo
	 * 
	 * @return float
	 */
	public float getCalcularSueldo () {
		return this.sueldo;
	}
	
	public void insert() {
		EmpleadoAdminAbm.getInstancia().insert(this);
	}
	public void eliminarEmpleado() {
		EmpleadoAdminAbm.getInstancia().delete(this);
	}
	public void actualizarEmpleado(String nombre, int documento, String mail, String telefono, String domicilio, String escalaSalarial, float valor) {
		EmpleadoAdminAbm.getInstancia().update(new Administrativo(nombre, documento, mail, telefono, domicilio, escalaSalarial, valor));
	}
	
}
