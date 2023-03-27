package challengeConversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Peso extends Medida {

	public Peso(double valor, String tipo) {
		super(valor, tipo);
	}

	public Peso dividir(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Peso(this.getValor().divide(nuevo, RoundingMode.CEILING).doubleValue(), this.getTipo());
	}
	
	@Override
	public Peso multiplica(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Peso(this.getValor().multiply(nuevo).doubleValue(), this.getTipo());
	}

	@Override
	public Peso convertir(String convertirA) {
		Peso resultado = new Peso(0.0,"Kilogramos");
		switch (convertirA) {
			case "De Kilogramos a Gramos":
				this.setTipo("Kilogramos");
				resultado = this.multiplica(1000);
				resultado.setTipo("Gramos");
				break;
			case "De Kilogramos a Libras":
				this.setTipo("Kilogramos");
				resultado = this.multiplica(2.2046);
				resultado.setTipo("Libras");
				break;
			case "De Kilogramos a Onzas":
				this.setTipo("Kilogramos");
				resultado = this.multiplica(35.2739);
				resultado.setTipo("Onzas");
				break;
			case "De Gramos a Kilogramos":
				this.setTipo("Gramos");
				resultado = this.dividir(1000);
				resultado.setTipo("Kilogramos");
				break;
			case "De Libras a Kilogramos":
				this.setTipo("Libras");
				resultado = this.dividir(2.2046);
				resultado.setTipo("Kilogramos");
				break;
			case "De Onzas a Kilogramos":
				this.setTipo("Onzas");
				resultado = this.dividir(35.2739);
				resultado.setTipo("Kilogramos");
				break;
		}
		return resultado;
	}

	@Override
	public String tipoAsimbolo() {
		String simbolo = "Kg";
		switch (this.getTipo()) {
			case "Gramos":
				simbolo = "g";
				break;
			case "Libras":
				simbolo = "lb";
				break;
			case "Onzas":
				simbolo = "oz";
				break;
		}
		return simbolo;
	}

	@Override
	public String toString() {
		return this.getValor() + " " + this.tipoAsimbolo();
	}
}
