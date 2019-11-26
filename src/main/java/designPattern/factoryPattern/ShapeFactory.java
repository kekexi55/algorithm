package designPattern.factoryPattern;

/***
 *
 * @author zhengchunguang
 * @date 2019-11-07 10:17
 * 工厂模式
 */
public class ShapeFactory {
    Shape getShape(String shape){
        if("Rectangle".equals(shape)){
            return new Rectangle();
        }
        if("square".equals(shape)){
            return new Square();
        }
        return null;
    }
}
