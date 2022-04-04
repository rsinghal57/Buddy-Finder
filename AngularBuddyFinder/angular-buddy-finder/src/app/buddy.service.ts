import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Buddy } from './buddy';

@Injectable({
  providedIn: 'root'
})
export class BuddyService {

  private baseUrl = "http://localhost:8080/api/buddies";

  constructor(private httpClient: HttpClient) { }

  getBuddiesList(): Observable<Buddy[]>
  {
    return this.httpClient.get<Buddy[]>(`${this.baseUrl}`);
  }

  createBuddy(buddy: Buddy): Observable<Object>
  {
    return this.httpClient.post(`${this.baseUrl}`, buddy);
  }

  getBuddyById(id: number):Observable<Buddy>
  {
    return this.httpClient.get<Buddy>(`${this.baseUrl}/${id}`);
  }

  updateBuddy(id: number, buddy: Buddy): Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`, buddy);
  }

  deleteBuddy(id: number):Observable<Object>
  {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }


}
