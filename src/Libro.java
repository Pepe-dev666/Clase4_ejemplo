import java.util.ArrayList;
import java.util.List;

public class Libro {
  private String autor;
  private String titulo;
  private String genero;
  private String codigoBarras;


  
public Libro() {
}
public Libro(String autor, String titulo, String genero, String codigoBarras) {
    this.autor = autor;
    this.titulo = titulo;
    this.genero = genero;
    this.codigoBarras = codigoBarras;

}
public String getAutor() {
    return autor;
}
public String getTitulo() {
    return titulo;
}
public String getGenero() {
    return genero;
}
public String getCodigoBarras() {
    return codigoBarras;
}
public void setAutor(String autor) {
    this.autor = autor;
}
public void setTitulo(String titulo) {
    this.titulo = titulo;
}
public void setGenero(String genero) {
    this.genero = genero;
}
public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
}
  
 public Libro  buscarporCodigo(List<Libro> libros, String codigoBarras){
    for(int i=0;i<libros.size(); i++){
       if(libros.get(i).getCodigoBarras()==codigoBarras){
           return libros.get(i);
       }
    }
    return null;
  
}

public Libro buscarPorCodigo(List<Libro> libros, String codigoBarras) {
        for (Libro libro : libros) { 
            if (libro.getCodigoBarras().equals(codigoBarras)) { 
                return libro;
            }
        }
        return null; 
    }

    
    public void mostrarTodos(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("⚠️ No hay libros en la biblioteca.");
            return;
        }

        for (Libro libro : libros) { 
            System.out.println(" Nombre: " + libro.getTitulo());
            System.out.println(" Autor: " + libro.getAutor());
            System.out.println(" Género: " + libro.getGenero());
            System.out.println(" Código de Barras: " + libro.getCodigoBarras());
            System.out.println("----------------------------");
        }
    }

    
    public List<Libro> buscarPorGenero(List<Libro> libros, String genero) {
        List<Libro> resultados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) { 
                resultados.add(libro);
            }
        }
        return resultados; 
    }
}
