import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatDialogModule} from '@angular/material/dialog';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavComponent } from './components/nav/nav.component';
import { SliderComponent } from './components/slider/slider.component';
import { MovieCardComponent } from './components/movie-card/movie-card.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MyPageComponent } from './components/my-page/my-page.component';
import { SearchComponent } from './components/search/search.component';
import { AdminComponent } from './components/admin/admin.component';
import { LoginComponent } from './components/login/login.component';
import { PageComponent } from './components/page/page.component';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
// import { NgxYoutubePlayerModule } from 'ngx-youtube-player';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    SliderComponent,
    MovieCardComponent,
    MyPageComponent,
    SearchComponent,
    AdminComponent,
    LoginComponent,
    PageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    // NgxYoutubePlayerModule // Remove the 'forRoot()' method
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
