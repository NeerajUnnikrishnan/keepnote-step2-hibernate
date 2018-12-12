import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {appRouteModule} from './app-routes.module'
import { AppComponent } from './app.component';
import {RouterModule,Routes} from '@angular/router';
import {componentsList} from './app-routes.module';
import {HttpClientModule} from '@angular/common/http';
import { ViewMovieComponent } from './view-movie/view-movie.component';
import {MatCardModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MovieService } from './movie.service';
import { SearchDummyComponent } from './search-dummy/search-dummy.component';
import { SearchComponent } from './search/search.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { UpdateComponent } from './update/update.component';


@NgModule({
  declarations: [
    AppComponent,
    componentsList,
    ViewMovieComponent,
    SearchDummyComponent,
    SearchComponent,
    MovieListComponent,
    WishlistComponent,
    UpdateComponent,
  ],
  imports: [
    BrowserModule,
    appRouteModule,
    HttpClientModule,
    MatCardModule,
    BrowserAnimationsModule
  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
