package pos.domain;

public class PaisImpl implements Pais {

	private int id;
	private String descripcion;
	
	public PaisImpl(){
		id = 0;
		descripcion = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
