package pos.domain;

public class VotoImpl implements Voto {
	private Integer idVoto, usuario, aplicacion;
	private Boolean valor;
	
	
	public Integer getIDVoto(){
		return idVoto;
	}
	
	public void setIDVoto(Integer idVoto){
		this.idVoto = idVoto;
	}
	
	@Override
	public Integer getUsuario() {
		return usuario;
	}

	@Override
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	@Override
	public Integer getAplicacion() {
		return aplicacion;
	}

	@Override
	public void setAplicacion(Integer aplicacion) {
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
