package uvg.edu;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ProductoAdmin manager = new ProductoAdmin();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cargando productos desde el CSV...");
        manager.cargarCSV("productos.csv"); // Asegúrate de cambiar esto a la ruta correcta.

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Listar productos ordenados por precio");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el SKU del producto: ");
                    String sku = scanner.nextLine();
                    Producto encontrado = manager.buscarPorSKU(sku);
                    if (encontrado != null) {
                        System.out.println("Producto encontrado:\n" + encontrado);
                    } else {
                        System.out.println("No se encontró el producto con SKU: " + sku);
                    }
                    break;
                case 2:
                    System.out.println("Productos ordenados por SKU:");
                    manager.listarProductosOrdenados();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
