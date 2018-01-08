export class Shop {
  id: string;
  name:string;
  email:string;
  picture:string;
  city:string;
  Idlocation:string;
  status : string;

  constructor(data : any){


    this.id = data.id;
    this.name = data.name;
    this.email = data.email;
    this.city = data.city;
    this.status = data.status;
    this.Idlocation = data.Idlocation;

  }

}
