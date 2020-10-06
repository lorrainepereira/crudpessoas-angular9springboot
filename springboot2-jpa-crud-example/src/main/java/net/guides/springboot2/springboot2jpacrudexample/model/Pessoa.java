package net.guides.springboot2.springboot2jpacrudexample.model;

import net.guides.springboot2.springboot2jpacrudexample.dto.PessoaDTO;
import net.guides.springboot2.springboot2jpacrudexample.enumerator.EnumSexo;
import net.guides.springboot2.springboot2jpacrudexample.util.Util;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "pessoa")

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;

    private String nacionalidade;
    private String naturalidade;

    public Pessoa() {}

    public Pessoa(long id, String nome, String email, LocalDate dataNascimento, String nacionalidade, String naturalidade, String cpf, EnumSexo sexo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Pessoa(PessoaDTO dto){
        this.id = dto.getId();
        this.cpf = Util.removeMascaraCPF(dto.getCpf());
        this.dataNascimento = LocalDate.parse(dto.getDataNascimento().trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.email = dto.getEmail();
        this.nacionalidade = dto.getNacionalidade();
        this.naturalidade = dto.getNaturalidade();
        this.nome = dto.getNome();
        this.sexo = EnumSexo.getPorSigla(dto.getSexo());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnumSexo getSexo() {
        return sexo;
    }

    public void setSexo(EnumSexo sexo) {
        this.sexo = sexo;
    }
}
