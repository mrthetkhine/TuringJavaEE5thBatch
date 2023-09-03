class Engine
{
    void start()
    {
        System.out.println("Engine start");
    }
}
class GasEngine extends Engine
{
    void start()
    {
        System.out.println("Gas engine start");
    }
}
class Car
{
    Engine engine;

    Car(Engine engine)
    {
        this.engine  = engine;
    }
    void start()
    {
        System.out.println("Car start");
        this.engine.start();
    }
}
public class CarClient
{
    public static void main(String[] args) {
        Engine engine = new GasEngine();
        Car car = new Car(engine);
        car.start();
    }
}