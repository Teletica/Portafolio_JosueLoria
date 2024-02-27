package tienda.demo.controller;

import tienda.demo.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j//es una parte de loombok, es oara que la vista entienda lo que se va a procesar, es un protocolo 
@RequestMapping("/categoria")//Este es otro API
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado") //este es el API
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);//ese getCategorias se sacan los datos de la variable que se llamaba
        model.addAttribute("categorias", categorias);//el primero es el nombre que se le esta dando, es segundo es la variable 
        model.addAttribute("totalCategorias", categorias.size());//.size le dice el tamaño que trae esa lista
        return "/categoria/listado";
    }
}