package challengeConversor;

import java.math.BigDecimal;

public class Temperatura extends Medida {

	public Temperatura(double valor, String tipo) {
		super(valor, tipo);
	}
	
	public Temperatura sumar(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Temperatura(this.getValor().add(nuevo).doubleValue(), this.getTipo());
	}
	public Temperatura restar(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Temperatura(this.getValor().subtract(nuevo).doubleValue(), this.getTipo());
	}
	
	@Override
	public Temperatura multiplica(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Temperatura(this.getValor().multiply(nuevo).doubleValue(), this.getTipo());
	}

	@Override
	public Temperatura convertir(String convertirA) {
		Temperatura resultado = new Temperatura(0.0,"Grados Celsius");
		switch (convertirA) {
			case "De Grados Celsius a Grados Fahrenheit":
				this.setTipo("Grados Celsius");
				resultado = this.multiplica(1.8).sumar(32);
				resultado.setTipo("Grados Fahrenheit");
				break;
			case "De Grados Celsius a Grados Kelvin":
				this.setTipo("Grados Celsius");
				resultado = this.sumar(273.15);
				resultado.setTipo("Grados Kelvin");
				break;
			case "De Grados Celsius a Grados Rankine":
				this.setTipo("Grados Celsius");
				resultado = this.multiplica(1.8).sumar(491.67);
				resultado.setTipo("Grados Rankine");
				break;
			case "De Grados Fahrenheit a Grados Celsius":
				this.setTipo("Grados Fahrenheit");
				resultado = this.restar(32).multiplica(0.5555);
				resultado.setTipo("Grados Celsius");
				break;
			case "De Grados Kelvin a Grados Celsius":
				this.setTipo("Grados Kelvin");
				resultado = this.restar(273.15);
				resultado.setTipo("Grados Celsius");
				break;
			case "De Grados Rankine a Grados Celsius":
				this.setTipo("Grados Rankine");
				resultado = this.restar(491.67).multiplica(0.5555);
				resultado.setTipo("Grados Celsius");
				break;
		}
		return resultado;
	}

	@Override
	public String tipoAsimbolo() {
		String simbolo = "°C";
		switch (this.getTipo()) {
			case "Grados Fahrenheit":
				simbolo = "°F";
				break;
			case "Grados Kelvin":
				simbolo = "K";
				break;
			case "Grados Rankine":
				simbolo = "°R";
				break;
		}
		return simbolo;
	}

	@Override
	public String toString() {
		return this.getValor() + this.tipoAsimbolo();
	}
}
