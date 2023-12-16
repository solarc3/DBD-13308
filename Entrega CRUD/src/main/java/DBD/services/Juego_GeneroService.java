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
import DBD.models.Juego_Genero;
import DBD.repositories.Juego_GeneroRepository;
@CrossOrigin
@RestController
public class Juego_GeneroService {
    private final Juego_GeneroRepository Juego_GeneroRepository;
    Juego_GeneroService(@Lazy Juego_GeneroRepository Juego_GeneroRepository){
        this.Juego_GeneroRepository = Juego_GeneroRepository;
    }
    @GetMapping("/Juego_Genero")
    public List<Juego_Genero> getAll(){
        return Juego_GeneroRepository.getAll();
    }
    @GetMapping("/Juego_Genero/{id}")
    public List<Juego_Genero> show(@PathVariable int id){
        return Juego_GeneroRepository.show(id);
    }
    @PostMapping("/Juego_Genero")
    @ResponseBody
    public Juego_Genero crear(@RequestBody Juego_Genero Juego_Genero){
        return Juego_GeneroRepository.crear(Juego_Genero);
    }
    @PutMapping("/Juego_Genero/{id}")
    @ResponseBody
    public Juego_Genero update(@RequestBody Juego_Genero Juego_Genero, @PathVariable int id){
        Juego_Genero.setID_Juego(id);
        return Juego_GeneroRepository.update(Juego_Genero);
    }
    @DeleteMapping("/Juego_Genero/{id}")
    public String delete(@PathVariable int id){
        return Juego_GeneroRepository.delete(id);
    }
}
