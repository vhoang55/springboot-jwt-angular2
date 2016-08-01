import {Router, RouteParams} from '@angular/router';
import {HTTP_PROVIDERS, Response} from "@angular/http";
import {Component, OnInit} from "@angular/core";
import { ActivatedRoute } from '@angular/router';
import {Post} from '../../../app/model/post';
import {PostService} from '../../services/post.service';

@Component({
    selector: 'post-detail',
    templateUrl: '/app/components/post-detail/post-detail.component.html',
    providers: [PostService, HTTP_PROVIDERS]
})
export class PostDetailComponent implements OnInit  {
    post:Post;
    commentShow:boolean;

    constructor(private postService:PostService, private route: ActivatedRoute) {
    }


    ngOnInit() {
        this.commentShow = false;
        this.route.params.subscribe(params => {
            if (params['id'] !== undefined) {
                let id = +params['id'];
                this.postService.getPost(id).subscribe(post => this.post = post);
            }
        });
    }
}