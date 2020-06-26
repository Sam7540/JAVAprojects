package Generics;

import java.io.*;
import java.util.Scanner;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


public class Qrcode 
{
	@SuppressWarnings("resource")
	public static void main(String... args) 
	{
		String details,location;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the text to convert in qr code:");
		details = sc.nextLine();
		System.out.println("Enter the location to save the qrcode:");
		location = sc.nextLine();
		try
		{
			ByteArrayOutputStream out = QRCode.from(details).to(ImageType.PNG).stream();
			FileOutputStream fos = new FileOutputStream(new File(location+"/QR_Code.jpg"));
			fos.write(out.toByteArray());
			fos.flush();
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Your QR code is successfully created at specified location");
	}
}

