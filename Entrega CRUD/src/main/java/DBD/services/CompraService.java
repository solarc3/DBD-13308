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
import DBD.models.Compra;
import DBD.repositories.CompraRepository;
@CrossOrigin
@RestController
public class CompraService {
    private final CompraRepository CompraRepository;
    CompraService(@Lazy CompraRepository CompraRepository){
        this.CompraRepository = CompraRepository;
    }
    @GetMapping("/Compra")
    public List<Compra> getAll(){
        return CompraRepository.getAll();
    }
    @GetMapping("/Compra/{id}")
    public List<Compra> show(@PathVariable int id){
        return CompraRepository.show(id);
    }
    @PostMapping("/Compra")
    @ResponseBody
    public Compra crear(@RequestBody Compra Compra){
        return CompraRepository.crear(Compra);
    }
    @PutMapping("/Compra/{id}")
    @ResponseBody
    public Compra update(@RequestBody Compra Compra, @PathVariable int id){
        Compra.setID_Compra(id);
        return CompraRepository.update(Compra);
    }
    @DeleteMapping("/Compra/{id}")
    public String delete(@PathVariable int id){
        return CompraRepository.delete(id);
    }
}
