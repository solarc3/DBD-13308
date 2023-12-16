package DBD.services;
import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import DBD.models.Genero;
import DBD.repositories.GeneroRepository;
@CrossOrigin
@RestController
public class GeneroService {
    private final GeneroRepository GeneroRepository;
    GeneroService(@Lazy GeneroRepository GeneroRepository){
        this.GeneroRepository = GeneroRepository;
    }
    @GetMapping("/Genero")
    public List<Genero> getAll(){
        return GeneroRepository.getAll();
    }
    @GetMapping("/Genero/{id}")
    public List<Genero> show(@PathVariable int id){
        return GeneroRepository.show(id);
    }
    @PostMapping("/Genero")
    @ResponseBody
    public Genero crear(@RequestBody Genero Genero){
        return GeneroRepository.crear(Genero);
    }
    @PutMapping("/Genero/{id}")
    @ResponseBody
    public Genero update(@RequestBody Genero Genero, @PathVariable int id){
        Genero.setID_Genero(id);
        return GeneroRepository.update(Genero);
    }
    @DeleteMapping("/Genero/{id}")
    public String delete(@PathVariable int id){
        return GeneroRepository.delete(id);
    }
}
