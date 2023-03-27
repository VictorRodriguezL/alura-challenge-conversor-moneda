package challengeConversor;

import java.math.BigDecimal;

public class Moneda extends Medida {

	static final double USD_MXN = 18.39210;
	static final double EUR_MXN = 19.40662;
	static final double GBP_MXN = 21.95303;
	static final double JPY_MXN = 0.13476;
	static final double KRW_MXN = 0.01399;
	static final double MXN_USD = 0.05437;
	static final double MXN_EUR = 0.05153;
	static final double MXN_GBP = 0.04555;
	static final double MXN_JPY = 7.42111;
	static final double MXN_KRW = 71.35531;
	
	
	public Moneda(double importe, String divisa) {
		super(importe, divisa);
	}
	
	@Override
	public String toString() {
		return this.tipoAsimbolo() + " " + this.getValor();
	}

	@Override
	public Moneda multiplica(double cantidad) {
		BigDecimal nuevo = new BigDecimal(cantidad);
		return new Moneda(this.getValor().multiply(nuevo).doubleValue(), this.getTipo());
	}

	@Override
	public Medida convertir(String convertirA) {
		Moneda resultado = new Moneda(0.0, "Pesos mexicanos");
		switch (convertirA) {
			case "De Dólares a Pesos mexicanos":
				this.setTipo("Dólares");
				resultado = this.multiplica(USD_MXN);
				resultado.setTipo("Pesos mexicanos");
				break;
			case "De Euros a Pesos mexicanos":
				this.setTipo("Euros");
				resultado = this.multiplica(EUR_MXN);
				resultado.setTipo("Pesos mexicanos");
				break;
			case "De Libras esterlinas a Pesos mexicanos":
				this.setTipo("Libras esterlinas");
				resultado = this.multiplica(GBP_MXN);
				resultado.setTipo("Pesos mexicanos");
				break;
			case "De Yen japonés a Pesos mexicanos":
				this.setTipo("Yen japonés");
				resultado = this.multiplica(JPY_MXN);
				resultado.setTipo("Pesos mexicanos");
				break;
			case "De Won sur-coreano a Pesos mexicanos":
				this.setTipo("Won sur-coreano");
				resultado = this.multiplica(KRW_MXN);
				resultado.setTipo("Pesos mexicanos");
				break;
			case "De Pesos mexicanos a Dólares":
				this.setTipo("Pesos mexicanos");
				resultado = this.multiplica(MXN_USD);
				resultado.setTipo("Dólares");
				break;
			case "De Pesos mexicanos a Euros":
				this.setTipo("Pesos mexicanos");
				resultado = this.multiplica(MXN_EUR);
				resultado.setTipo("Euros");
				break;
			case "De Pesos mexicanos a Libras esterlinas":
				this.setTipo("Pesos mexicanos");
				resultado = this.multiplica(MXN_GBP);
				resultado.setTipo("Libras esterlinas");
				break;
			case "De Pesos mexicanos a Yen japonés":
				this.setTipo("Pesos mexicanos");
				resultado = this.multiplica(MXN_JPY);
				resultado.setTipo("Yen japonés");
				break;
			case "De Pesos mexicanos a Won sur-coreano":
				this.setTipo("Pesos mexicanos");
				resultado = this.multiplica(MXN_KRW);
				resultado.setTipo("Won sur-coreano");
				break;
		}
		return resultado;
	}
	
	@Override
	public String tipoAsimbolo() {
		String simbolo = "$";
		switch (this.getTipo()) {
			case "Dólares":
				simbolo = "US$";
				break;
			case "Euros":
				simbolo = "€";
				break;
			case "Libras esterlinas":
				simbolo = "£";
				break;
			case "Yen japonés":
				simbolo = "¥";
				break;
			case "Won sur-coreano":
				simbolo = "₩";
				break;
		}
		return simbolo;
	}
}
