package cadastro_veiculo_spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cadastro_veiculo_spring.model.Veiculo;
import cadastro_veiculo_spring.service.VeiculoService;



@RestController

@CrossOrigin(origins = "*")
public class VeiculoController {

    private final VeiculoService service;
    Logger logger = Logger.getLogger(VeiculoController.class);

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping("/api/veiculos/salvar") // Definindo as rotas para os métodos HTTP
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        logger.info("Salvando veículo: " + veiculo + " no controller.");
        return service.salvar(veiculo);
    }

    @GetMapping("/api/veiculos/buscar/{id}")
    public Veiculo buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/api/veiculos/listarTodos")
    public List<Veiculo> listarTodos() {
        logger.info("Listando veículos no controller.");
        return service.listarTodos();
    }

    @PutMapping("/api/veiculos/atualizar/{id}")
    public Veiculo atualizar(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        logger.info("Atualizando veículo no controller. ID: " + id + ", Veículo: " + veiculo);
        return service.atualizar(id, veiculo);
    }

    @DeleteMapping("/api/veiculos/deletar/{id}")
    public void deletar(@PathVariable Integer id) {
        logger.info("Deletando veículo no controller. ID: " + id);
        service.deletar(id);
    }
}
