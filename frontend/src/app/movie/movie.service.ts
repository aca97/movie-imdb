import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  baseUrl: string;

  constructor(
    private http: HttpClient
  ) { 
    this.baseUrl = 'http://localhost:8080/api/v1/movies'
  }

  getMovies(): Observable<any> {
    return this.http.get(`${this.baseUrl}`)
  }

}
