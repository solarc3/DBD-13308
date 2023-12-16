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
import DBD.models.Compra_Cuenta_Usuario;
import DBD.repositories.Compra_Cuenta_UsuarioRepository;
@CrossOrigin
@RestController
public class Compra_Cuenta_UsuarioService {
    private final Compra_Cuenta_UsuarioRepository Compra_Cuenta_UsuarioRepository;
    Compra_Cuenta_UsuarioService(@Lazy Compra_Cuenta_UsuarioRepository Compra_Cuenta_UsuarioRepository){
        this.Compra_Cuenta_UsuarioRepository = Compra_Cuenta_UsuarioRepository;
    }
    @GetMapping("/Compra_Cuenta_Usuario")
    public List<Compra_Cuenta_Usuario> getAll(){
        return Compra_Cuenta_UsuarioRepository.getAll();
    }
    @GetMapping("/Compra_Cuenta_Usuario/{id}")
    public List<Compra_Cuenta_Usuario> show(@PathVariable int id){
        return Compra_Cuenta_UsuarioRepository.show(id);
    }
    @PostMapping("/Compra_Cuenta_Usuario")
    @ResponseBody
    public Compra_Cuenta_Usuario crear(@RequestBody Compra_Cuenta_Usuario Compra_Cuenta_Usuario){
        return Compra_Cuenta_UsuarioRepository.crear(Compra_Cuenta_Usuario);
    }
    @PutMapping("/Compra_Cuenta_Usuario/{id}")
    @ResponseBody
    public Compra_Cuenta_Usuario update(@RequestBody Compra_Cuenta_Usuario Compra_Cuenta_Usuario, @PathVariable int id){
        Compra_Cuenta_Usuario.setID_Compra(id);
        return Compra_Cuenta_UsuarioRepository.update(Compra_Cuenta_Usuario);
    }
    @DeleteMapping("/Compra_Cuenta_Usuario/{id}")
    public String delete(@PathVariable int id){
        return Compra_Cuenta_UsuarioRepository.delete(id);
    }
}
