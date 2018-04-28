import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UserServiceService {
  public API = '//localhost:8080';
  public USER_API = this.API + '/users';

  constructor(private http: HttpClient) { }

  fetch(): Observable<any> {
    return this.http.get(this.USER_API);
  }
  get(id: number) {
    return this.http.get(this.USER_API + '/' + id);
  }
  add(user: any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(this.USER_API, user);
    return result;
  }
}
