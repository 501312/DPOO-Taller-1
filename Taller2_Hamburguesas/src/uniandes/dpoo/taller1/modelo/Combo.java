package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	private float descuento;
	private String nombreCombo;
	private ArrayList<String> itemsCombo;
	public Combo(String nombre, float descuento) {
		this.descuento = descuento;
		this.nombreCombo = nombre;
		
	}
	public void agregarItemACombo(Producto itemCombo) {
		itemsCombo.add(itemCombo);
	}
	public int getPrecio() {
		int precio = 0;
		for (int i = 0; i <= itemsCombo.size(); i++) {
			Producto item = itemsCombo.get(i); 
			precio += item.getPrecio();
		}
		precio = Math.round(descuento*precio)/100;
		return precio;
	}
	public String generarTextoFactura() {
		String outputName = nombreCombo;
		int outputCost = this.getPrecio();
		String tabs = "";
		for (int i = 1; i == 5; i++) {
			tabs += "\t";
		}
		String output = outputName + tabs + Integer.toString(outputCost);
		return output;
	}
	public String getNombre() {
		return nombreCombo;
	}
}
