package application.rentalcar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import application.rentalcar.entities.CarRental;
import application.rentalcar.entities.ModelVehicle;
import application.rentalcar.service.BrazilTaxService;
import application.rentalcar.service.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("****** ENTER RENTAL DATA ******");
		System.out.print("CAR MODEL: ");
		String carModel = sc.nextLine();
		System.out.print("PICKUP (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("RETURN (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental carRental = new CarRental(start, finish, new ModelVehicle(carModel));
		
		System.out.println();
		
		System.out.print("ENTER PRICE PER HOUR: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("ENTER PRICE PER DAY: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println();
		
		System.out.println("****** PAYMENT ******");
		System.out.println("INVOICE");
		
		System.out.println();
		
		System.out.println("Basic Payment: " + String.format("%.2f",  carRental.getInvoice().getBasicPayment()));
		
		System.out.println("Tax: " + String.format("%.2f",  carRental.getInvoice().getTax()));
		
		System.out.println("Total Payment: " + String.format("%.2f",  carRental.getInvoice().getTotalPayment()));
		
		sc.close();
	}

}
