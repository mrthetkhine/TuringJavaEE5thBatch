type Human = {
    readonly name :string,
    age:number,
    readonly address: {
        city:string
    }
};
let h :Human = {
    name : 'TK',
    age :39,
    address: {
        city : 'Ygn'
    }
};
let h2 = {
    name : 'TK',
    age :39,
    address : {
        city : 'Mdy'
    }
}
h = h2;
//h.name= "Something";
h.address.city = 'Another'
console.log(h);

interface StringArray {
    [index: number]: string;
}
let arr : StringArray = ['Hello','How'];
console.log(arr);