import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {ShopuserService} from '../../shared-service/shopuser.service';
import {Router} from '@angular/router';
import {ShopsService} from '../../shared-service/shops.service';
import {Shop} from '../../shop';
import {Observable} from 'rxjs/Observable';
import {PreferedshopsComponent} from '../preferedshops/preferedshops.component';

@Component({
  selector: 'app-navigator',
  templateUrl: './navigator.component.html',
  styleUrls: ['./navigator.component.css'],
})
export class NavigatorComponent implements OnInit {
  private shops:Shop[];
  username:string;
  constructor(private shopuser: ShopuserService
  ){}

  get userName():string {
    if(this.shopuser.username==null) return;
    return this.shopuser.username;
 }
  set userName(value:string){
    this.shopuser.username=value;
  }
  ngOnInit() {}

}
