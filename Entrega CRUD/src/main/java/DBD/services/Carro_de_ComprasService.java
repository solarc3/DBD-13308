package DBD.services;
import java.util.List;
import DBD.models.Carro_de_Compras;
import DBD.repositories.Carro_de_ComprasRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class Carro_de_ComprasService {
    private final Carro_de_ComprasRepository Carro_de_ComprasRepository;
    Carro_de_ComprasService(@Lazy Carro_de_ComprasRepository Carro_de_ComprasRepository){
        this.Carro_de_ComprasRepository = Carro_de_ComprasRepository;
    }
    @GetMapping("/Carro_de_Compras")
    public List<Carro_de_Compras> getAll(){
        return Carro_de_ComprasRepository.getAll();
    }
    @GetMapping("/Carro_de_Compras/{id}")
    public List<Carro_de_Compras> show(@PathVariable int id){
        return Carro_de_ComprasRepository.show(id);
    }
    @PostMapping("/Carro_de_Compras")
    public Carro_de_Compras crear(@RequestBody Carro_de_Compras Carro_de_Compras){
        return Carro_de_ComprasRepository.crear(Carro_de_Compras);
    }
    @PutMapping("/Carro_de_Compras/{id}")
    public Carro_de_Compras update(@RequestBody Carro_de_Compras Carro_de_Compras, @PathVariable int id){
        Carro_de_Compras.setID_Carro(id);
        return Carro_de_ComprasRepository.update(Carro_de_Compras);
    }
    @DeleteMapping("/Carro_de_Compras/{id}")
    public String delete(@PathVariable int id){
        return Carro_de_ComprasRepository.delete(id);
    }
}
