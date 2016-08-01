import { provideRouter, RouterConfig }  from '@angular/router';
import {AboutComponent}  from '../components/about/about.component';
import {LoginComponent}  from '../components/log-in/log-in.component';
import {PostsComponent}  from '../components/posts/posts.component';
import {PostAddComponent}  from '../components/post-add/post-add.component';
import {PostDetailComponent}  from '../components/post-detail/post-detail.component';
import { AuthGuard } from '../services/auth-guard';

export const routes: RouterConfig = [
    {
        path: '',
        redirectTo: '/posts',
        terminal: true
    },
    {
        path: 'about',
        component: AboutComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'posts',
        component: PostsComponent
    },
    {
        path: 'postdetail/:id',
        component: PostDetailComponent
    },
    {
        path: 'add',
        component: PostAddComponent, canActivate: [AuthGuard]
    }
];


export const APP_ROUTER_PROVIDERS = [
  provideRouter(routes), AuthGuard
];
