package net.guides.springboot2.springboot2jpacrudexample.controller;

import net.guides.springboot2.springboot2jpacrudexample.dto.PessoaDTO;
import net.guides.springboot2.springboot2jpacrudexample.enumerator.EnumSexo;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Pessoa;
import net.guides.springboot2.springboot2jpacrudexample.repository.PessoaRepository;
import net.guides.springboot2.springboot2jpacrudexample.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/pessoas")
    public List<PessoaDTO> getTodas() {
        List<PessoaDTO> pessoasDTOS = new ArrayList<>();
        pessoaRepository.findAll().stream().forEach(p -> pessoasDTOS.add(new PessoaDTO(p)));
        return pessoasDTOS;
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable(value = "id") Long pessoaId)
            throws ResourceNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada com o id :: " + pessoaId));
        return ResponseEntity.ok().body(new PessoaDTO(pessoa));
    }

    @PostMapping("/pessoas")
    public ResponseEntity<PessoaDTO> cadastro(@Valid @RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.save(new Pessoa(pessoaDTO));
        return ResponseEntity.ok(new PessoaDTO(pessoa));
    }

    @PutMapping("/pessoas/{id}")
    public ResponseEntity<PessoaDTO> atualiza(@PathVariable(value = "id") Long pessoaId,
                                                   @Valid @RequestBody PessoaDTO dto) throws ResourceNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada com o id :: " + pessoaId));

        pessoa.setCpf(Util.removeMascaraCPF(dto.getCpf()));
        pessoa.setDataNascimento(LocalDate.parse(dto.getDataNascimento().trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        pessoa.setEmail(dto.getEmail());
        pessoa.setNacionalidade(dto.getNacionalidade());
        pessoa.setNaturalidade(dto.getNaturalidade());
        pessoa.setNome(dto.getNome());
        pessoa.setSexo(EnumSexo.getPorSigla(dto.getSexo()));
        final Pessoa updatePessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(new PessoaDTO(updatePessoa));
    }

    @DeleteMapping("/pessoas/{id}")
    public Map<String, Boolean> apaga(@PathVariable(value = "id") Long pessoaId)
            throws ResourceNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada com o id :: " + pessoaId));

        pessoaRepository.delete(pessoa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
