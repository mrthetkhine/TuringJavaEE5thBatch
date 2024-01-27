class Human
{
    name:string;
    constructor(name:string)
    {
        this.name = name;
    }
}
type SomeConstructor = {
    new (s: string): Human;
};
let sig :SomeConstructor = Human;
let obj = new sig('TK');
console.log('Obj ',obj);
