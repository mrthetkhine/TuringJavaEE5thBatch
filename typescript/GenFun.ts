let arr:any[]= ['Hello',1,2,false];
console.log('Arr ',arr);

function firstElement<Type>(arr: Type[]): Type | undefined {
    return arr[0];
}
console.log(firstElement(['Hello','hi']));
console.log(firstElement([1,2,3]));