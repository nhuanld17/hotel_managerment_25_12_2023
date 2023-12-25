package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Historye;

public class HistoryDAO {
	public ArrayList<Historye> listHistory() {
		try {
			ArrayList<Historye> result = new ArrayList<Historye>();
			ResultSet resultSet = new DBConn().queryDB("SELECT * FROM history");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Date dateOrder = resultSet.getDate("dateOrder");
				Date dateReturn = resultSet.getDate("dateReturn");
				int roomNumber = resultSet.getInt("roomNumber");
				long price = resultSet.getLong("price");
				
				result.add(new Historye(id, name, dateOrder, dateReturn, roomNumber, price));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Historye>();
	}
	public void addHistory(Historye history) {
		try {
			new DBConn().updateDB("INSERT INTO history(id, name, dateOrder, dateReturn, roomNumber, price) VALUES('"+history.getId()+"','"+history.getName()+"', '"+history.getDateOrder()+"','"+history.getDateReturn()+"','"+history.getRoomNumber()+"','"+history.getPrice()+"')");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"");
		}
	}
	public long totalPrice() {
		long TotalPrice = 0;
		try {
			ResultSet resultSet = new DBConn().queryDB("SELECT SUM(price) FROM history");
			while (resultSet.next()) {
				TotalPrice = resultSet.getLong("SUM(price)");
			}
			return TotalPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TotalPrice;
	}
	public long totalPrice(Date date_1, Date date_2) {
		long TotalPrice = 0;
		try {
			ResultSet resultSet = new DBConn().queryDB("SELECT SUM(price) FROM history WHERE dateReturn BETWEEN '"+date_1+"' AND '"+date_2+"'");
			while (resultSet.next()) {
				TotalPrice = resultSet.getLong("SUM(price)");
			}
			return TotalPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TotalPrice;
	}
}
