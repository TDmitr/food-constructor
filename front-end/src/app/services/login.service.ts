import {Injectable} from "@angular/core";
import {Observable, Subject} from "rxjs";
import {Http, RequestOptions, RequestOptionsArgs} from "@angular/http";


@Injectable()
export class LoginService {
  private authEvents: Subject<AuthEvent>;
  public API = '//localhost:8080';
  public LOGIN_API = this.API + '/login';

  constructor(private http: Http) {
    this.authEvents = new Subject<AuthEvent>();
  }

  login(credentials: any) {
    let result;
    result = this.http.post(this.LOGIN_API, credentials).toPromise().then(
      res => {
        localStorage.setItem('jwt', res.json().token);
        this.authEvents.next(new DidLogin());
      }
    );
    return result;
  }

  logout(): void {
    localStorage.removeItem('jwt');
    this.authEvents.next(new DidLogout());
  }

  isSignedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }

  get events(): Observable<AuthEvent> {
    return this.authEvents;
  }

}

export class DidLogin {
}
export class DidLogout {
}

export type AuthEvent = DidLogin | DidLogout;
