type MyString = string;
let a :MyString = 'Hello';
console.log('A ',a);

interface Point {
    x: number;
    y: number;
}
let point : Point = {
    x: 10,
    y: 20,
    z: 10
};
interface Point{
    z :number
}