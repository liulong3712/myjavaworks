package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 使用场景：比如现在需要做一个气象站监测系统，要求系统可以随时显示最新的温度，湿度，气压等信息，
 * 已知数据源为WeatherData对象，它会自动从气象站获取数据，现在的工作就是建立一个应用，
 * 利用WeatherData对象取得数据更新布告板显示最新的天气信息；
　　由场景中可知道，变法的信息为天气的状态（温度，湿度，气压），
WeatherData对象负责收集这些信息，所以WeatherData对象可以作为一个状态的发布者（既被观察者），
布告板负责展示这些变化的信息，可以作为观察者。
 * */

/*　　
 * 所以首先声明一个观察者接口，所有的观察者都必须实现这个借口用来接收被观察者推送过来的信息，
这个接口中只有一个update（）方法，用来更新天气状态信息。
*/
interface ObserverInterface {
    public void update(float temp, float humidity, float pressure);
}
/***************
 * 然后是被观察者接口，被观察者接口中可以添加，删除观察者，并可以更新天气状态信息
 * */
interface Subject {
    public void registerObserver(ObserverInterface o);

    public void removeObserver(ObserverInterface o);

    public void notifyObserver();
}

/*
 * 再增加一个布告板显示接口，用来显示天气状态信息，之所以增加这个接口是考虑到以后可能会增加新的
 * 布告板
 * */
interface DisplayElement {
    public void display();
}

/*
 * 下面是被观察者的具体实现
 * */
class WeatherData implements Subject {
    private List<ObserverInterface> observers;//用来存放观察者
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        // TODO Auto-generated constructor stub
        observers = new ArrayList<ObserverInterface>();
    }

    public void registerObserver(ObserverInterface o) {
        // TODO Auto-generated method stub
        observers.add(o);
    }

    public void removeObserver(ObserverInterface o) {
        // TODO Auto-generated method stub
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObserver() {//在这里把状态告诉每一位观察者
        // TODO Auto-generated method stub
        for (int i = 0; i < observers.size(); i++) {
        	ObserverInterface observer = (ObserverInterface) observers.get(i);
        	observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity,
            float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

/*
 * 下面是观察者的具体实现，观察者需要实现Observer和DisplayElement两个接口，
 * 一个用来接收新状态，一个用来显示状态信息。
 * */
class CurrentConditionsDisplay implements ObserverInterface, DisplayElement {
    private float temperature;
    private float humidity;
    @SuppressWarnings("unused")
	private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {//传递个Subject对象是为了以后取消注册方便
        // TODO Auto-generated constructor stub
        this.weatherData = weatherData;
        weatherData.registerObserver(this);//注册成为观察者

    }

    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Current conditios:" + temperature
                + "C degrees and " + humidity + "% humidity");
    }

    public void update(float temp, float humidity, float pressure) {
        // TODO Auto-generated method stub
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

}

public class Observer {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		WeatherData weatherData2 = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData2.registerObserver(currentConditionsDisplay);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData2.setMeasurements(100, 30, 22.2f);
        weatherData2.setMeasurements(100, 40, 22.2f);
	}

}

