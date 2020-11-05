package theSimplestClassesAndObjects;

/*
2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте конструктор,
инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра класса.
 */

public class Test2 {

    static int numOne;
    static int numTwo;

    Test2(int numberOne, int numberTwo){ //конструктор с входными параметрами

    }

    Test2(){   //конструктор инициализирующий члены класса по умолчанию
        System.out.println(numOne);
        System.out.println(numTwo);
    }

    static int getMethodNumOne(){
        return numOne;
    }

    static void setMethodNumOne(int numberOne){
        numOne = numberOne;
    }

    static int getMethodNumTwo(){
        return numTwo;
    }

    static void setMethodNumTwo(int numberTwo){
        numTwo = numberTwo;
    }


}
