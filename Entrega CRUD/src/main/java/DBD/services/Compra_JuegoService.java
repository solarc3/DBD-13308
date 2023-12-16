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
import DBD.models.Compra_Juego;
import DBD.repositories.Compra_JuegoRepository;
@CrossOrigin
@RestController
public class Compra_JuegoService {
    private final Compra_JuegoRepository Compra_JuegoRepository;
    Compra_JuegoService(@Lazy Compra_JuegoRepository Compra_JuegoRepository){
        this.Compra_JuegoRepository = Compra_JuegoRepository;
    }
    @GetMapping("/Compra_Juego")
    public List<Compra_Juego> getAll(){
        return Compra_JuegoRepository.getAll();
    }
    @GetMapping("/Compra_Juego/{id}")
    public List<Compra_Juego> show(@PathVariable int id){
        return Compra_JuegoRepository.show(id);
    }
    @PostMapping("/Compra_Juego")
    @ResponseBody
    public Compra_Juego crear(@RequestBody Compra_Juego Compra_Juego){
        return Compra_JuegoRepository.crear(Compra_Juego);
    }
    @PutMapping("/Compra_Juego/{id}")
    @ResponseBody
    public Compra_Juego update(@RequestBody Compra_Juego Compra_Juego, @PathVariable int id){
        Compra_Juego.setID_Compra(id);
        return Compra_JuegoRepository.update(Compra_Juego);
    }
    @DeleteMapping("/Compra_Juego/{id}")
    public String delete(@PathVariable int id){
        return Compra_JuegoRepository.delete(id);
    }
}
