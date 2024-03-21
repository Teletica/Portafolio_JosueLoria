package tienda.demo.dao;

import tienda.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 El Dao lo que hace es darme conexion con la base de datos 
 Por lo tanto hay que ver que entidad hay en la base de datos para cambiarlo aca 
*/

public interface CategoriaDao extends JpaRepository <Categoria,Long> {
    
}