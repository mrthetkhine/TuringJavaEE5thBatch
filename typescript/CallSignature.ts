function hello()
{
    console.log("Hello");
}
hello.data = "Hello";
type Fn = {
    data:string,
    ():void
};
let fn:Fn = hello;
fn();
console.log(fn.data);