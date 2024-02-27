
package tienda.demo.service.impl;


import tienda.demo.dao.CategoriaDao;
import tienda.demo.domain.Categoria;
import tienda.demo.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jonathan
 */

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired//se conecta durectamente con este de abajo
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=true)//dimplemente se lee lo que hay en la base de datos
    public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();//obtenemos todos los objetos de la categoria de la base de datos
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
}
