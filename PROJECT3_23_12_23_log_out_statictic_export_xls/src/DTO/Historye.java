package DTO;

import java.sql.Date;

public class Historye {
	private int id;
	private String name;
	private Date dateOrder;
	private Date dateReturn;
	private int roomNumber;
	private long price;
	
	public Historye() {
		// TODO Auto-generated constructor stub
	}
	
	public Historye(int id, String name, Date dateOrder, Date dateReturn, int roomNumber, long price) {
		this.id = id;
		this.name = name;
		this.dateOrder = dateOrder;
		this.dateReturn = dateReturn;
		this.roomNumber = roomNumber;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
    public Object[] toObject() {
        return new Object[]{""+id, name,dateOrder,dateReturn,""+roomNumber, ""+price};
    }
}
