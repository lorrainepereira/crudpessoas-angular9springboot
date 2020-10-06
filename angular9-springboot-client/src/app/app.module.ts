import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {CadastroPessoaComponent} from './cadastro-pessoa/cadastro-pessoa.component';
import {ListaPessoaComponent} from './lista-pessoa/lista-pessoa.component';
import {PessoaDetalhesComponent} from './pessoa-detalhes/pessoa-detalhes.component';
import {AtualizaPessoaComponent} from './atualiza-pessoa/atualiza-pessoa.component';
import {IConfig, NgxMaskModule} from 'ngx-mask';


export const options: Partial<IConfig> | (() => Partial<IConfig>) = null;

@NgModule({
  declarations: [
    AppComponent,
    CadastroPessoaComponent,
    ListaPessoaComponent,
    PessoaDetalhesComponent,
    AtualizaPessoaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxMaskModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
