package kr.or.kosta.blog.message.domain;

public class Message {
	
	private String message_no;
	private String sender;
	private String receiver;
	private String content;
	private String regdate;
	private String hitcount;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String message_no, String sender, String receiver, String content, String regdate, String hitcount) {
		super();
		this.message_no = message_no;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.regdate = regdate;
		this.hitcount = hitcount;
	}
	public String getMessage_no() {
		return message_no;
	}
	public void setMessage_no(String message_no) {
		this.message_no = message_no;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getHitcount() {
		return hitcount;
	}
	public void setHitcount(String hitcount) {
		this.hitcount = hitcount;
	}
	@Override
	public String toString() {
		return "Message [message_no=" + message_no + ", sender=" + sender + ", receiver=" + receiver + ", content="
				+ content + ", regdate=" + regdate + ", hitcount=" + hitcount + "]";
	}
	
	
	


}
