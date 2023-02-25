package domain;

import java.util.Date;

public class JournalEntry {
	private long id;
	private Date date;
	private long howWasDay;
	private String text1; //Events
	private String text2; //Stresses
	private String text3; //Gratefulness
	private String text4; //Goals
	
	public JournalEntry(long id, Date date, long howWasDay, String text1, String text2, String text3, String text4) {
		super();
		this.id = id;
		this.date = date;
		this.howWasDay = howWasDay;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getHowWasDay() {
		return howWasDay;
	}
	public void setHowWasDay(long howWasDay) {
		this.howWasDay = howWasDay;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getText3() {
		return text3;
	}
	public void setText3(String text3) {
		this.text3 = text3;
	}
	public String getText4() {
		return text4;
	}
	public void setText4(String text4) {
		this.text4 = text4;
	}
}
