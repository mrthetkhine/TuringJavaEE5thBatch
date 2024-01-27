function hello()
{
    console.log("Hello");
}
function display()
{
    console.log("Display");
}
let fn = hello;
fn();
fn = display;
fn();

function add(x:number,y:number)
{
    return x+y;
}
function mult(x:number,y:number)
{
    return x*y;
}
type FnType = (a:number,b:number)=>number;
let fn2:FnType = add;
fn2 =mult;
//fn2 =fn;
console.log(fn2(3,2));