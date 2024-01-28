interface Colorful {
  color: string;
}
interface Circle {
  radius: number;
}
 
type ColorfulCircle = Colorful & Circle;
let c : ColorfulCircle ={
    color:'red',
    radius:4
}