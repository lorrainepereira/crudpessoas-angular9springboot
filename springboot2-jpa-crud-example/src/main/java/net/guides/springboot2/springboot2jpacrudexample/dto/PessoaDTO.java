package net.guides.springboot2.springboot2jpacrudexample.dto;

import net.guides.springboot2.springboot2jpacrudexample.model.Pessoa;

import java.time.format.DateTimeFormatter;

public class PessoaDTO {

    private long id;
    private String nome;
    private String email;
    private String dataNascimento;
    private String cpf;
    private String sexo;
    private String nacionalidade;
    private String naturalidade;

    public PessoaDTO(){}

    public PessoaDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.dataNascimento = pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.cpf = pessoa.getCpf();
        this.sexo = pessoa.getSexo().getSigla();
        this.nacionalidade = pessoa.getNacionalidade();
        this.naturalidade = pessoa.getNaturalidade();
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
}
