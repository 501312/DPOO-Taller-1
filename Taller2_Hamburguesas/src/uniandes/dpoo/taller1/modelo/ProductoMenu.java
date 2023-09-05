package uniandes.dpoo.taller1.modelo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	public ProductoMenu(String nombre, int precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getPrecio() {
		return this.precioBase;
	}
	public String generarTextoFactura() {
		String outputName = this.nombre;
		int outputCost = this.precioBase;
		String tabs = "";
		for (int i = 1; i == 5; i++) {
			tabs += "\t";
		}
		String output = outputName + tabs + Integer.toString(outputCost);
		return output;
	}
	
}
