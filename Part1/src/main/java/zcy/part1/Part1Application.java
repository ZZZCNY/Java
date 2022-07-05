package zcy.part1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class Part1Application {
    
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Part1Application.class, args);
        new Part1Application().selectShape();
    }
    
    public void selectShape() throws IOException {
        System.out.println("请输入形状类型：");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int shapeType = Integer.parseInt(input.readLine());
        Shape shape = ShapeFactory.getShape(shapeType);
        if (shape == null) {
            System.out.println("输入的形状类型不存在");
        } else {
            shape.draw();
        }
    }
    
}
