import java.util.Observable;
import java.util.Observer;

class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        setChanged();  
        notifyObservers();  
    }


    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}


class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherStation) {
            WeatherStation weatherStation = (WeatherStation) obs;
            this.temperature = weatherStation.getTemperature();
            this.humidity = weatherStation.getHumidity();
            this.pressure = weatherStation.getPressure();
            display();
        }
    }

    public void display() {
        System.out.println("Current conditions: ");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Pressure: " + pressure + " hPa");
    }
}
public class Weather {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStation);


        weatherStation.setMeasurement(25.5f, 65.0f, 1013.1f);
        weatherStation.setMeasurement(28.3f, 70.0f, 1012.5f);
        weatherStation.setMeasurement(22.0f, 60.0f, 1015.0f);
    }
}
