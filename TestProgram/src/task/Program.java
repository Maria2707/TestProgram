package task;

import java.io.*;
import java.util.*;

public class Program {

	public static void main(String[] args) throws IOException {
		File file = new File("C://TEST//file1.txt");
			
		Scanner scanner = new Scanner(file);
		ArrayList<String> strings = new ArrayList<>(); 
		while(scanner.hasNextLine()) {
			strings.add(scanner.nextLine());
		}
		
		System.out.println("File is opened");
		
		instruction(strings);
		
		scanner = new Scanner(System.in);
		File fileToWrite = new File("C://TEST//file2.txt");
		//PrintWriter можно использовать как для вывода информации на консоль, так и в файл или любой другой поток вывода.
		PrintWriter pw = new PrintWriter(fileToWrite);
		for (String string : strings) {
			pw.println(string);
		}
		pw.close();
		System.out.println();
		System.out.println("Текст записан в файл - C://TEST//file2.txt");
		
	}
	
	public static void alphabetSort(ArrayList<String> list) {
		Collections.sort(list);
	}
	
	public static void sortByStringLength(ArrayList<String> list) {
		while(true) {
			int j = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				String str1 = list.get(i);
				String str2 = list.get(i + 1);
				int a = str1.length();
				int b = str2.length();
				if(a > b) {
					list.set(i + 1, str1);
					list.set(i, str2);
					j++;
				}
			}
			if (j==0) break;
		}
	}
	
	public static void argumentSort(ArrayList<String> arr, int sortNumber) {
        while (true) {
            int j = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
                String[] str1 = arr.get(i).split(" ");//целый массив без пробелов
                String[] str2 = arr.get(i + 1).split(" ");
                String st1 = arr.get(i);
                String st2 = arr.get(i + 1);

                char a = str1[sortNumber - 1].charAt(0);//[sortNumber - 1] вычисление нужного номерa, минус 1,т.к. 0 мы вписать НЕ можем (отсчет с единицы)
                char b = str2[sortNumber - 1].charAt(0);//вычисляем позицию нужного слова и с помощью charAt(0) берем только первую букву, чтоб далее отсортировать
                if (a > b) {
                    arr.set(i + 1, st1);
                    arr.set(i, st2);
                    j++;
                }
            }
            if (j == 0) break;
        }
	}
	
	public static void printArrayList(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void printArray(ArrayList<String> list) {
		System.out.println();
		System.out.println("The text is sorted");
		System.out.println();
		
		Map<String,Integer> map = strRepeat(list);
		//еще раз проходимся по ist
		for (String string : list) {
			for(Map.Entry<String, Integer> pair: map.entrySet()) {
				//проверяем - если строка совпадает с ключем (ключ - это тоже строка)
				if(string.equals(pair.getKey())) {
					System.out.println(string + " " + "Длина строки " + string.length() + ". Повторений строки: " + pair.getValue());
				}
			}
		}
		System.out.println();
	}
	
	public static Map<String,Integer> strRepeat(ArrayList<String> list){
		//проверяем какое кол-во раз каждая строчка содержится в list
		Map<String,Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			int j = 0;
			for (String s : list) {
				if(s.equals(list.get(i))) {
					j++;
				}
			}
			map.put(list.get(i), j);
		}
		return map;
	}
	
	public static void instruction(ArrayList<String> list) {
		System.out.println("Start working with file");
		System.out.println("1. Отсортировать текст по алфавиту.");
		System.out.println("2. Отсортировать текст по количеству символов в строке.");
		System.out.println("3. Отсортировать по слову в строке заданному аргументом программы в виде порядкового номера.");
		System.out.println("4. Записать в другой файл и выйти.");
		System.out.println("Please enter number");
		System.out.println();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int num = Integer.parseInt(reader.readLine());
			switch(num) {
			case(1) : 
			{
				alphabetSort(list);
				printArray(list);
				break;
			}
			case(2) :
			{
				sortByStringLength(list);
				printArrayList(list);
				break;
			}
			case(3) :
			{
				System.out.println("Enter the sort number. The number is not zero. \n");
				String s = reader.readLine();
				int arg = Integer.parseInt(s);
				System.out.println("Сортирую по " + arg + " слову.");
				argumentSort(list, arg);
				printArrayList(list);
				break;
			}
			default : 
			{
				break;
			}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
}

/*Условие задачи
Написать консольную программу, которая  сортировала построчный текст,  расположенный  в файле по одному из критериев:
По алфавиту.
По количеству символов в строке.
По слову в строке заданному аргументом программы в виде порядкового номера.

Отсортированный текст должен быть сохранен в другом файле.
Каждая строка в исходном файле должна быть дополнена числом отображающим кол-во повторений данной строки в исходном файле.
Программа должна иметь краткую инструкцию по использованию.

Пример для 3-го варианта сортировки
1. Предположим, что исходный файл содержит строки расположенные в следующем порядке

•  Кошка убегает от собаки
•  Собака пытается догнать кошку
•  Мышка спокойно сидит в своей норе
•  Собака пытается догнать кошку

2. В данном примере, в файле содержащем обработанную информацию в случае если указана сортировка по второму слову(нумерация слов начинается с единицы), строки должны быть расположены в следующем порядке

•  Собака пытается догнать кошку 2
•  Собака пытается догнать кошку 2
•  Мышка спокойно сидит в своей норе 1
•  Кошка убегает от собаки 1*/


