import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/pessoas';

  constructor(private http: HttpClient) { }

  getPessoa(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createPessoa(pessoa: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, pessoa);
  }

  updatePessoa(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletePessoa(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getPessoaList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
