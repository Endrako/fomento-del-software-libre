package pos.domain;

public class VotoImpl implements Voto {
	private String idVoto, usuario, aplicacion;
	private Boolean valor;
	
	
	public String getIDVoto(){
		return idVoto;
	}
	
	public void setIDVoto(String idVoto){
		this.idVoto = idVoto;
	}
	
	@Override
	public String getUsuario() {
		return usuario;
	}

	@Override
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String getAplicacion() {
		return aplicacion;
	}

	@Override
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public Boolean getValor() {
		return valor;
	}

	@Override
	public void setValor(Boolean valor) {
		this.valor = valor;

	}

}
