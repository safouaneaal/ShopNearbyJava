import { Component } from '@angular/core';
import {ShopsComponent} from './components/shops/shops.component';
import {ShopsService} from './shared-service/shops.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {ShopuserService} from './shared-service/shopuser.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
}
