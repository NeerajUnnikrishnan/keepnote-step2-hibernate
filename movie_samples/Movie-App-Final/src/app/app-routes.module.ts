import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import { SearchComponent } from './search/search.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { SearchDummyComponent } from './search-dummy/search-dummy.component';
import { UpdateComponent } from './update/update.component';

const appRoutes:Routes = [
  {path:'movie-list',component:MovieListComponent},
  {path:'search/:input',component:SearchComponent},
  {path:'Wish-List',component: WishlistComponent},
  {path:'update/:imdbId',component: UpdateComponent},
  {path:'**',redirectTo:'/movie-list',pathMatch:'full'},
  {path:'',redirectTo:'/movie-list',pathMatch:'full'}
]

  @NgModule({
    
    imports: [
      RouterModule.forRoot(appRoutes)
    ],
    exports:[
        RouterModule
    ]
  })
  export class appRouteModule{}
  export const componentsList=[SearchComponent,WishlistComponent,SearchComponent,SearchDummyComponent,UpdateComponent];