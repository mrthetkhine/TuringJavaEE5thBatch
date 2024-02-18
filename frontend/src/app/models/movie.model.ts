import {Actor} from "./actor.model";

interface MovieDetail
{
  id?:string;
  details:string;
}
export interface Movie {
  "id"?: string;
  "name": string;
  "year": number;
  "director": string;
  "details":MovieDetail;
  "genres"?: Array<string>;
  "actors"?:Array<Actor>;
}
