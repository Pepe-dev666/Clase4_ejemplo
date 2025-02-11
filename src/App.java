import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);
        List<Libro> libros = new ArrayList<>();
       

        // Creación de libros sin errores
        Libro l1 = new Libro();
        l1.setTitulo("100 años de soledad");
        l1.setAutor("Gabriel García Márquez");
        l1.setGenero("Novela");
        l1.setCodigoBarras("00001");

        Libro l2 = new Libro();
        l2.setTitulo("Harry Potter");
        l2.setAutor("Rowling");
        l2.setGenero("Ciencia ficción");
        l2.setCodigoBarras("00002");

        Libro l3 = new Libro();
        Libro gestor = new Libro();
        l3.setTitulo("Operación aritmética");
        l3.setAutor("Baldor");
        l3.setGenero("Educación");
        l3.setCodigoBarras("00003");
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);

       
        int opcion;
        do {
            System.out.println("\n --  MENÚ DE BIBLIOTECA --");
            System.out.println("1️ Guardar libro ");
            System.out.println("2️ Buscar por código");
            System.out.println("3️ Mostrar todos los libros");
            System.out.println("4️ Buscar por género");
            System.out.println("5️ Salir");
            System.out.print(" Ingrese una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    System.out.print(" Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print(" Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print(" Ingrese el género: ");
                    String genero = scanner.nextLine();
                    System.out.print(" Ingrese el código de barras: ");
                    String codigo = scanner.nextLine();

                    libros.add(new Libro(titulo, autor, genero, codigo));
                    System.out.println(" Libro guardado exitosamente.");
                    break;

                case 2:
                    
                    System.out.print("Ingrese el código de barras a buscar: ");
                    String codigoBuscado = scanner.nextLine();
                    Libro encontrado = gestor.buscarPorCodigo(libros, codigoBuscado);
                    
                    if (encontrado != null) {
                        System.out.println("\n Libro encontrado:");
                        System.out.println("Título: " + encontrado.getTitulo());
                        System.out.println("Autor: " + encontrado.getAutor());
                        System.out.println("Género: " + encontrado.getGenero());
                        System.out.println("Código de Barras: " + encontrado.getCodigoBarras());
                    } else {
                        System.out.println(" No se encontró ningún libro con ese código.");
                    }
                    break;

                case 3:
                    
                    gestor.mostrarTodos(libros);
                    break;

                case 4:
                    
                    System.out.print(" Ingrese el género a buscar: ");
                    String generoBuscado = scanner.nextLine();
                    List<Libro> resultados = gestor.buscarPorGenero(libros, generoBuscado);
                    
                    if (resultados.isEmpty()) {
                        System.out.println(" No hay libros de ese género.");
                    } else {
                        gestor.mostrarTodos(resultados);
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println(" Saliendo del sistema. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println(" Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}