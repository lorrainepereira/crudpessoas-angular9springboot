import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {AtualizaPessoaComponent} from './atualiza-pessoa.component';

describe('AtualizaPessoaComponent', () => {
  let component: AtualizaPessoaComponent;
  let fixture: ComponentFixture<AtualizaPessoaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtualizaPessoaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtualizaPessoaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
