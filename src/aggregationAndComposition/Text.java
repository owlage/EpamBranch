package aggregationAndComposition;

/*
1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст,
вывести на консоль текст, заголовок текста.
 */

import java.util.Scanner;

public class Text {
    String header;
    String sentence = "";
    static String strInput;
    static int numInput;

    Text(Word word) {
        header = word.getValue();
    }

    Text(Sentence sentence) {
        this.sentence = sentence.getValue();
    }

    String getHeader() {
        return header;
    }

    void addSentence(Word word) {
        this.sentence += " " + word.getValue();
    }

    void addSentence(Sentence sentence) {
        this.sentence = " " + sentence.getValue();
    }

    String getSentence() {
        return sentence;
    }

    static String getStrInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            strInput = sc.nextLine();
        } else {
            System.out.println("Недопустимый ввод");
            getStrInput();
        }
        return strInput;
    }

    static int getNumInput(){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            numInput = sc.nextInt();
        } else {
            System.out.println("Недопустимый ввод");
            getNumInput();
        }
        return numInput;
    }
}

class Sentence {
    private String value="";

    public void addValue(Word word) {
        value += " " + word.getValue();
    }

    public String getValue() {
        return value;
    }
}

class Word {
    private String value;
    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

class Program{
    public static void main(String[] args) {
        System.out.println("Введите заголовок текста");
        String str = Text.getStrInput();
        Word word = new Word(str);
        Sentence sentence = new Sentence();
        Text text = new Text(word);
        while (true){
        System.out.println("Выберите дейстивие:\n" +
                "1 - дополнить текст\n" +
                "2 - вывести заголовок текста\n" +
                "3 - вывести текст\n" +
                "0 - выход");
        int num = Text.getNumInput();
            if(num == 0){
                break;
            }
            if(num < 1 && num > 3){
                System.out.println("Выберите команду");
                continue;
            }
            switch (num){
                case 1:
                    System.out.println("Введите текст");
                    sentence.addValue(new Word(Text.getStrInput()));
                    text.addSentence(sentence);
                    break;
                case 2:
                    System.out.println("\n" + text.getHeader() + "\n");
                    break;
                case 3:
                    System.out.println("\n" + text.getSentence() + "\n");


            }
        }

    }
}