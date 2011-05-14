package pos.domain;

import java.util.Date;

public class EnfrentamientoImpl implements Enfrentamiento {

	private Aplicacion aplicacion1, aplicacion2;
	private String descripcion;
	private Date fechaCreacion, fechaFin;
	private Integer votosAplicacion1, votosAplicacion2 = 0;
	private String IDEnfrentamiento = "";

	public EnfrentamientoImpl() {

	}
	
	public EnfrentamientoImpl(String IDEnfrentamiento,Aplicacion apli1,Aplicacion apli2,String descripcion,Date fechaCreacion,Date fechaFin, Integer votosApp1, Integer votosApp2){
		this.IDEnfrentamiento = IDEnfrentamiento;
		this.aplicacion1 = apli1;
		this.aplicacion2 = apli2;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.votosAplicacion1 = votosApp1;
		this.votosAplicacion2 = votosApp2;
	}

	public String getIDEnfrentamiento() {
		return IDEnfrentamiento;
	}

	public void setIDEnfrentamiento(String IDEnfrentamiento) {
		this.IDEnfrentamiento = IDEnfrentamiento;
	}

	public Aplicacion getAplicacion1() {
		return aplicacion1;
	}

	public void setAplicacion1(Aplicacion aplicacion1) {
		this.aplicacion1 = aplicacion1;
	}

	public Aplicacion getAplicacion2() {
		return aplicacion2;
	}

	public void setAplicacion2(Aplicacion aplicacion2) {
		this.aplicacion2 = aplicacion2;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getVotosAplicacion1() {
		return votosAplicacion1;
	}

	public Integer getVotosAplicacion2() {
		return votosAplicacion2;
	}

	public void anadirVotoAplicacion1(Integer votos) {
		votosAplicacion1 = votosAplicacion1 + votos;
		;
	}

	public void anadirVotoAplicacion2(Integer votos) {
		votosAplicacion2 = votosAplicacion2 + votos;
	}

	public void setVotosAplicacion1(Integer votos) {
		this.votosAplicacion1 = votos;
	}

	public void setVotosAplicacion2(Integer votos) {
		this.votosAplicacion2 = votos;
	}

	// Dos enfrentamientos son iguales si
	// *Aplicacion1 y 2 en ese orden son iguales ó
	// *Aplicacion1=nuevaAplicacion2 y Aplicacion2=nuevaAplicacion1
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Enfrentamiento) {
			Enfrentamiento e = (Enfrentamiento) o;
			// boolean
			// igualID=this.getIDEnfrentamiento().equals(e.getIDEnfrentamiento());
			boolean igualAplicacion1 = this.getAplicacion1().equals(
					e.getAplicacion1());
			boolean igualAplicacion2 = this.getAplicacion2().equals(
					e.getAplicacion2());
			boolean aplicacion1IgualAplicacion2 = this.getAplicacion1().equals(
					e.getAplicacion2());
			boolean aplicacion2IgualAplicacion1 = this.getAplicacion2().equals(
					e.getAplicacion1());
			if (!(igualAplicacion1 && igualAplicacion2)
					|| !(aplicacion1IgualAplicacion2 && aplicacion2IgualAplicacion1)) {
				res = true;
			}

		}
		return res;
	}

	public String toString() {
		String s;
		s = aplicacion1.getNombre() + " vs " + aplicacion2.getNombre();
		s = s + "\n" + descripcion;
		return s;
	}

}
