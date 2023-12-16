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
import DBD.models.Tipo_Cuenta_Usuario;
import DBD.repositories.Tipo_Cuenta_UsuarioRepository;
@CrossOrigin
@RestController
public class Tipo_Cuenta_UsuarioService {
    private final Tipo_Cuenta_UsuarioRepository Tipo_Cuenta_UsuarioRepository;
    Tipo_Cuenta_UsuarioService(@Lazy Tipo_Cuenta_UsuarioRepository Tipo_Cuenta_UsuarioRepository){
        this.Tipo_Cuenta_UsuarioRepository = Tipo_Cuenta_UsuarioRepository;
    }
    @GetMapping("/Tipo_Cuenta_Usuario")
    public List<Tipo_Cuenta_Usuario> getAll(){
        return Tipo_Cuenta_UsuarioRepository.getAll();
    }
    @GetMapping("/Tipo_Cuenta_Usuario/{id}")
    public List<Tipo_Cuenta_Usuario> show(@PathVariable int id){
        return Tipo_Cuenta_UsuarioRepository.show(id);
    }
    @PostMapping("/Tipo_Cuenta_Usuario")
    @ResponseBody
    public Tipo_Cuenta_Usuario crear(@RequestBody Tipo_Cuenta_Usuario Tipo_Cuenta_Usuario){
        return Tipo_Cuenta_UsuarioRepository.crear(Tipo_Cuenta_Usuario);
    }
    @PutMapping("/Tipo_Cuenta_Usuario/{id}")
    @ResponseBody
    public Tipo_Cuenta_Usuario update(@RequestBody Tipo_Cuenta_Usuario Tipo_Cuenta_Usuario, @PathVariable int id){
        Tipo_Cuenta_Usuario.setID_Tipo(id);
        return Tipo_Cuenta_UsuarioRepository.update(Tipo_Cuenta_Usuario);
    }
    @DeleteMapping("/Tipo_Cuenta_Usuario/{id}")
    public String delete(@PathVariable int id){
        return Tipo_Cuenta_UsuarioRepository.delete(id);
    }
}
