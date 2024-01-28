type Tuple =[string,number];
let t:Tuple = ["Hello",12];
console.log('T ',t.length);
console.log('T ',t[0], ' t[1] ',t[1]*2);

function getManyReturn():[string,number,boolean]
{
    return ['Hello',12,false];
}
let [str,num,flag] = getManyReturn();
console.log('Str ',str, ' Num ',num, ' Flag ',flag);