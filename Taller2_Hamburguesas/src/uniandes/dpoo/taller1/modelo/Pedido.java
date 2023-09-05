package uniandes.dpoo.taller1.modelo;

import java.util.*;
import java.lang.Math;

public class Pedido {
	
	private static int numeroPedidos = 0;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> listaProductos;
	
	public Pedido(String nombreCliente, String direccionCliente) {
		numeroPedidos += 1;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.idPedido = numeroPedidos;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void agregarProducto(Producto nuevoItem) {
		listaProductos.add(nuevoItem);
	}
	private int getPrecioNetoPedido() {
		int precioNeto = 0;
		for (int i = 0; i <= listaProductos.size(); i++) {
			Producto item = listaProductos.get(i);
			precioNeto += item.getPrecio();
		}
		return precioNeto;
	}
	private int getPrecioTotalPedido() {
		int precioNeto = getPrecioNetoPedido();
		int precioIVA = getPrecioIVAPedido();
		return precioNeto + precioIVA;
	}
	private int getPrecioIVAPedido() {
		int precioNeto = getPrecioNetoPedido();
		int precioIVA = (19*precioNeto)/100; 
		return precioIVA;
	}
	private String generarTextoFactura() {
		String factura = "Factura de compra\n";
		factura += "Nombre: " + nombreCliente + "\n";
		factura += "Dirección: " + direccionCliente + "\n";
		for (int i = 0; i <= listaProductos.size(); i++) {
			Producto item = listaProductos.get(i);
			String itemEntry = item.generarTextoFactura();
			factura += itemEntry + "\n";
		}
		return factura;
	}
	public void guardarFactura(File archivo) {
		
	}
	
	
}
