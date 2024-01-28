interface Drawable
{
    draw():void;
}
class Circle implements Drawable
{
    _radius:number;

    constructor(radius:number)
    {
        this._radius = radius;
    }
    draw()
    {
        console.log('Draw');
    }
    set radius(value:number)
    {
        console.log('Setter ',value);
        if(value >=0)
        {
            this._radius = value;
        }
    }
    get area()
    {
        console.log('getter');
        return Math.PI* this._radius* this._radius;
    }
}
let c : Circle = new Circle(3);
c.radius = 23;
console.log(c.area);
c.draw();