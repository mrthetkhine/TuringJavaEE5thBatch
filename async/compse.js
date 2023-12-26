function toUpper(str)
{
    return str.toUpperCase();
}
function appendHi(str)
{
    return 'Hi '+ str;
}
/**
 * 
    toUpper(appendHi(x))
 */
function compose(f,g)
{
    return function(x)
    {
        return f(g(x));
    }
}
let newFun = compose(appendHi,toUpper)
//console.log('AppendHi ', appendHi('hello'));
console.log('newFun ', newFun('hello'));