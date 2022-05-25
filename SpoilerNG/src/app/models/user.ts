import { UserRank } from "./userrank";

export class User {
    constructor(
        public id:number,
        public firstName:string,
        public lastName:string,
        public username:string,
        public passwd:string,
        public rank:UserRank
    ) { }
}
