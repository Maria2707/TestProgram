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
		//PrintWriter ����� ������������ ��� ��� ������ ���������� �� �������, ��� � � ���� ��� ����� ������ ����� ������.
		PrintWriter pw = new PrintWriter(fileToWrite);
		for (String string : strings) {
			pw.println(string);
		}
		pw.close();
		System.out.println();
		System.out.println("����� ������� � ���� - C://TEST//file2.txt");
		
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
                String[] str1 = arr.get(i).split(" ");//����� ������ ��� ��������
                String[] str2 = arr.get(i + 1).split(" ");
                String st1 = arr.get(i);
                String st2 = arr.get(i + 1);

                char a = str1[sortNumber - 1].charAt(0);//[sortNumber - 1] ���������� ������� �����a, ����� 1,�.�. 0 �� ������� �� ����� (������ � �������)
                char b = str2[sortNumber - 1].charAt(0);//��������� ������� ������� ����� � � ������� charAt(0) ����� ������ ������ �����, ���� ����� �������������
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
		//��� ��� ���������� �� ist
		for (String string : list) {
			for(Map.Entry<String, Integer> pair: map.entrySet()) {
				//��������� - ���� ������ ��������� � ������ (���� - ��� ���� ������)
				if(string.equals(pair.getKey())) {
					System.out.println(string + " " + "����� ������ " + string.length() + ". ���������� ������: " + pair.getValue());
				}
			}
		}
		System.out.println();
	}
	
	public static Map<String,Integer> strRepeat(ArrayList<String> list){
		//��������� ����� ���-�� ��� ������ ������� ���������� � list
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
		System.out.println("1. ������������� ����� �� ��������.");
		System.out.println("2. ������������� ����� �� ���������� �������� � ������.");
		System.out.println("3. ������������� �� ����� � ������ ��������� ���������� ��������� � ���� ����������� ������.");
		System.out.println("4. �������� � ������ ���� � �����.");
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
				System.out.println("�������� �� " + arg + " �����.");
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

/*������� ������
�������� ���������� ���������, �������  ����������� ���������� �����,  �������������  � ����� �� ������ �� ���������:
�� ��������.
�� ���������� �������� � ������.
�� ����� � ������ ��������� ���������� ��������� � ���� ����������� ������.

��������������� ����� ������ ���� �������� � ������ �����.
������ ������ � �������� ����� ������ ���� ��������� ������ ������������ ���-�� ���������� ������ ������ � �������� �����.
��������� ������ ����� ������� ���������� �� �������������.

������ ��� 3-�� �������� ����������
1. �����������, ��� �������� ���� �������� ������ ������������� � ��������� �������

�  ����� ������� �� ������
�  ������ �������� ������� �����
�  ����� �������� ����� � ����� ����
�  ������ �������� ������� �����

2. � ������ �������, � ����� ���������� ������������ ���������� � ������ ���� ������� ���������� �� ������� �����(��������� ���� ���������� � �������), ������ ������ ���� ����������� � ��������� �������

�  ������ �������� ������� ����� 2
�  ������ �������� ������� ����� 2
�  ����� �������� ����� � ����� ���� 1
�  ����� ������� �� ������ 1*/


