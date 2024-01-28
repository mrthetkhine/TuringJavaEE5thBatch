/*function display(obj:{x:number,y:number})
{
    console.log("Obj ",obj.x, " Y ",obj.y);
}
*/
function display({x,y}:{
    x:number,
    y:number
})
{
    console.log("Obj ",x, " Y ",y);
}
display({
    x: 10,
    y : 20
});
