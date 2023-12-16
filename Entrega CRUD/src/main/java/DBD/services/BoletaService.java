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
import DBD.models.Boleta;
import DBD.repositories.BoletaRepository;
@CrossOrigin
@RestController
public class BoletaService {
    private final BoletaRepository BoletaRepository;
    BoletaService(@Lazy BoletaRepository BoletaRepository){
        this.BoletaRepository = BoletaRepository;
    }
    @GetMapping("/Boleta")
    public List<Boleta> getAll(){
        return BoletaRepository.getAll();
    }
    @GetMapping("/Boleta/{id}")
    public List<Boleta> show(@PathVariable int id){
        return BoletaRepository.show(id);
    }
    @PostMapping("/Boleta")
    @ResponseBody
    public Boleta crear(@RequestBody Boleta Boleta){
        return BoletaRepository.crear(Boleta);
    }
    @PutMapping("/Boleta/{id}")
    @ResponseBody
    public Boleta update(@RequestBody Boleta Boleta, @PathVariable int id){
        Boleta.setID_Boleta(id);
        return BoletaRepository.update(Boleta);
    }
    @DeleteMapping("/Boleta/{id}")
    public String delete(@PathVariable int id){
        return BoletaRepository.delete(id);
    }
}
