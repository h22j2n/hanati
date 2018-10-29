package kr.or.kosta.blog.visitor.domain;

public class Visitor {
	
	private String visitor_id;
	private String visit_date;
	
	public Visitor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Visitor(String visitor_id, String visit_date) {
		super();
		this.visitor_id = visitor_id;
		this.visit_date = visit_date;
	}
	public String getVisitor_id() {
		return visitor_id;
	}
	public void setVisitor_id(String visitor_id) {
		this.visitor_id = visitor_id;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	@Override
	public String toString() {
		return "Visitor [visitor_id=" + visitor_id + ", visit_date=" + visit_date + "]";
	}
	
	
	


}
