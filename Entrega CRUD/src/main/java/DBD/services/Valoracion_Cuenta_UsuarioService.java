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
import DBD.models.Valoracion_Cuenta_Usuario;
import DBD.repositories.Valoracion_Cuenta_UsuarioRepository;

@CrossOrigin
@RestController
public class Valoracion_Cuenta_UsuarioService {
    private final Valoracion_Cuenta_UsuarioRepository Valoracion_Cuenta_UsuarioRepository;
    Valoracion_Cuenta_UsuarioService(@Lazy Valoracion_Cuenta_UsuarioRepository Valoracion_Cuenta_UsuarioRepository){
        this.Valoracion_Cuenta_UsuarioRepository = Valoracion_Cuenta_UsuarioRepository;
    }
    @GetMapping("/Valoracion_Cuenta_Usuario")
    public List<Valoracion_Cuenta_Usuario> getAll(){
        return Valoracion_Cuenta_UsuarioRepository.getAll();
    }
    @GetMapping("/Valoracion_Cuenta_Usuario/{id}")
    public List<Valoracion_Cuenta_Usuario> show(@PathVariable int id){
        return Valoracion_Cuenta_UsuarioRepository.show(id);
    }
    @PostMapping("/Valoracion_Cuenta_Usuario")
    @ResponseBody
    public Valoracion_Cuenta_Usuario crear(@RequestBody Valoracion_Cuenta_Usuario Valoracion_Cuenta_Usuario){
        return Valoracion_Cuenta_UsuarioRepository.crear(Valoracion_Cuenta_Usuario);
    }
    @PutMapping("/Valoracion_Cuenta_Usuario/{id}")
    @ResponseBody
    public Valoracion_Cuenta_Usuario update(@RequestBody Valoracion_Cuenta_Usuario Valoracion_Cuenta_Usuario, @PathVariable int id){
        Valoracion_Cuenta_Usuario.setID_Valoracion(id);
        return Valoracion_Cuenta_UsuarioRepository.update(Valoracion_Cuenta_Usuario);
    }
    @DeleteMapping("/Valoracion_Cuenta_Usuario/{id}")
    public String delete(@PathVariable int id){
        return Valoracion_Cuenta_UsuarioRepository.delete(id);
    }

}
