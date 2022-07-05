package zcy.part1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ShapeFactory {
    private static Properties shapes = new Properties();
//    public static final int SHAPE_TYPE_CIRCLE = 1;
//    public static final int SHAPE_TYPE_RECTANGLE = 2;
//    public static final int SHAPE_TYPE_LINE = 3;
//    public static final int SHAPE_TYPE_TRIANGLE = 4;
//
//    private static final Map<Integer, String> shapes = new HashMap<>();
    
    static {
        try {
            InputStream in = ShapeFactory.class.getResourceAsStream("panel.properties");
            shapes.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        shapes.put(SHAPE_TYPE_CIRCLE, "Circle");
//        shapes.put(SHAPE_TYPE_RECTANGLE, "Rectangle");
//        shapes.put(SHAPE_TYPE_LINE, "Line");
//        shapes.put(SHAPE_TYPE_TRIANGLE, "Triangle");
    }
    
    public static Shape getShape(int type) {
        try {
            String className = (String) shapes.get(String.valueOf(type));
            return (Shape) Class.forName(className).newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
