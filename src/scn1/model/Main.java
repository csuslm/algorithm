package scn1.model;
/*
public class Main {
    private static Main instance;
    private void Main(){}
    public static synchronized Main getInstance(){
        if(instance == null){
            instance = new Main();
        }
        return instance;
    }
}*/
//饿汉类一创建就创建单例
/*public class Main {
    private static Main instance = new Main();
    private void Main(){}
    public static  Main getInstance(){
        return instance;
    }
}*/

/*public class Main {
    private static class Singleton {
        private final static Main INSTANCE = new Main();
    }
    private Main(){}
    public static final Main getInstance(){
        return Singleton.INSTANCE;
    }
}*/

public class Main {
    //volatile的作用就是，防止创建对象时，编译器进行指令重拍，将地址分配给对象和初始化重排序，
    private static volatile Main main;
    private Main(){}
    public static Main getInstance(){
        if(main == null){
            synchronized (Main.class){
                if(main == null){
                    main = new Main();
                }
            }
        }
        return main;
    }
}
