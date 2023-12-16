package DBD.services;
import DBD.models.Seguimiento;
import DBD.repositories.SeguimientoRepository;
import DBD.repositories.SeguimientoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin // Permite solicitudes de dominios cruzados a este controlador.
@RestController
public class SeguimientoService {
    private final SeguimientoRepository seguimientoRepository;
    SeguimientoService(@Lazy SeguimientoRepositoryImp seguimientoRepository) {
        this.seguimientoRepository = seguimientoRepository;
    }
    @PostMapping
    public Seguimiento crear(@RequestBody Seguimiento seguimiento) {
        return seguimientoRepository.crear(seguimiento);
    }
    @PutMapping("/{id}")
    public Seguimiento update(@PathVariable("id") int idUsuarioSeguidor, @RequestBody Seguimiento seguimiento) {
        seguimiento.setID_Usuario_Seguidor(idUsuarioSeguidor);
        return seguimientoRepository.update(seguimiento);
    }
    // show
    public List<Seguimiento> show(@PathVariable("id") int idUsuarioSeguidor) {
        return seguimientoRepository.show(idUsuarioSeguidor);
    }
    @GetMapping
    public List<Seguimiento> getAll() {
        return seguimientoRepository.getAll();
    }

    @DeleteMapping("/{idUsuarioSeguidor}/{idUsuarioSeguido}") // Modificado para tomar dos ID
    public String delete(@PathVariable("idUsuarioSeguidor") int idUsuarioSeguidor,@PathVariable("idUsuarioSeguido") int idUsuarioSeguido) {
        return seguimientoRepository.delete(idUsuarioSeguidor, idUsuarioSeguido);
    }
}
