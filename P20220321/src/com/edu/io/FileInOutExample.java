package com.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutExample {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/123.jpg");
			FileOutputStream fos = new FileOutputStream("C:/temp/copy2.jpg");

			int readByte = -1;
			byte[] readBytes = new byte[100];
			while ((readByte = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByte);
			}
			fos.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
}
