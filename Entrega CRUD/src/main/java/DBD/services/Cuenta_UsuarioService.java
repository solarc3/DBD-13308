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
import DBD.models.Cuenta_Usuario;
import DBD.repositories.Cuenta_UsuarioRepository;
@CrossOrigin
@RestController
public class Cuenta_UsuarioService {
    private final Cuenta_UsuarioRepository Cuenta_UsuarioRepository;
    Cuenta_UsuarioService(@Lazy Cuenta_UsuarioRepository Cuenta_UsuarioRepository){
        this.Cuenta_UsuarioRepository = Cuenta_UsuarioRepository;
    }
    @GetMapping("/Cuenta_Usuario")
    public List<Cuenta_Usuario> getAll(){
        return Cuenta_UsuarioRepository.getAll();
    }
    @GetMapping("/Cuenta_Usuario/{id}")
    public List<Cuenta_Usuario> show(@PathVariable int id){
        return Cuenta_UsuarioRepository.show(id);
    }
    @GetMapping("/Cuenta_Usuario/email/{correo}")
    public Cuenta_Usuario findbyEmail(@PathVariable String correo){
        return Cuenta_UsuarioRepository.findbyEmail(correo);
    }
    @PostMapping("/Cuenta_Usuario")
    @ResponseBody
    public Cuenta_Usuario crear(@RequestBody Cuenta_Usuario Cuenta_Usuario){
        return Cuenta_UsuarioRepository.crear(Cuenta_Usuario);
    }
    @PutMapping("/Cuenta_Usuario/{id}")
    @ResponseBody
    public Cuenta_Usuario update(@RequestBody Cuenta_Usuario Cuenta_Usuario, @PathVariable int id){
        Cuenta_Usuario.setID_Usuario(id);
        return Cuenta_UsuarioRepository.update(Cuenta_Usuario);
    }
    @DeleteMapping("/Cuenta_Usuario/{id}")
    public String delete(@PathVariable int id){
        return Cuenta_UsuarioRepository.delete(id);
    }
}
