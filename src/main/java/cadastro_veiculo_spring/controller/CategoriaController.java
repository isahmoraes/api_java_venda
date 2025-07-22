package cadastro_veiculo_spring.controller;

import cadastro_veiculo_spring.model.Categoria;
import cadastro_veiculo_spring.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public List<Categoria> getAll() {
        return categoriaService.listarTodos();
    }

 @GetMapping("/{id}")
public ResponseEntity<Categoria> getById(@PathVariable Integer id) {
    return Optional.ofNullable(categoriaService.buscarPorId(id))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PutMapping("/{id}")
public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
    return Optional.ofNullable(categoriaService.atualizar(id, categoria))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Integer id) {
    try {
        categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    }
}
// função para cadastrar categoria 
@PostMapping("/cadastrar")
public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
    return ResponseEntity.ok(categoriaService.salvar(categoria));

}
}
