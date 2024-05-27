import java.util.Scanner;

public class Main{
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Введите вырожение");
         String input = scanner.nextLine();
         try {
             String result = calc(input);
             System.out.println("результат: " + result);
         } catch (Exception e) {
             System.out.println("ошибка: " + e.getMessage());
         }
         scanner.close();
     }
     static String calc(String input) {
         String[] parts = input.split(" ");

         // Validate input
         if (parts.length != 3) {
             throw new IllegalArgumentException("не верный ввод");
         }
         int firstNum;
         int secondNum;
          boolean isRoman;
         try {
             isRoman = Roman.isRoman(parts[0]) && Roman.isRoman(parts[2]) ? true : false;
             firstNum = Roman.isRoman(parts[0]) ? Integer.parseInt(Roman.romanToNumber(parts[0])) : Integer.parseInt(parts[0]);
             secondNum = Roman.isRoman(parts[2]) ? Integer.parseInt(Roman.romanToNumber(parts[2])) : Integer.parseInt(parts[2]);
             if (firstNum<0 || firstNum>10 ||secondNum<0 || secondNum>10){
               throw new NumberFormatException();
             }
         } catch (NumberFormatException e) {
             throw new IllegalArgumentException("неверное число");}
         if ((Roman.isRoman(parts[0]) && !Roman.isRoman(parts[2])) || (!Roman.isRoman(parts[0]) && Roman.isRoman(parts[2]))) {
             throw new IllegalArgumentException("числа могут быть либо латинскими либо арабскими");}
         int result;
         switch (parts[1]) {
             case "+":
                 result = firstNum + secondNum;
                 break;
             case "-":
                 result = firstNum - secondNum;
                 break;
             case "*":
                 result = firstNum * secondNum;
                 break;
             case "/":
                 if (secondNum == 0) {
                     throw new ArithmeticException("деление на ноль");
                 }
                 result = firstNum / secondNum;
                 break;
             default:
                 throw new IllegalArgumentException("недопустимое значяние");
         }
         if (isRoman) {
             return Roman.resultNumberToRoman(result);
         } else {
             return String.valueOf(result);
         }
     }


 }

