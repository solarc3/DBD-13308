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
import DBD.models.Juego;
import DBD.repositories.JuegoRepository;
@CrossOrigin
@RestController
public class JuegoService {
    private final JuegoRepository JuegoRepository;
    JuegoService(@Lazy JuegoRepository JuegoRepository){
        this.JuegoRepository = JuegoRepository;
    }
    @GetMapping("/Juego")
    public List<Juego> getAll(){
        return JuegoRepository.getAll();
    }
    @GetMapping("/Juego/{id}")
    public List<Juego> show(@PathVariable int id){
        return JuegoRepository.show(id);
    }
    @PostMapping("/Juego")
    @ResponseBody
    public Juego crear(@RequestBody Juego Juego){
        return JuegoRepository.crear(Juego);
    }
    @PutMapping("/Juego/{id}")
    @ResponseBody
    public Juego update(@RequestBody Juego Juego, @PathVariable int id){
        Juego.setIDJuego(id);
        return JuegoRepository.update(Juego);
    }
    @DeleteMapping("/Juego/{id}")
    public String delete(@PathVariable int id){
        return JuegoRepository.delete(id);
    }
}
