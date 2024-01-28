function sum(...nums:number[])
{
    let total=0;
    nums.forEach(i=>{
        total+= i;
    });
    return total;
}
console.log(sum(1,2));
console.log(sum(1,2,3,4,5,5));

let arr = [1,2,3,4];
console.log(sum(...arr));