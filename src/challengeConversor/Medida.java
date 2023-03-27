package challengeConversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Medida {

	private BigDecimal valor;
	private String tipo;
	
	public Medida(double valor, String tipo) {
		this.valor = new BigDecimal(valor).setScale(2, RoundingMode.DOWN);
		this.tipo = tipo;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(double valor, int decimales) {
		this.valor = new BigDecimal(valor).setScale(decimales, RoundingMode.UP);
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public abstract Medida multiplica(double cantidad);
	public abstract Medida convertir(String tipo);
	public abstract String tipoAsimbolo();
}
