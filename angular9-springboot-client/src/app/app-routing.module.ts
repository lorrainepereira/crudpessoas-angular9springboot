import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListaPessoaComponent} from './lista-pessoa/lista-pessoa.component';
import {CadastroPessoaComponent} from './cadastro-pessoa/cadastro-pessoa.component';
import {PessoaDetalhesComponent} from './pessoa-detalhes/pessoa-detalhes.component';
import {AtualizaPessoaComponent} from './atualiza-pessoa/atualiza-pessoa.component';

const routes: Routes = [
  { path: '', redirectTo: 'pessoas', pathMatch: 'full' },
  { path: 'pessoas', component: ListaPessoaComponent },
  { path: 'add', component: CadastroPessoaComponent },
  { path: 'atualiza/:id', component: AtualizaPessoaComponent },
  { path: 'detalhes/:id', component: PessoaDetalhesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
