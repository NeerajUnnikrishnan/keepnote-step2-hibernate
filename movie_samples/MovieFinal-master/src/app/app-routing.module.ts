import { WishlistComponent } from './wishlist/wishlist.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import { MovieListComponent } from './movie-list/movie-list.component';
import { SearchComponent } from './search/search.component';

import {Router} from '@angular/router';
const routes: Routes = [
  {path:'movie-list',component:MovieListComponent},
  {path:'search/:input',component:SearchComponent},
  {path:'**',component:MovieListComponent},
  {path:'',component:MovieListComponent},
  {path:'wishlist',component:WishlistComponent}

]
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports:[RouterModule]
})
export class AppRoutingModule { }
