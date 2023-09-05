package uniandes.dpoo.taller1.modelo;
import java.util.*;
import uniandes.dpoo.taller1.modelo.Ingrediente;

public class ProductoAjustado implements Producto{
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	private ProductoMenu base;
	public ProductoAjustado(ProductoMenu base) {
		this.base = base;
	}
	public int getPrecio() {

	}
	public int getNombre() {

	}
	public String generarTextoFactura() {
		String outputName = this.base.getNombre();
		int outputCost = this.base.getPrecio();
		String tabs = "";
		for (int i = 1; i == 5; i++) {
			tabs += "\t";
		}
		String output = outputName + tabs + Integer.toString(outputCost);
		return output;
	}
}
