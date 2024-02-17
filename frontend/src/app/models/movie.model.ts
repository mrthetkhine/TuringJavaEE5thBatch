import {Actor} from "./actor.model";

interface MovieDetail
{
  id:null| string;
  details:string;
}
export interface Movie {
  "id"?: string;
  "name": string;
  "year": number;
  "director": string;
  "details":MovieDetail;
  "genres": null|Array<string>;
  "actors":Array<Actor>;
}
