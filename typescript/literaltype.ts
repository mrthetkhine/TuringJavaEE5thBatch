let x: "hello" = "hello";
type Color = "red" | "green" | "blue";
let color : Color = "red";

function doSomething(x: string | null) {
    if (x === null) {
      // do nothing
    } else {
      console.log("Hello, " + x.toUpperCase());
    }
}
doSomething(null);
doSomething('Hello');

function liveDangerously(x?: number | null) {
    // No error
   //console.log(x);
    console.log(x!.toFixed());
  }
liveDangerously(12);