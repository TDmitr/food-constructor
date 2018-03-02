import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class NgDataJsonserviceService {

  constructor(private http: Http) {
    this.http = http;
  }

  getData(dataUrl) {
    return this.http.get('assets/data/' + dataUrl).map(res => res.json());
  }

}
