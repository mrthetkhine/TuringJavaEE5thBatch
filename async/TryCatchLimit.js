function asyncFun()
{
    console.log('started');
    setTimeout(()=>{
        console.log("Execute after5 second");
        throw new Error("Excepetion throw");
    },5000);
}
try
{
    asyncFun();
}
catch(e)
{
    console.log('we got error ',e);
}
console.log('Done');