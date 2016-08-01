import { Component, OnInit, Input } from '@angular/core';
import { Router, provideRouter, RouterConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS}  from '@angular/router';
import {FooterComponent} from '../../components/footer/footer.component';
import {HeaderComponent} from '../../components/header/header.component';
//import {AboutComponent}  from '../../components/about/about.component'
import {LoginService}  from '../../services/log-in.service';
//import {AuthGuard} from '../../services/auth-guard';

@Component({
    selector: 'blog-app',
    templateUrl: '/app/components/app/blog-app.component.html',
    directives: [HeaderComponent ,FooterComponent, ROUTER_DIRECTIVES],
    providers: [LoginService]
})
export class BlogAppComponent {}
