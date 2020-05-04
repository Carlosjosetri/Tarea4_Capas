package com.uca.Tarea4.domain;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Producto {
	
	@Size(min = 12, max = 12, message = "El codigo debe ser de 12 digitos")
	String codigo;
	
	@Size(min = 1, max = 100, message = "No puede dejar en blanco el nombre del producto")
	String nombre;
	
	@Size(min = 1, max = 100, message = "No puede dejar en blanco el nombre de la marca")
	String marca;
	
	@Size(min = 1, max = 500, message = "No puede dejar en blanco la descripcion del producto")
	String descripcion;
	
	@NotNull(message = "Debe ingresar una cantidad entera de existencias (puede ser 0)")
	Integer existencias;
	
	@Pattern(regexp = "^(((0[1-9]|[12][0-9]|3[01])[- /.](0[13578]|1[02])|(0[1-9]|[12][0-9]|30)[- /.](0[469]|11)|(0[1-9]|1\\d|2[0-8])[- /.]02)[- /.]\\d{4}|29[- /.]02[- /.](\\d{2}(0[48]|[2468][048]|[13579][26])|([02468][048]|[1359][26])00))$", message = "La fecha debe ser ingresada de esta manera: dd/mm/yyyy")
	String FIngreso;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public String getFIngreso() {
		return FIngreso;
	}

	public void setFIngreso(String fIngreso) {
		FIngreso = fIngreso;
	}

	
	
}
