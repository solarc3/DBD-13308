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
import DBD.models.Medio_de_Pago;
import DBD.repositories.Medio_de_PagoRepository;
public class Medio_de_PagoService {
    private final Medio_de_PagoRepository Medio_de_PagoRepository;
    Medio_de_PagoService(@Lazy Medio_de_PagoRepository Medio_de_PagoRepository){
        this.Medio_de_PagoRepository = Medio_de_PagoRepository;
    }
    @GetMapping("/Medio_de_Pago")
    public List<Medio_de_Pago> getAll(){
        return Medio_de_PagoRepository.getAll();
    }
    @GetMapping("/Medio_de_Pago/{id}")
    public List<Medio_de_Pago> show(@PathVariable int id){
        return Medio_de_PagoRepository.show(id);
    }
    @PostMapping("/Medio_de_Pago")
    @ResponseBody
    public Medio_de_Pago crear(@RequestBody Medio_de_Pago Medio_de_Pago){
        return Medio_de_PagoRepository.crear(Medio_de_Pago);
    }
    @PutMapping("/Medio_de_Pago/{id}")
    @ResponseBody
    public Medio_de_Pago update(@RequestBody Medio_de_Pago Medio_de_Pago, @PathVariable int id){
        Medio_de_Pago.setID_pago(id);
        return Medio_de_PagoRepository.update(Medio_de_Pago);
    }
    @DeleteMapping("/Medio_de_Pago/{id}")
    public String delete(@PathVariable int id){
        return Medio_de_PagoRepository.delete(id);
    }
}
