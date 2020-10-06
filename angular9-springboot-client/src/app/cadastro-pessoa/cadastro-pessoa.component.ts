import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Pessoa} from '../pessoa';
import {PessoaService} from '../pessoa.service';

@Component({
  selector: 'app-cadastro-pessoa',
  templateUrl: './cadastro-pessoa.component.html',
  styleUrls: ['./cadastro-pessoa.component.css']
})
export class CadastroPessoaComponent implements OnInit {

  pessoa: Pessoa = new Pessoa();
  submitted = false;
  erros = false;

  constructor(private pessoaService: PessoaService,
    private router: Router) { }

  ngOnInit() {
    this.erros = false;
  }

  save() {
    this.pessoaService
    .createPessoa(this.pessoa).subscribe(data => {
      console.log(data)
      this.submitted = true;
      this.erros = false;
      this.pessoa = new Pessoa();
      this.gotoList();
    },
    error => {
      this.erros = true;
      console.log(error);
    });
  }

  onSubmit() {
    this.save();
  }

  gotoList() {
    this.router.navigate(['/pessoas']);
  }
}
