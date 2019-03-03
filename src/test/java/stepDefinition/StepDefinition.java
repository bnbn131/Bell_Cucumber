package stepDefinition;

import cucumber.api.java.ru.*;
import java.util.Scanner;

public class StepDefinition {

    private double a, b, c;
    private String s1, s2;

    @Если("пользователь запускает программу")
    public void пользовательЗапускаетПрограмму() {
        System.out.println("Программа запущена");
    }



    @То("^выводится запрос на ввод первого числа$")
    public void firstNum() {
        System.out.print("Введите первое число: ");
    }

    @Когда("пользователь вводит первое число {string}")
    public void пользовательВводитПервоеЧисло(String test) {
        if (test == null) {
            Scanner scanner = new Scanner(System.in);
            s1 = scanner.next();
        } else {
            s1 = test;
            System.out.println(test);
        }
    }

    @Тогда("^выводится запрос на ввод второго числа$")
    public void secondNum() {
        System.out.print("Введите второе число: ");
    }

    @И("пользователь вводит второе число {string}")
    public void пользовательВводитВтороеЧисло(String test) {
        if (test == null) {
            Scanner scanner = new Scanner(System.in);
            s2 = scanner.next();
        } else {
            s2 = test;
            System.out.println(test);
        }
    }

    @Если("^введены натуральные или вещественные числа$")
    @То("^программа выдает сообщение о введенных неверных числах$")
    public void isDouble() {
        try {
            a = Double.valueOf(s1);
            b = Double.valueOf(s2);
        } catch (Exception e) {
            printErrorMsg();
        }
    }

    @То("^программа складывает их$")
    public void summ() {
        c = a + b;
    }

    @И("^выводит результат на экран$")
    public void result() {
        System.out.println("Результат: " + c);
    }


    private void printErrorMsg() {
        System.out.println("Ошибка. Данные введены не верно");
    }


}
