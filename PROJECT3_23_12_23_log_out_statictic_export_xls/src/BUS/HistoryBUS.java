package BUS;

import java.sql.Date;
import java.util.ArrayList;

import DAO.HistoryDAO;
import DTO.Historye;

public class HistoryBUS {
	public ArrayList<Historye> listHistories() {
		return new HistoryDAO().listHistory();
	}
	public void addHistory(Historye history) {
		new HistoryDAO().addHistory(history);
	}
	public long totalPrice() {
		return new HistoryDAO().totalPrice();
	}
	public long totalPrice(Date date_1, Date date_2) {
		return new HistoryDAO().totalPrice(date_1, date_2);
	}
}
