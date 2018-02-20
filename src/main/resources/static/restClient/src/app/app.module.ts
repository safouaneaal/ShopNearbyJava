import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ShopsComponent } from './components/shops/shops.component';
import {RouterModule, Routes} from '@angular/router';
import { PreferedshopsComponent } from './components/preferedshops/preferedshops.component';
import {FormsModule} from '@angular/forms';
import {ShopsService} from './shared-service/shops.service';
import {HttpModule} from '@angular/http';
import { RegisterComponent } from './components/register/register.component';
import {ShopuserService} from './shared-service/shopuser.service';
import { NavigatorComponent } from './components/navigator/navigator.component';
import {UserService} from './shared-service/user.service';
import {AuthGuard} from './auth.guard';
import { LoginComponent } from './components/login/login.component';
import {PagerService} from "./shared-service/pager.service";

const routes: Routes =
  [{path:'',component:ShopsComponent},
    {path:'users/:code',component:ShopsComponent},
   {path:'users/:code/preferedshops',component:PreferedshopsComponent},
    {path: 'users/:code', canActivate: [AuthGuard], component: ShopsComponent},
    {path:'register',component:RegisterComponent},
    {path:'login',component:LoginComponent},
   {path:'',redirectTo:'register',pathMatch:'full'}]
@NgModule({
  declarations: [
    AppComponent,
    ShopsComponent,
    PreferedshopsComponent,
    RegisterComponent,
    NavigatorComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,FormsModule, RouterModule.forRoot(routes),HttpModule
  ],
  providers: [ShopsService,ShopuserService,UserService, PagerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
