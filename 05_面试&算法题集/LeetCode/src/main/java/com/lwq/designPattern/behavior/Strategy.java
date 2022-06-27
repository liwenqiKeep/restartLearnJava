package com.lwq.designPattern.behavior;

/**
 * 策略模式
 * @author liwenqi
 */
public class Strategy {

    public static void main(String[] args) {
        Context context = new Context(new Dog());
        context.call();


        Context context2 = new Context(() -> System.out.println("嘻嘻嘻"));
        context2.call();
    }
}


interface Animal{
    /**
     * 叫
     */
    void call();
}

class Cat implements Animal{

    /**
     * 叫
     */
    @Override
    public void call() {
        System.out.println("喵喵喵");
    }
}

class Dog implements Animal{

    /**
     * 叫
     */
    @Override
    public void call() {
        System.out.println("汪汪汪");
    }
}

class Context {
    private final Animal animal;
    public Context(Animal animal){
        this.animal = animal;
    }

    public void call(){
        this.animal.call();
    }
}