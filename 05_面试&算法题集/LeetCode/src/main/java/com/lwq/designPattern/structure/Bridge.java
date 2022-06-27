package com.lwq.designPattern.structure;

/**
 * 桥接模式
 * @author liwenqi
 */
public class Bridge {
    public static void main(String[] args) {
        Color red = new Red();
        Shape circle = new Circle();
        circle.setColor(red);
        circle.draw();

        Color lam = shape -> System.out.println("lam 实现的："+shape);

        circle.setColor(lam);
        circle.draw();
    }
}

abstract class Shape{
    protected Color color;
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * 执行图形绘画
     */
    abstract void draw();
}
class Circle extends Shape{

    @Override
    void draw() {
        color.bgPrint("正方形");
    }
}
interface Color{

    /**
     * 颜色填充
     * @param shape
     */
    void bgPrint(String shape);
}
class Red implements Color{

    @Override
    public void bgPrint(String shape) {
        System.out.println("红色的"+shape);
    }
}