import { XHRBackend } from '@angular/http';
import { bootstrap }      from '@angular/platform-browser-dynamic';
import { HTTP_PROVIDERS } from '@angular/http';
import { provideForms, disableDeprecatedForms } from '@angular/forms';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import { BlogAppComponent } from './components/app/blog-app.component';
import { APP_ROUTER_PROVIDERS } from './routes/blog-app.routes';

import {enableProdMode} from '@angular/core';
enableProdMode();

bootstrap(BlogAppComponent, [
    HTTP_PROVIDERS,
    APP_ROUTER_PROVIDERS,
    [provideForms(),
        disableDeprecatedForms()],
    {provide: LocationStrategy,  useClass: HashLocationStrategy }
]);