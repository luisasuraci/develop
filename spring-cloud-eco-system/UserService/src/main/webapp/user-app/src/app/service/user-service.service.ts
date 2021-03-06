import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = environment.zuul;
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl+'/users');
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl+'/addUser', user);
  }
}
