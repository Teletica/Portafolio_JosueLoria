/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.demo.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


/*
  La notacion @Data es una extencion de Lombok que incluye metodos set y get
  to string equals entre otros   
*/
@Data​
/*
  Esta anotación marca esta clase como una entidad de persistencia, 
  lo que significa que está mapeada a una tabla en la base de datos. Cada instancia de esta clase 
  representa una fila en la tabla rol.
*/
@Entity​
/*
 La anotacion Table hacereferencia a la tabla de la base de datos 
*/
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
      Esto hace referencia a la llave primaria de la base de datos por lo cual 
      Se hara el llamado a la tabla rol sol con esta llave
    */
    @Id​
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;    
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne​
    @JoinColumn(name="id_categoria")
    Categoria categoria;

    public Producto() {      
    }

    public Producto(String descripcion, String detalle, double precio, int existencias, String imagen, boolean activo) {
        this.descripcion = descripcion;;
        this.detalle = detalle;;
        this.precio = precio;;
        this.existencias = existencias;;
        this.rutaImagen = imagen;;
        this.activo = activo;;
    }
}
