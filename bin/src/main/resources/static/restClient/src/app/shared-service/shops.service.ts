import { Injectable } from '@angular/core';
import {Http, Response, Headers,RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
//convert into JSON Format
import 'rxjs/add/operator/map';
//Catch Errors
import 'rxjs/add/operator/catch';
//Add Observable
import 'rxjs/add/observable/throw';


@Injectable()
export class ShopsService {
  private baseUrl:string='http://localhost:8060';
  private headers= new Headers({'Content-Type':'application/json'})
  private options= new RequestOptions({headers:this.headers});
  constructor(private _http:Http) {}

  getSortedshopsId(id :string ) {
    if(id==null) return null;
    return this._http.get(this.baseUrl+"/users/"+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler)
  }
  getPreferedshops(id :string ) {
    if(id==null) return null;
    return this._http.get(this.baseUrl+"/users/"+id+"/preferedshops",this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler)
  }
  like(username :string, shopname: string )
  {
    console.log("fromservice : username "+username+" shopname : "+shopname+ "URL : "+this.baseUrl+"/users/"+username+"/shops/"+shopname+"/like")
    return this._http.post(this.baseUrl+"/users/"+username+"/shops/"+shopname+"/like",this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler)
  }
  dislike(username :string, shopname: string )
  {
    console.log("fromservice : username "+username+" shopname : "+shopname+ "URL : "+this.baseUrl+"/users/"+username+"/shops/"+shopname+"/dislike")
    return this._http.post(this.baseUrl+"/users/"+username+"/shops/"+shopname+"/dislike",this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler)
  }
  remove(username :string, shopname: string )
  {
    console.log("fromservice : username "+username+" shopname : "+shopname+ "URL : "+this.baseUrl+"/users/"+username+"/shops/"+shopname+"/dislike")
    return this._http.delete(this.baseUrl+"/users/"+username+"/preferedshops/"+shopname+"/remove",this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler)
  }
  errorHandler(error:Response){
   return Observable.throw(error||"Server Error");
  }

}
