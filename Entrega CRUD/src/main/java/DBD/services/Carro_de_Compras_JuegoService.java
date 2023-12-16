package DBD.services;
import DBD.models.Carro_de_Compras_Juego;
import DBD.repositories.Carro_de_Compras_JuegoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Carro_de_Compras_JuegoService {
    private final Carro_de_Compras_JuegoRepository Carro_de_Compras_JuegoRepository;
    Carro_de_Compras_JuegoService(@Lazy Carro_de_Compras_JuegoRepository Carro_de_Compras_JuegoRepository){
        this.Carro_de_Compras_JuegoRepository = Carro_de_Compras_JuegoRepository;
    }
    @GetMapping("/Carro_de_Compras_Juego")
    public List<Carro_de_Compras_Juego> getAll(){
        return Carro_de_Compras_JuegoRepository.getAll();
    }
    @GetMapping("/Carro_de_Compras_Juego/{id}")
    public List<Carro_de_Compras_Juego> show(@PathVariable int id){
        return Carro_de_Compras_JuegoRepository.show(id);
    }
    @PostMapping("/Carro_de_Compras_Juego")
    public Carro_de_Compras_Juego crear(@RequestBody Carro_de_Compras_Juego Carro_de_Compras_Juego){
        return Carro_de_Compras_JuegoRepository.crear(Carro_de_Compras_Juego);
    }
    @PutMapping("/Carro_de_Compras_Juego/{id}")
    public Carro_de_Compras_Juego update(@RequestBody Carro_de_Compras_Juego Carro_de_Compras_Juego, @PathVariable int id){
        Carro_de_Compras_Juego.setID_Carro(id);
        return Carro_de_Compras_JuegoRepository.update(Carro_de_Compras_Juego);
    }
    @DeleteMapping("/Carro_de_Compras_Juego/{id}")
    public String delete(@PathVariable int id){
        return Carro_de_Compras_JuegoRepository.delete(id);
    }
}
