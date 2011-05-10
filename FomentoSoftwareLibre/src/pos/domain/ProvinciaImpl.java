package pos.domain;

public class ProvinciaImpl implements Provincia {

	private int id;
	private String descripcion;
	
	public ProvinciaImpl(){
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
