import { Component, OnInit } from '@angular/core';
import {ShopsService} from '../../shared-service/shops.service';
import {Shop} from '../../shop';
import {ActivatedRoute, Router} from '@angular/router';
import {ShopuserService} from '../../shared-service/shopuser.service';

@Component({
  selector: 'app-preferedshops',
  templateUrl: './preferedshops.component.html',
  styleUrls: ['./preferedshops.component.css']
})
export class PreferedshopsComponent implements OnInit {
  shops:Shop[];
  username: string;
  observer:any;
  constructor(private _shopservice:ShopsService, private shopuser: ShopuserService,private route:ActivatedRoute) {
    this.observer=this.route.params.subscribe(params=>{
      this.username=params['code']
    });
  }

  ngOnInit() {
    if(this._shopservice.getPreferedshops(this.username)==null) return
    this._shopservice.getPreferedshops(this.username).subscribe((shops) => {
      console.log(shops);
      this.shops = shops;
    }, (error) => {
      console.log(error);
    })
  }
  remove(shopname:string){
    for(var i=0;i<this.shops.length;i++)
      if(this.shops[i].name ==shopname) this.shops.splice(i,1);
    console.log("shopname   ::  .."+shopname +" Username "+this.username);
    this._shopservice.remove(this.username,shopname).subscribe((shops) => {}, (error) => {
    });
  }
  get userName():string
  {
    return this.shopuser.username;
  }
  set userName(value:string){
    this.shopuser.username=value;
  }

}
