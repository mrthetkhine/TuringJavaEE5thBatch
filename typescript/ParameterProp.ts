class Demo
{
    constructor(private name:string)
    {
        
    }
    display()
    {
        console.log('Name ',this.name);
    }
}
let d =new Demo('TK');
d.display();

const someClass = class<Type> {
    content: Type;
    constructor(value: Type) {
      this.content = value;
    }
};
const another = Demo;
d = new another('Another');
d.display();

let some = new someClass<string>('Hello');
console.log(some);