interface Stack<Type> {
    items: Type[];
}
let s : Stack<string> = {
    items: ["Hello","Hi"]
}
let s2 : Stack<number> = {
    items: [1,2,3]
}
console.log(s);
console.log(s2);