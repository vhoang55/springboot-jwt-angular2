import {Component, OnInit, Input} from '@angular/core';
import {HTTP_PROVIDERS} from '@angular/http';
import {ROUTER_DIRECTIVES} from '@angular/router';
import {PostService} from "../../services/post.service";
import {Post} from "../../model/post";

@Component({
    selector: 'my-post-add-component',
    templateUrl: '/app/components/post-add/post-add.component.html',
    providers: [PostService,HTTP_PROVIDERS],
    directives: [ROUTER_DIRECTIVES]
})
export class PostAddComponent implements OnInit {

    @Input() post:Post;
    error:any;
    postAdded:boolean;
    data:string;

    constructor(private postService:PostService) {
        this.postAdded = false;
    }

    ngOnInit() {
        this.post = new Post();
    }

    save() {
        this.postService.save(this.post)
            .subscribe(data => this.data = JSON.stringify(data));
        this.postAdded = true;
    }
}