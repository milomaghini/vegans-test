import { Component } from '@angular/core';
import { JsonPlaceHolderServiceService } from './json-place-holder-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  post: any = null;
  commenti: any = null;

  constructor(private service: JsonPlaceHolderServiceService,
              private _snackBar: MatSnackBar){}
  
  logout() {
    window.location.href = '/logout';
  }

  caricaPost(){
    this.service
    .getPost()
    .subscribe((post) => {
      this.post = post;
    }, (error) => {
      this._snackBar.open('Errore durante la comunicazione con il server');
    });
  }

  caricaCommenti(){
    this.service
    .getCommenti()
    .subscribe((commenti) => {
      this.commenti = commenti;
    }, (error) => {
      this._snackBar.open('Errore durante la comunicazione con il server');
    });
  }



}
