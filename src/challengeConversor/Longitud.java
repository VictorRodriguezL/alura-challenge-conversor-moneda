package challengeConversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Longitud extends Medida {

	public Longitud(double valor, String tipo) {
		super(valor, tipo);
	}

	public Longitud dividir(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Longitud(this.getValor().divide(nuevo, RoundingMode.CEILING).doubleValue(), this.getTipo());
	}

	@Override
	public Longitud multiplica(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Longitud(this.getValor().multiply(nuevo).doubleValue(), this.getTipo());
	}

	@Override
	public Longitud convertir(String convertirA) {
		Longitud resultado = new Longitud(0.0,"Kilometros");
		switch (convertirA) {
			case "De Kilometros a Metros":
				this.setTipo("Kilometros");
				resultado = this.multiplica(1000);
				resultado.setTipo("Metros");
				break;
			case "De Kilometros a Centímetros":
				this.setTipo("Kilometros");
				resultado = this.multiplica(100000);
				resultado.setTipo("Centímetros");
				break;
			case "De Kilometros a Yardas":
				this.setTipo("Kilometros");
				resultado = this.multiplica(1093.61);
				resultado.setTipo("Yardas");
				break;
			case "De Kilometros a Pies":
				this.setTipo("Kilometros");
				resultado = this.multiplica(3280.84);
				resultado.setTipo("Pies");
				break;
			case "De Kilometros a Pulgadas":
				this.setTipo("Kilometros");
				resultado = this.multiplica(39370.1);
				resultado.setTipo("Pulgadas");
				break;
			case "De Metros a Kilometros":
				this.setTipo("Metros");
				resultado = this.dividir(1000);
				resultado.setTipo("Kilometros");
				break;
			case "De Centímetros a Kilometros":
				this.setTipo("Centímetros");
				resultado = this.dividir(100000);
				resultado.setTipo("Kilometros");
				break;
			case "De Yardas a Kilometros":
				this.setTipo("Yardas");
				resultado = this.dividir(1093.61);
				resultado.setTipo("Kilometros");
				break;
			case "De Pies a Kilometros":
				this.setTipo("Pies");
				resultado = this.dividir(3280.84);
				resultado.setTipo("Kilometros");
				break;
			case "De Pulgadas a Kilometros":
				this.setTipo("Pulgadas");
				resultado = this.dividir(39370.1);
				resultado.setTipo("Kilometros");
				break;
		}
		return resultado;
	}

	@Override
	public String tipoAsimbolo() {
		String simbolo = "Km";
		switch (this.getTipo()) {
			case "Metros":
				simbolo = "m";
				break;
			case "Centímetros":
				simbolo = "cm";
				break;
			case "Yardas":
				simbolo = "yd";
				break;
			case "Pies":
				simbolo = "ft";
				break;
			case "Pulgadas":
				simbolo = "in";
				break;
		}
		return simbolo;
	}

	@Override
	public String toString() {
		return this.getValor() + " " + this.tipoAsimbolo();
	}
}
