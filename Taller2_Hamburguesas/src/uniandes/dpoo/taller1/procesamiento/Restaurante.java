package uniandes.dpoo.taller1.procesamiento;

import java.util.*;
import java.io.*;
import uniandes.dpoo.taller1.modelo.Pedido;
import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.ProductoMenu;
import java.util.Scanner;

public class Restaurante {
	ArrayList<Combo> combos;
	public Queue<Pedido> pedidos;
	public Pedido pedidoEnCurso;
	ArrayList<ProductoMenu> menuBase;
	ArrayList<Ingrediente> ingredientes;
	public Restaurante() {
		this.combos = new ArrayList<>();
		this.pedidos = new LinkedList<>();
		this.menuBase = new ArrayList<>();
		this.pedidoEnCurso = pedidos.poll();
		this.ingredientes = new ArrayList<>();
	}
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido newPedido = new Pedido(nombreCliente, direccionCliente);
		pedidos.add(newPedido);
	}
	public void cerrarYGuardarPedido() {
		
	}
	public Pedido getPedidoEnCurso() {
		return pedidoEnCurso;
	}
	public ArrayList<ProductoMenu> getMenuBase() {
		return menuBase;
	}
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws FileNotFoundException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	private void cargarIngredientes(File archivoIngredientes) throws FileNotFoundException {
		Scanner reader = new Scanner(archivoIngredientes);
		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			String[] data_list = data.split(";");
			Ingrediente newIngrediente = new Ingrediente(data_list[0], Integer.parseInt(data_list[1]));
			ingredientes.add(newIngrediente);
		}
		reader.close();
	}
	private void cargarMenu(File archivoMenu) throws FileNotFoundException {
		Scanner reader = new Scanner(archivoMenu);
		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			String[] data_list = data.split(";");
			ProductoMenu newProductoMenu = new ProductoMenu(data_list[0], Integer.parseInt(data_list[1]));
			menuBase.add(newProductoMenu);
		}
		reader.close();
	}
	private void cargarCombos(File archivoCombos) throws FileNotFoundException {
		Scanner reader = new Scanner(archivoCombos);
		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			String[] data_list = data.split(";");
			float discount = (Integer.parseInt(data_list[1].replace("%","")))/100;
			Combo newCombo = new Combo(data_list[0], discount);
			combos.add(newCombo);
			int i = 2;
			while (i <= data_list.length) {
				newCombo.agregarItemACombo(data_list[i]);
				i += 1;
			}
		reader.close();
		}
	}
}
