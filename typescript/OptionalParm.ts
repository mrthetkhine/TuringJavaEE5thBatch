function fun(x=10)
{
    console.log('Hello ',x);
}
fun();
fun(20);

function hello(){
    console.log('Hello');
    return 'something';
}
type Fn =()=>void;
let fn:Fn = hello;
console.log(fn());

console.log('Type of ',typeof fn);
let obj ={};
console.log('typeof ',typeof obj);