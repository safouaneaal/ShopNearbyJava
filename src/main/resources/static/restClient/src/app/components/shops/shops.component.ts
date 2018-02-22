import {Component, Input, OnInit} from '@angular/core';
import {ShopsService} from '../../shared-service/shops.service';
import {Shop} from '../../shop';
import {User} from '../../user';
import {ActivatedRoute, Router} from '@angular/router';
import {ShopuserService} from '../../shared-service/shopuser.service';
import {PagerService} from "../../shared-service/pager.service";

@Component({
  selector: 'app-shops',
  templateUrl: './shops.component.html',
  styleUrls: ['./shops.component.css']
})
export class ShopsComponent implements OnInit {
   shops:Shop[];
   username: string;
   observer:any;
   // pager object
   pager: any = {};

   // paged items
   pagedItems: any[];
  constructor(private _shopservice:ShopsService,
              private route:ActivatedRoute,
              private shopuser: ShopuserService,
              private pagerService: PagerService,
              private _router:Router) {
    this.observer=this.route.params.subscribe(params=>{
    this.username=params['code']
  });}

  ngOnInit() {
    setTimeout(() => {this.userName=this.username;});
    if(this._shopservice.getSortedshopsId(this.username)==null) return
    this._shopservice.getSortedshopsId(this.username).subscribe((shops) => {
      console.log(shops);
      this.shops = shops;
      // initialize to page 1
      this.setPage(1);
    }, (error) => {
      console.log(error);
    })

  }
  like(shopname:string){
    for(var i=0;i<this.shops.length;i++)
      if(this.shops[i].name ==shopname) this.pagedItems.splice(i,1);
      console.log("shopname   ::  .."+shopname +" Username "+this.username);
    this._shopservice.like(this.username,shopname).subscribe((shops) => {}, (error) => {
    });
  }
  dislike(shopname:string){
    for(var i=0;i<this.shops.length;i++)
      if(this.shops[i].name ==shopname) this.pagedItems.splice(i,1);
      console.log("shopname   ::  .."+shopname +" Username "+this.username);
      this._shopservice.dislike(this.username,shopname).subscribe((shops) => {}, (error) => {
    });
  }
  get userName():string{
    return this.username;
  }
  set userName(value:string){
    this.shopuser.username=value;
  }

  setPage(page: number) {
    if (page < 1 || page > this.pager.totalPages) {
      return;
    }

    // get pager object from service
    this.pager = this.pagerService.getPager(this.shops.length, page);

    // get current page of items
    this.pagedItems = this.shops.slice(this.pager.startIndex, this.pager.endIndex + 1);
  }
}
