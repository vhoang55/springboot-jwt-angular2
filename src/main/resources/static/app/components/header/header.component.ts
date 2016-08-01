import {Component} from "@angular/core";
import { Router, provideRouter, RouterConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS}  from '@angular/router';
import {LoginService}  from '../../services/log-in.service';


@Component({
    selector: 'blog-header',
    templateUrl: '/app/components/header/header.component.html',
    directives: [ROUTER_DIRECTIVES],
    providers: [LoginService]
})
export class HeaderComponent {

    isSignedIn:boolean;

    constructor(private router:Router, private loginService:LoginService) {
        this.isSignedIn = loginService.isSignedIn();
        router.events.subscribe(() => {
            this.isSignedIn = loginService.isSignedIn();
        });
    }

    login(event, email, password) {
        event.preventDefault();
        this.loginService.login(email, password)
            .subscribe(() => {
                this.router.navigate(['/add']);
            }, this.handleError)
        ;
    }

    logout() {
        this.loginService.logout();
        this.router.navigate(['/login']);
    }

    handleError(error) {
        console.log(error.status);
    }
}