package homework1;

import homework1.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    private final Class<T> type;
    ArrayList<T> content = new ArrayList<>();
    private double weight;

    public Box(Class<T> type) {
        this.type = type;
    }

    void add(T... fruit) {
        content.addAll(Arrays.asList(fruit));
        calculateWeight();
    }

    void calculateWeight() {
        weight = 0;
        content.forEach(fruit->weight += fruit.getWeight());
    }

    double getWeight() {
        return weight;
    }

    boolean compare(Box<? extends Fruit> another) {
        return getWeight() == another.getWeight();
    }

    void fillUpFrom(Box<T> srcBox) {
        content.addAll(srcBox.content);
        calculateWeight();
        srcBox.content.clear();
        srcBox.calculateWeight();
    }

    @Override
    public String toString() {
        String FruitTypeName = type.getName().substring(type.getName().lastIndexOf(".") + 1);
        return ""
        + "FruitBox: {" + '\n'
        + "    type: " + FruitTypeName + '\n'
        + "    count: " + content.size() + '\n'
        + "    weight: " + weight + '\n'
        + "}";
    }
}
