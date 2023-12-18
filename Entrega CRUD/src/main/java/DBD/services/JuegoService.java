package DBD.services;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import DBD.models.Juego;
import DBD.repositories.JuegoRepository;
@CrossOrigin
@RestController
public class JuegoService {
    private final JuegoRepository JuegoRepository;
    JuegoService(@Lazy JuegoRepository JuegoRepository){
        this.JuegoRepository = JuegoRepository;
    }
    @GetMapping("/Juego")
    public List<Juego> getAll(){
        return JuegoRepository.getAll();
    }
    @GetMapping("/Juego/{id}")
    public List<Juego> show(@PathVariable int id){
        return JuegoRepository.show(id);
    }
    @PostMapping("/Juego")
    @ResponseBody
    public Juego crear(@RequestBody Juego Juego, HttpServletRequest request){
        HttpSession session = request.getSession();
        int id_tipo = (int) session.getAttribute("ID_tipo");
        if (id_tipo == 2 || id_tipo == 3){
            return JuegoRepository.crear(Juego);
        }
        return null;
    }
    @PutMapping("/Juego/{id}")
    @ResponseBody
    public Juego update(@RequestBody Juego Juego, @PathVariable int id, HttpServletRequest request){
        Juego.setIDJuego(id);
        HttpSession session = request.getSession();
        int id_tipo = (int) session.getAttribute("ID_tipo");
        if (id_tipo == 2 || id_tipo == 3){
            return JuegoRepository.update(Juego);
        }
        return null;
    }
    @DeleteMapping("/Juego/{id}")
    public String delete(@PathVariable int id, HttpServletRequest request){
        HttpSession session = request.getSession();
        int id_tipo = (int) session.getAttribute("ID_tipo");
        if (id_tipo == 2 || id_tipo == 3){
            return JuegoRepository.delete(id);
        }
        return null;
    }
}
