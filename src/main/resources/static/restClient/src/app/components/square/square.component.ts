import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-square',
  templateUrl: './square.component.html',
  styleUrls: ['./square.component.css']
})
export class SquareComponent implements OnInit {

  constructor() { }
  a : number;
  ex : number=0;
  u : number = 0;
  n = 100;
  x : number = 0;
  sq :number;
  cof :number=0;
  logText(a: number, n: number): void {
    var i: number;
    this.sq=Math.pow(a,0.5)
    this.retrieve(a);
    this.switching(this.a);
     for(i=0; i<=n; i++)
     this.u = ((this.a-this.ex*this.ex)/(2*this.ex+this.u));
     this.u = ((<number>this.u)*1+ (<number>this.ex)*1)*this.cof*1;

  }
  switching(x : number){

    if(x<4 && x>0) this.ex=1;
    if(x<9 && x>=4) this.ex=2;
    if(x<16 && x>=9) this.ex=3;
    if(x<25 && x>=16) this.ex=4;
    if(x<36 && x>=25) this.ex=5;
    if(x<49 && x>=36) this.ex=6;
    if(x<64 && x>=49) this.ex=7;
    if(x<81 && x>=64) this.ex=8;
    if(x<100 && x>=81) this.ex=9;

  }
  retrieve(a : number){
  this.x=a.toString().length;
    if(this.x==1 || this.x==2)
    {
      this.a==a;
      this.cof = 1;
    }
    if(this.x==3 || this.x==4) {
      this.a=a/100;
      this.cof = 10;
    }
    if(this.x==5 || this.x==6) {
      this.a=a/10000;
      this.cof = 100;
    }
    if(this.x==7 || this.x==8) {
      this.a=a/1000000;
      this.cof = 1000;
    }
  }
  ngOnInit() {


  }

}
