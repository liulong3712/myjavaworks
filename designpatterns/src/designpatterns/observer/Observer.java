package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * �۲���ģʽ
 * ʹ�ó���������������Ҫ��һ������վ���ϵͳ��Ҫ��ϵͳ������ʱ��ʾ���µ��¶ȣ�ʪ�ȣ���ѹ����Ϣ��
 * ��֪����ԴΪWeatherData���������Զ�������վ��ȡ���ݣ����ڵĹ������ǽ���һ��Ӧ�ã�
 * ����WeatherData����ȡ�����ݸ��²������ʾ���µ�������Ϣ��
�����ɳ����п�֪�����䷨����ϢΪ������״̬���¶ȣ�ʪ�ȣ���ѹ����
WeatherData�������ռ���Щ��Ϣ������WeatherData���������Ϊһ��״̬�ķ����ߣ��ȱ��۲��ߣ���
����帺��չʾ��Щ�仯����Ϣ��������Ϊ�۲��ߡ�
 * */

/*����
 * ������������һ���۲��߽ӿڣ����еĹ۲��߶�����ʵ���������������ձ��۲������͹�������Ϣ��
����ӿ���ֻ��һ��update����������������������״̬��Ϣ��
*/
interface ObserverInterface {
    public void update(float temp, float humidity, float pressure);
}
/***************
 * Ȼ���Ǳ��۲��߽ӿڣ����۲��߽ӿ��п�����ӣ�ɾ���۲��ߣ������Ը�������״̬��Ϣ
 * */
interface Subject {
    public void registerObserver(ObserverInterface o);

    public void removeObserver(ObserverInterface o);

    public void notifyObserver();
}

/*
 * ������һ���������ʾ�ӿڣ�������ʾ����״̬��Ϣ��֮������������ӿ��ǿ��ǵ��Ժ���ܻ������µ�
 * �����
 * */
interface DisplayElement {
    public void display();
}

/*
 * �����Ǳ��۲��ߵľ���ʵ��
 * */
class WeatherData implements Subject {
    private List<ObserverInterface> observers;//������Ź۲���
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

    public void notifyObserver() {//�������״̬����ÿһλ�۲���
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
 * �����ǹ۲��ߵľ���ʵ�֣��۲�����Ҫʵ��Observer��DisplayElement�����ӿڣ�
 * һ������������״̬��һ��������ʾ״̬��Ϣ��
 * */
class CurrentConditionsDisplay implements ObserverInterface, DisplayElement {
    private float temperature;
    private float humidity;
    @SuppressWarnings("unused")
	private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {//���ݸ�Subject������Ϊ���Ժ�ȡ��ע�᷽��
        // TODO Auto-generated constructor stub
        this.weatherData = weatherData;
        weatherData.registerObserver(this);//ע���Ϊ�۲���

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

