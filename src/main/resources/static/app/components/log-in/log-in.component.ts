import {Component} from "@angular/core";
import {ROUTER_DIRECTIVES, Router, CanActivate} from '@angular/router';
import {LoginService}  from '../../services/log-in.service';

@Component({
    selector: 'log-in',
    templateUrl: '/app/components/log-in/log-in.component.html',
    directives: [ROUTER_DIRECTIVES]
})
export class LoginComponent {

    constructor(private router:Router, private loginService:LoginService) {
    }

    login(event, email, password) {
        event.preventDefault();
        this.loginService.login(email, password)
            .subscribe(() => {
                this.router.navigate(['/add']);
            }, this.handleError);
    }

    logout():void {
        localStorage.removeItem('jwt');
    }


    handleError(error) {
        console.log(error.status);
    }


}