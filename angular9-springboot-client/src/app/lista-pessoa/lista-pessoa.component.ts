import { Observable } from "rxjs";
import {  Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import {PessoaService} from '../pessoa.service';
import {Pessoa} from '../pessoa';

@Component({
  selector: "app-lista-pessoa",
  templateUrl: "./lista-pessoa.component.html",
  styleUrls: ["./lista-pessoa.component.css"]
})
export class ListaPessoaComponent implements OnInit {
  pessoas: Observable<Pessoa[]>;

  constructor(private pessoaService: PessoaService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.pessoas = this.pessoaService.getPessoaList();
  }

  deleta(id: number) {
    this.pessoaService.deletePessoa(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  detalhes(id: number){
    this.router.navigate(['detalhes', id]);
  }

  atualiza(id: number){
    this.router.navigate(['atualiza', id]);
  }
}
