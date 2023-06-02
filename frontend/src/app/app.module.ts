import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth/guard/auth.guard';
import { JwtInterceptor } from './auth/helpers/jwt.interceptor';
import { MovieComponent } from './movie/movie.component';
import { CommentComponent } from './comment/comment.component';
import { NavbarComponent } from "./navbar/navbar.component";
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        MovieComponent,
        CommentComponent,
        ReactiveFormComponent,
    ],
    providers: [
        AuthGuard,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: JwtInterceptor,
            multi: true,
        },
    ],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        HttpClientModule,
        NavbarComponent,
        ReactiveFormsModule
    ]
})
export class AppModule {}
