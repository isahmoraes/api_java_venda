
package cadastro_veiculo_spring.controller;

import cadastro_veiculo_spring.model.VendaVeiculo;
import cadastro_veiculo_spring.service.VendaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")

public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<VendaVeiculo> salvar(@RequestBody VendaVeiculo venda) {
        return ResponseEntity.ok(service.salvar(venda));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaVeiculo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<VendaVeiculo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaVeiculo> atualizar(@PathVariable Long id, @RequestBody VendaVeiculo venda) {
        return ResponseEntity.ok(service.atualizar(id, venda));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}