package homework1;

//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

//2. Написать метод, который преобразует массив в ArrayList;

//3. Большая задача:
//        +a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        +b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
//        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        +c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        +d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов
//        и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        +e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
//        которую подадут в compare в качестве параметра, true - если их веса равны,
//        false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
//        (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
//        соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
//        которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.

import homework1.fruits.Apple;
import homework1.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        demonstrateGenericSwapElementsFunction();

        demonstrateGenericConvertArrayToArrayListFunction();

        demonstrateGenericFruitBoxFeatures();
    }

    private static void demonstrateGenericFruitBoxFeatures() {
        System.out.println("demonstrateGenericFruitBoxFeatures()");

        Box<Apple> appleBox = new Box<>(Apple.class);
        Box<Orange> orangeBox = new Box<>(Orange.class);

        System.out.println(appleBox);
        appleBox.add(new Apple(), new Apple(), new Apple());
        System.out.println(appleBox);


        System.out.println(orangeBox);
        orangeBox.add(new Orange(), new Orange());
        System.out.println(orangeBox);

        System.out.println("Compare boxes: is their weight equals: " + appleBox.compare(orangeBox));
        appleBox.add(new Apple());
        System.out.println("Compare boxes after weight's changing: is their weight equals: " + appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>(Apple.class);
        appleBox2.add(new Apple(), new Apple());

        System.out.println("Before pouring:");
        System.out.println("Box1 - " + appleBox);
        System.out.println("Box2 - " + appleBox2);
        appleBox.fillUpFrom(appleBox2);
        System.out.println("After pouring:");
        System.out.println("Box1 - " + appleBox);
        System.out.println("Box2 - " + appleBox2);

        System.out.println();
    }

    private static void demonstrateGenericConvertArrayToArrayListFunction() {
        System.out.println("demonstrateGenericConvertArrayToArrayListFunction():");

        System.out.println("Strings:");
        String[] strArray = new String[]{"str0", "str1", "str2", "str3"};
        System.out.println("Array: " + Arrays.toString(strArray));
        ArrayList<String> strArrayList = genericConvertArrayToArrayListFunction(strArray);
        System.out.println("ArrayList: " + strArrayList.toString());

        System.out.println("Integers:");
        Integer[] integerArray = new Integer[]{0, 1, 2, 3};
        System.out.println("Array: " + Arrays.toString(integerArray));
        ArrayList<Integer> IntegerArrayList = genericConvertArrayToArrayListFunction(integerArray);
        System.out.println("ArrayList: " + IntegerArrayList.toString());

        System.out.println("Characters:");
        Character[] charArray = new Character[]{'A', 'B', 'C', 'D'};
        System.out.println("Array: " + Arrays.toString(charArray));
        ArrayList<Character> charArrayList = genericConvertArrayToArrayListFunction(charArray);
        System.out.println("ArrayList: " + charArrayList.toString());

        System.out.println();
    }

    private static <T> ArrayList<T> genericConvertArrayToArrayListFunction(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>(array.length);
        Arrays.stream(array).forEach(element -> arrayList.add(element));

        return arrayList;
    }

    private static void demonstrateGenericSwapElementsFunction() {
        System.out.println("demonstrateGenericSwapElementsFunction():");
        System.out.println("Swap in String[]:");
        String[] strs = new String[]{"str0", "str1", "str2", "str3"};
        System.out.println(Arrays.toString(strs));
        strs = swapElements(strs, 1, 3);
        System.out.println(Arrays.toString(strs));

        System.out.println("Swap in Integer[]:");
        Integer[] ints = new Integer[]{0, 1, 2, 3};
        System.out.println(Arrays.toString(ints));
        ints = swapElements(ints, 0, 1);
        System.out.println(Arrays.toString(ints));

        System.out.println("Swap in Character[]:");
        Character[] chars = new Character[]{'A', 'B', 'C', 'D'};
        System.out.println(Arrays.toString(chars));
        chars = swapElements(chars, 0, 3);
        System.out.println(Arrays.toString(chars));

        System.out.println();
    }

    private static <T> T[] swapElements(T[] array, int index1, int index2) {
        if (array == null || index1 >= array.length || index2 >= array.length || index1 < 0 || index2 < 0) {
            return array;
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        return array;
    }
}
