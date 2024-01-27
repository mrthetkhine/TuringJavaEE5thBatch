type Human = {
    name: string,
    age? : number
}
function display(obj:Human)
{
    console.log('Name ',obj.name);
}
let data = {
    name : 'Tk',
    //age : 39,
    address : 'Ygn'
};
display(data);