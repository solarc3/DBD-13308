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
import DBD.models.Valoracion;
import DBD.repositories.ValoracionRepository;
@CrossOrigin
@RestController
public class ValoracionService {
    private final ValoracionRepository ValoracionRepository;
    ValoracionService(@Lazy ValoracionRepository ValoracionRepository){
        this.ValoracionRepository = ValoracionRepository;
    }
    @GetMapping("/Valoracion")
    public List<Valoracion> getAll(){
        return ValoracionRepository.getAll();
    }
    @GetMapping("/Valoracion/{id}")
    public List<Valoracion> show(@PathVariable int id){
        return ValoracionRepository.show(id);
    }
    @PostMapping("/Valoracion")
    @ResponseBody
    public Valoracion crear(@RequestBody Valoracion Valoracion){
        return ValoracionRepository.crear(Valoracion);
    }
    @PutMapping("/Valoracion/{id}")
    @ResponseBody
    public Valoracion update(@RequestBody Valoracion Valoracion, @PathVariable int id){
        Valoracion.setID_Valoracion(id);
        return ValoracionRepository.update(Valoracion);
    }
    @DeleteMapping("/Valoracion/{id}")
    public String delete(@PathVariable int id){
        return ValoracionRepository.delete(id);
    }
}
