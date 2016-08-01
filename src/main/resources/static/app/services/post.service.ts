import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import { Headers, Http } from '@angular/http';
import "rxjs/Rx";

import {Post} from '../model/post';

@Injectable()
export class PostService {

    private url:string;

    constructor(private http:Http) {
        this.url = 'http://localhost:8080/api/posts';
    }

    getPosts():Observable<Post[]> {
        return this.http.get(this.url, {headers: this.prepareHeaders()})
                        .map(res => res.json())
                        .catch(this.handleError);
    }

    getPost(id):Observable<Post> {
        return this.http.get(this.url + "/" + id, {headers: this.prepareHeaders()})
                        .map(res => res.json())
                        .catch(this.handleError);
    }

    save(post:Post) {
        return this.http.post(this.url, JSON.stringify(post), {headers: this.prepareHeaders()})
                        .catch(this.handleError);
    }

    prepareHeaders(){
        return new Headers({
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'x-auth-token': localStorage.getItem('jwt')
        });
    }

    private handleError(error:Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}
