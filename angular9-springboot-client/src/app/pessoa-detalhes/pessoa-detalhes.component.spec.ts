import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { PessoaDetalhesComponent } from './pessoa-detalhes.component';

describe('PessoaDetalhesComponent', () => {
  let component: PessoaDetalhesComponent;
  let fixture: ComponentFixture<PessoaDetalhesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PessoaDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
