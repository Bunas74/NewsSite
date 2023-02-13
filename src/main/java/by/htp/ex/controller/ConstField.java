package by.htp.ex.controller;

public enum ConstField {
	
	ID_USER("idUser"), LOGIN("login"), PASSWORD("password"), ROLE("role"),
	
	ID_NEWS("idNews"), TITLE("title"), BRIEF("briefNews"), CONTENT("content"),
	
	LINK("link"), ERROR("error"), GUEST("guest"), ADMIN("admin"), LOCAL("local"),	
	LIST_COUNT(5), COMMAND("command"), PRESENTATION("presentation"), USER("user"),
	NEWS("news");
	
	
	private String valueField;
	private int count;

	private ConstField(String valueFild) {
		this.valueField = valueFild;
	}
	
	private ConstField(int count) {
		this.count = count;
	}

	public String getValueField() {
		return valueField;
	}
	
	public int getCount() {
		return count;
	}

}
