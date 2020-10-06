package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		try(FileInputStream fin = new FileInputStream("C://TEST//file1.txt");
				FileOutputStream fos = new FileOutputStream("C://TEST//file2.txt"))
		{
			byte[] buffer = new byte[fin.available()];
			
			// ������� ���� � �����
			fin.read(buffer, 0, fin.available());
			
			System.out.println("File data before change: ");
			for (int i = 0; i < buffer.length; i++) {
				//System.out.print((char)buffer[i]);
			}
			
			System.out.println("\nSort by alphabet");
			Arrays.sort(buffer);
			for (int i = 0; i < buffer.length; i++) {
				//System.out.print((char)buffer[i]);
			}
			
			fos.write(buffer, 0, buffer.length);
			
			
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}

//�������� ���������� ���������, �������  ����������� ���������� �����,  �������������  � ����� �� ������ �� ���������:
//�� ��������.
//�� ���������� �������� � ������.
//�� ����� � ������ ��������� ���������� ��������� � ���� ����������� ������.
//
//��������������� ����� ������ ���� �������� � ������ �����.
//������ ������ � �������� ����� ������ ���� ��������� ������ ������������ ���-�� ���������� ������ ������ � �������� �����.
//��������� ������ ����� ������� ���������� �� �������������.

