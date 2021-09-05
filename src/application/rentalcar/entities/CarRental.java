package application.rentalcar.entities;

import java.util.Date;

public class CarRental {

	private Date start;
	private Date finish;
	
	private ModelVehicle vehicle;
	private Invoice invoice;
	
	public CarRental() {
		
	}

	public CarRental(Date start, Date finish, ModelVehicle vehicle) {
		super();
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public ModelVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(ModelVehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
