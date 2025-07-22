package cadastro_veiculo_spring.controller;

import cadastro_veiculo_spring.model.Vendedor;
import cadastro_veiculo_spring.service.VendedorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")

public class VendedorController {

    private final VendedorService service;

    public VendedorController(VendedorService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Vendedor> salvar(@RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(service.salvar(vendedor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Vendedor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> atualizar(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(service.atualizar(id, vendedor));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
