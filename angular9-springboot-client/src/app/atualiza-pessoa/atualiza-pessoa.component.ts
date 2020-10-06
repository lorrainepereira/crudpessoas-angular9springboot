import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Pessoa} from '../pessoa';
import {PessoaService} from '../pessoa.service';

@Component({
  selector: 'app-atualiza-pessoa',
  templateUrl: './atualiza-pessoa.component.html',
  styleUrls: ['./atualiza-pessoa.component.css']
})
export class AtualizaPessoaComponent implements OnInit {

  id: number;
  pessoa: Pessoa;

  constructor(private route: ActivatedRoute,private router: Router,
    private pessoaService: PessoaService) { }

  ngOnInit() {
    this.pessoa = new Pessoa();

    this.id = this.route.snapshot.params['id'];

    this.pessoaService.getPessoa(this.id)
      .subscribe(data => {
        console.log(data)
        this.pessoa = data;
      }, error => console.log(error));
  }

  updatePessoa() {
    this.pessoaService.updatePessoa(this.id, this.pessoa)
      .subscribe(data => {
        console.log(data);
        this.pessoa = new Pessoa();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updatePessoa();
  }

  gotoList() {
    this.router.navigate(['/pessoas']);
  }
}
