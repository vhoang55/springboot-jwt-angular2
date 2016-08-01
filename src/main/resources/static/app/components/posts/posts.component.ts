import {Component, OnInit} from "@angular/core";
import {Router} from '@angular/router';
import {HTTP_PROVIDERS} from "@angular/http";

import {Post} from '../../../app/model/post';
import {PostService} from '../../services/post.service';


@Component({
    selector: 'my-posts',
    templateUrl: '/app/components/posts/posts.component.html',
    providers: [PostService, HTTP_PROVIDERS]
})

export class PostsComponent implements OnInit {
    posts:Post[];
    errorMessage:string;

    constructor(private router:Router,
                private postsService:PostService) {

    }

    ngOnInit() {
        this.getPosts();
    }

    getPosts() {
        this.postsService.getPosts()
            .subscribe(
            posts => this.posts = posts,
            error => this.errorMessage = <any> error
        );
    }

    gotoDetail(post:Post) {
        let link = ['/postdetail', post.id];
        this.router.navigate(link);
    }
}
