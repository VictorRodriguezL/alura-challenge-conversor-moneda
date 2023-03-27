package challengeConversor;

import javax.swing.*;

public class Conversor {

	public static void main(String[] args) {
		boolean repetir = true;
		do {
			String opcion = mostrarMenu();
			switch (opcion) {
				case "Conversor de Moneda":
					Moneda importe = new Moneda(0.0, "");
					double cantidad = pedirCantidad();
					if (cantidad == -1) {
						repetir = true;
						break;
					}
					importe.setValor(cantidad, 2);
					mostrarResultado(importe.convertir(opcionConvertir("Moneda")).toString(), "Moneda");
					repetir = false;
					break;
				case "Conversor de Temperatura":
					Temperatura temp = new Temperatura(0.0, "");
					double medida = pedirCantidad();
					if (medida == -1) {
						repetir = true;
						break;
					}
					temp.setValor(medida, 2);
					mostrarResultado(temp.convertir(opcionConvertir("Temperatura")).toString(), "Temperatura");
					repetir = false;
					break;
				case "Conversor de Peso":
					Peso peso = new Peso(0.0, "");
					double cant = pedirCantidad();
					if (cant == -1) {
						repetir = true;
						break;
					}
					peso.setValor(cant, 2);
					mostrarResultado(peso.convertir(opcionConvertir("Peso")).toString(), "Peso");
					repetir = false;
					break;
				case "Conversor de Longitud":
					Longitud longitud = new Longitud(0.0, "");
					double distancia = pedirCantidad();
					if (distancia == -1) {
						repetir = true;
						break;
					}
					longitud.setValor(distancia, 2);
					mostrarResultado(longitud.convertir(opcionConvertir("Longitud")).toString(), "Longitud");
					repetir = false;
					break;
			}
			repetir = deseaContinuar();
		} while (repetir);
	}
	public static String mostrarMenu() {
		String[] opciones = {"Conversor de Moneda", "Conversor de Temperatura", "Conversor de Peso", "Conversor de Longitud"};
		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione una opción de conversión:", "Conversor - Menú", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (seleccion == null) {
			return "Salir";
		}
		return seleccion.toString();
	}
	public static double pedirCantidad() {
		Object verificar;
		boolean repetir;
		do {
			repetir = false;
			verificar = JOptionPane.showInputDialog("Ingrese la cantidad que deseas convertir:");
			if (verificar == null) {
				return -1;
			}
			if (verificar.toString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No ingresó la cantidad", "Conversor - Error", JOptionPane.ERROR_MESSAGE);
				repetir = true;
			}
		} while (repetir);
		return Double.parseDouble(verificar.toString());
	}
	public static String opcionConvertir(String tipo) {
		String[] opciones = {"De Pesos mexicanos a Dólares", "De Pesos mexicanos a Euros", "De Pesos mexicanos a Libras esterlinas", "De Pesos mexicanos a Yen japonés", "De Pesos mexicanos a Won sur-coreano",
				"De Dólares a Pesos Mexicanos", "De Euros a Pesos mexicanos", "De Libras esterlinas a Pesos mexicanos", "De Yen japonés a Pesos mexicanos", "De Won sur-coreano a Pesos mexicanos"};;
		switch (tipo) {
			case "Temperatura":
				opciones = new String[] {"De Grados Celsius a Grados Fahrenheit", "De Grados Celsius a Grados Kelvin", "De Grados Celsius a Grados Rankine",
						"De Grados Fahrenheit a Grados Celsius", "De Grados Kelvin a Grados Celsius", "De Grados Rankine a Grados Celsius"};
				break;
			case "Peso":
				opciones = new String[] {"De Kilogramos a Gramos", "De Kilogramos a Libras", "De Kilogramos a Onzas",
						"De Gramos a Kilogramos", "De Libras a Kilogramos", "De Onzas a Kilogramos"};
				break;
			case "Longitud":
				opciones = new String[] {"De Kilometros a Metros", "De Kilometros a Centímetros", "De Kilometros a Yardas", "De Kilometros a Pies", "De Kilometros a Pulgadas",
						"De Metros a Kilometros", "De Centímetros a Kilometros", "De Yardas a Kilometros", "De Pies a Kilometros", "De Pulgadas a Kilometros"};
				break;
		}
		Object seleccion = JOptionPane.showInputDialog(null, "Elija la " + tipo + " a la que deseas convertir tu cantidad:", "Conversor de " + tipo, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (seleccion == null) {
			pedirCantidad();
			return opcionConvertir(tipo);
		}
		return seleccion.toString();
	}
	public static void mostrarResultado(String cantidad, String tipo) {
		JOptionPane.showMessageDialog(null, "Tienes " + cantidad, "Conversor de "+ tipo, JOptionPane.INFORMATION_MESSAGE);
	}
	public static boolean deseaContinuar() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea Continuar") == 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Programa Terminado");
		return false;
	}
}
