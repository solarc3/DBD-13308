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
import DBD.models.Tipo;
import DBD.repositories.TipoRepository;
@CrossOrigin
@RestController
public class TipoService {
    private final TipoRepository TipoRepository;
    TipoService(@Lazy TipoRepository TipoRepository){
        this.TipoRepository = TipoRepository;
    }
    @GetMapping("/Tipo")
    public List<Tipo> getAll(){
        return TipoRepository.getAll();
    }
    @GetMapping("/Tipo/{id}")
    public List<Tipo> show(@PathVariable int id){
        return TipoRepository.show(id);
    }
    @PostMapping("/Tipo")
    @ResponseBody
    public Tipo crear(@RequestBody Tipo Tipo){
        return TipoRepository.crear(Tipo);
    }
    @PutMapping("/Tipo/{id}")
    @ResponseBody
    public Tipo update(@RequestBody Tipo Tipo, @PathVariable int id){
        Tipo.setID_Tipo(id);
        return TipoRepository.update(Tipo);
    }
    @DeleteMapping("/Tipo/{id}")
    public String delete(@PathVariable int id){
        return TipoRepository.delete(id);
    }
}
