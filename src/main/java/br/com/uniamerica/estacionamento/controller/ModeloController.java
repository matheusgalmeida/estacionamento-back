package br.com.uniamerica.estacionamento.controller;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/api/modelo")
public class ModeloController {
    @Autowired
    private CondutorRepository condutorRepository;
    @GetMapping("/lista")
    public ResponseEntity<List<Condutor>> findAll(){
        return
                ResponseEntity.ok().body(this.condutorRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Condutor> findtenhById(
            @RequestParam("id") final Long id
    ){
        return
                ResponseEntity.ok().body(this.condutorRepository.findById(id).orElse(new Condutor()));
    }
   // @GetMapping
 //   public ResponseEntity<List<Condutor>> findByAtivo(){
     //   return
     //           ResponseEntity.ok().body(this.condutorRepository.findByAtivo());
    //}
    @PostMapping
    public ResponseEntity<?> inserir(
            @RequestBody Condutor condutor
    ){
        this.condutorRepository.save(condutor);
        return ResponseEntity.ok().body("Model egistered successfully!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Condutor condutor
    ){
        if(id.equals(condutor.getId())){
            this.condutorRepository.save(condutor);
        }else {
            return ResponseEntity.badRequest().body("ID not Found!");
        }
        return ResponseEntity.ok().body("Registred successfully!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable final Long id,
            @RequestBody final Condutor condutor
    ){
        if (condutor.isAtivo()) {
            this.condutorRepository.delete(condutor);
        }else {
            return ResponseEntity.badRequest().body("The model is linked to a transaction and cannot be deleted.");
        }
        return ResponseEntity.ok().body("Deleted successfully!");
    }
}