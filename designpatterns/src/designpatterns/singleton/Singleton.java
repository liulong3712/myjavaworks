package designpatterns.singleton;

/**
 * 懒汉式单例类,这种在实际应用中需要加同步锁处理
 */
class LazySingleton {

    //私有化构造函数，防止在该类外部通过new的形式创建实例
    private LazySingleton() {
        System.out.println("生成LazySingleton实例一次！");
    }

    //私有的、静态的实例，设置为私有的防止外部直接访问该实例变量，设置为静态的，说明该实例是LazySingleton类型的唯一的
    //若开始时，没有调用访问实例的方法，那么实例就不会自己创建
    private static LazySingleton lazyInstance = null;

    //公有的访问单例实例的方法，当外部调用访问该实例的方法时，实例才被创建
    public static LazySingleton getLazyInstance() {
        //若实例还没有创建，则创建实例；若实例已经被创建了，则直接返回之前创建的实例,即不会返回2个实例
        if (lazyInstance == null) {
            lazyInstance = new LazySingleton();
        }
        return lazyInstance;
    }
}
/*
 * 饥汉式单例
 * */
class NoLazySingleton {

    //私有化构造函数，防止在该类外部通过new的形式创建实例
    private NoLazySingleton(){
        System.out.println("创建NoLazySingleton实例一次！");
    }

    //私有的、静态的实例，设置为私有的防止外部直接访问该实例变量，设置为静态的，说明该实例是LazySingleton类型的唯一的
    //当系统加载NoLazySingleton类文件的时候，就创建了该类的实例
    private static NoLazySingleton instance = new NoLazySingleton();

    //公有的访问单例实例的方法
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
