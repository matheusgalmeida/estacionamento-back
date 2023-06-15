package br.com.uniamerica.estacionamento.controller;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/api/configuracao")
public class ConfiguracaoController {
    @Autowired
    private CondutorRepository condutorRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Condutor> findById(
            @RequestParam("id") final Long id
    ){
        return
                ResponseEntity.ok().body(this.condutorRepository.findById(id).orElse(new Condutor()));
    }
    @PostMapping
    public ResponseEntity<?> inserir(
            @RequestBody Condutor condutor
    ){
        this.condutorRepository.save(condutor);
        return ResponseEntity.ok().body("Configuration registered successfully!");
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
        return ResponseEntity.ok().body("Updated successfully!");
    }
}