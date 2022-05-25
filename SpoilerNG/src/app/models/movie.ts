import { HttpService } from "../services/http.service";
http:HttpService;


export class Movie { 
    constructor (
       public id:number,
    public poster_path:string,
    public title:string,
    public overview:string,
    public posterPath:string,
    public release_date:string,
    public key: string
   ){ }
}
