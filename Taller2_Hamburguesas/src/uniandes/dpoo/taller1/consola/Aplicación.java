package uniandes.dpoo.taller1.consola;

import uniandes.dpoo.taller1.procesamiento.Restaurante;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Aplicación {
	private Restaurante restaurante;
	public static void main(String args[]) throws FileNotFoundException {
		String absPath = "C:\\Users\\eqg20\\Documents\\universidad\\diseño y programación orientada a objetos"
				+ "\\eclipse\\Taller2_Hamburguesas";
		Restaurante restaurante = new Restaurante();
		String menuPath = absPath + "\\data\\menu.txt";
		String ingredientesPath = absPath + "\\data\\ingredientes.txt";
		String combosPath = absPath + "\\data\\combos.txt";
		File menuFile = new File(menuPath);
		File ingredientesFile = new File(ingredientesPath);
		File combosFile = new File(combosPath);
		restaurante.cargarInformacionRestaurante(ingredientesFile, menuFile, combosFile);
	}
	
	public void mostrarMenuOpciones() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Consultar menu");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido (dado su ID)");
	}
	public void mostrarMenu() {
		Map<String, Integer> menuBase = restaurante.getMenuBase();
		int i = 1;
		for (String key : menuBase.keySet()) {
			int cost = menuBase.get(key);
			System.out.println(Integer.toString(i) + ": " + key + ": $" + cost + ".");
		}
	}
	
	public void ejecutarIniciarNuevoPedido(int opcionSeleccionada) {
		
	}
	
	public void ejecutarAplicacion() {
		System.out.println("¡Bienvenido a la interfaz de pedidos de 'El Corral'!\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuOpciones();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					mostrarMenu();
				else if (opcion_seleccionada == 2 && restaurante != null)
					ejecutarIniciarNuevoPedido();
				else if (opcion_seleccionada == 3 && restaurante != null)
					ejecutarAgregarElementoAPedido();
				else if (opcion_seleccionada == 4 && restaurante != null)
					ejecutarCerrarYGuardarPedido();
				else if (opcion_seleccionada == 5 && restaurante != null)
					ejecutarConsultarPedidoConID();
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
}
