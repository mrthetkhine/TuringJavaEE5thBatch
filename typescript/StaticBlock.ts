class Demo
{
    static count: number;

    static {
        console.log('static block');
        Demo.count= 0;
    }
}
let d:Demo = new Demo();