package designpatterns.singleton;

/**
 * ����ʽ������,������ʵ��Ӧ������Ҫ��ͬ��������
 */
class LazySingleton {

    //˽�л����캯������ֹ�ڸ����ⲿͨ��new����ʽ����ʵ��
    private LazySingleton() {
        System.out.println("����LazySingletonʵ��һ�Σ�");
    }

    //˽�еġ���̬��ʵ��������Ϊ˽�еķ�ֹ�ⲿֱ�ӷ��ʸ�ʵ������������Ϊ��̬�ģ�˵����ʵ����LazySingleton���͵�Ψһ��
    //����ʼʱ��û�е��÷���ʵ���ķ�������ôʵ���Ͳ����Լ�����
    private static LazySingleton lazyInstance = null;

    //���еķ��ʵ���ʵ���ķ��������ⲿ���÷��ʸ�ʵ���ķ���ʱ��ʵ���ű�����
    public static LazySingleton getLazyInstance() {
        //��ʵ����û�д������򴴽�ʵ������ʵ���Ѿ��������ˣ���ֱ�ӷ���֮ǰ������ʵ��,�����᷵��2��ʵ��
        if (lazyInstance == null) {
            lazyInstance = new LazySingleton();
        }
        return lazyInstance;
    }
}
/*
 * ����ʽ����
 * */
class NoLazySingleton {

    //˽�л����캯������ֹ�ڸ����ⲿͨ��new����ʽ����ʵ��
    private NoLazySingleton(){
        System.out.println("����NoLazySingletonʵ��һ�Σ�");
    }

    //˽�еġ���̬��ʵ��������Ϊ˽�еķ�ֹ�ⲿֱ�ӷ��ʸ�ʵ������������Ϊ��̬�ģ�˵����ʵ����LazySingleton���͵�Ψһ��
    //��ϵͳ����NoLazySingleton���ļ���ʱ�򣬾ʹ����˸����ʵ��
    private static NoLazySingleton instance = new NoLazySingleton();

    //���еķ��ʵ���ʵ���ķ���
    public static NoLazySingleton getInstance(){
        return instance;
    }
}

public class Singleton {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		 LazySingleton lazyInstance1 = LazySingleton.getLazyInstance();
	     LazySingleton lazyInstance2 = LazySingleton.getLazyInstance();
	     LazySingleton lazyInstance3 = LazySingleton.getLazyInstance();
	     NoLazySingleton instance = NoLazySingleton.getInstance();
	     NoLazySingleton instance1 = NoLazySingleton.getInstance();
	     NoLazySingleton instanc2 = NoLazySingleton.getInstance();
	     NoLazySingleton instanc3 = NoLazySingleton.getInstance();
	}

}
