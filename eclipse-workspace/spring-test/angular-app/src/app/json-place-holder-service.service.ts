import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JsonPlaceHolderServiceService {

  constructor(private http: HttpClient) { }

  getPost(){
    return this.http.get(environment.backendApiBaseUrl + '/post');
  }

  getCommenti(){
    return this.http.get(environment.backendApiBaseUrl + '/comments');
  }

}
