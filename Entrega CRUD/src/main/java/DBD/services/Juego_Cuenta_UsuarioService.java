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
import DBD.models.Juego_Cuenta_Usuario;
import DBD.repositories.Juego_Cuenta_UsuarioRepository;
@CrossOrigin
@RestController
public class Juego_Cuenta_UsuarioService {
    private final Juego_Cuenta_UsuarioRepository Juego_Cuenta_UsuarioRepository;
    Juego_Cuenta_UsuarioService(@Lazy Juego_Cuenta_UsuarioRepository Juego_Cuenta_UsuarioRepository){
        this.Juego_Cuenta_UsuarioRepository = Juego_Cuenta_UsuarioRepository;
    }
    @GetMapping("/Juego_Cuenta_Usuario")
    public List<Juego_Cuenta_Usuario> getAll(){
        return Juego_Cuenta_UsuarioRepository.getAll();
    }
    @GetMapping("/Juego_Cuenta_Usuario/{id}")
    public List<Juego_Cuenta_Usuario> show(@PathVariable int id){
        return Juego_Cuenta_UsuarioRepository.show(id);
    }
    @PostMapping("/Juego_Cuenta_Usuario")
    @ResponseBody
    public Juego_Cuenta_Usuario crear(@RequestBody Juego_Cuenta_Usuario Juego_Cuenta_Usuario){
        return Juego_Cuenta_UsuarioRepository.crear(Juego_Cuenta_Usuario);
    }
    @PutMapping("/Juego_Cuenta_Usuario/{id}")
    @ResponseBody
    public Juego_Cuenta_Usuario update(@RequestBody Juego_Cuenta_Usuario Juego_Cuenta_Usuario, @PathVariable int id){
        Juego_Cuenta_Usuario.setID_Juego(id);
        return Juego_Cuenta_UsuarioRepository.update(Juego_Cuenta_Usuario);
    }
    @DeleteMapping("/Juego_Cuenta_Usuario/{id}")
    public String delete(@PathVariable int id){
        return Juego_Cuenta_UsuarioRepository.delete(id);
    }
}
