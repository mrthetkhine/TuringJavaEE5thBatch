class Human
{
    name : string;
    age :number;

    constructor(name: string,age: number)
    {
        this.name = name;
        this.age = age;
        console.log('Human constructor');
    }
    display()
    {
        console.log('Name ',this.name, ' Age ',this.age);
    }
}
class Teacher extends Human
{
    #school : string;
    constructor(name: string, age : number, school:string)
    {
        super(name,age);
        this.#school = school;
    }
    display(){
        super.display();
        console.log("School ",this.#school);
    }
}
/*
let h: Human = new Human('Tk',39);
h.display();
*/
let h: Teacher = new Teacher('Tk',39,'Turing');
h.display();
//console.log(h.#school);