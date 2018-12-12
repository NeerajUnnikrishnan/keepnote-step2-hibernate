import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-search-dummy',
  templateUrl: './search-dummy.component.html',
  styleUrls: ['./search-dummy.component.css']
})
export class SearchDummyComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  input='';
  onEnter(data:string){
    this.input=data;
    this.router.navigate(["/search",this.input]);
  }
  goToWishList(){
    this.router.navigate(["/wishlist"]);
  }


}
