import java.util.Scanner;
public class GestionInventario {

        static Scanner scanner = new Scanner(System.in);
        static Producto[] inventario;

        public static void main(String[] args) {
            System.out.println("Bienvenido a la aplicación de gestión de inventario de la tienda de zapatos!");


            inventario = new Producto[5];


            int opcion;
            do {
                System.out.println("\nMenú:");
                System.out.println("1. Agregar producto");
                System.out.println("2. Realizar venta");
                System.out.println("3. Mostrar inventario");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        realizarVenta();
                        break;
                    case 3:
                        mostrarInventario();
                        break;
                    case 4:
                        System.out.println("Gracias por usar nuestra aplicación. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            } while (opcion != 4);
        }

        static void agregarProducto() {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la cantidad inicial: ");
            int cantidadInicial = scanner.nextInt();
            System.out.print("Ingrese el precio por unidad: ");
            double precio = scanner.nextDouble();


            Producto producto = new Producto(nombre, cantidadInicial, precio);
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i] == null) {
                    inventario[i] = producto;
                    System.out.println("Producto agregado exitosamente.");
                    return;
                }
            }
            System.out.println("El inventario está lleno. No se puede agregar más productos.");
        }

        static void realizarVenta() {
            System.out.print("Ingrese el nombre del producto a vender: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidadVenta = scanner.nextInt();


            for (Producto producto : inventario) {
                if (producto != null && producto.getNombre().equalsIgnoreCase(nombre)) {
                    if (producto.getCantidad() >= cantidadVenta) {
                        producto.vender(cantidadVenta);
                        System.out.println("Venta realizada exitosamente.");
                        return;
                    } else {
                        System.out.println("No hay suficiente stock para realizar la venta.");
                        return;
                    }
                }
            }
            System.out.println("El producto no está en el inventario.");
        }

        static void mostrarInventario() {
            System.out.println("Inventario:");
            for (Producto producto : inventario) {
                if (producto != null) {
                    System.out.println(producto);
                }
            }
        }
    }

    class Producto {
        private String nombre;
        private int cantidad;
        private double precio;

        public Producto(String nombre, int cantidad, double precio) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void vender(int cantidadVenta) {
            this.cantidad -= cantidadVenta;
            if (this.cantidad == 0) {
                this.cantidad *= 2;
            }
        }

        @Override
        public String toString() {
            return "Producto: " + nombre + ", Cantidad: " + cantidad + ", Precio: $" + precio;
        }
}






