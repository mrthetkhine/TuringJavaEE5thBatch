let ar: ReadonlyArray<number> = [1,2,3];
//arr[1]= 2;
console.log('Ar ',ar[0]);
let a2 : readonly number[] = [1,2,3];
a2 = [3,3,4];
//a2[0]=2;
console.log(a2);