package pos.domain;

public class VotoImpl implements Voto {
	private Integer usuario, aplicacion;
	private Boolean valor;
	
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
