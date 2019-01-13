package com.oracle.daomain;

public class Classe {

	
	private String ClassesID;
	private String ClassesName;
	private String BelongsProfessionPronoun;
	private String BelongsInstitutePronoun;
	private int Sequences;
	private String Enables;
	private String Remarks;
	public Classe() {
		
	}
	public Classe(String classesID, String classesName, String belongsProfessionPronoun, String belongsInstitutePronoun,
			int sequences, String enables, String remarks) {
		super();
		ClassesID = classesID;
		ClassesName = classesName;
		BelongsProfessionPronoun = belongsProfessionPronoun;
		BelongsInstitutePronoun = belongsInstitutePronoun;
		Sequences = sequences;
		Enables = enables;
		Remarks = remarks;
	}
	public String getClassesID() {
		return ClassesID;
	}
	public void setClassesID(String classesID) {
		ClassesID = classesID;
	}
	public String getClassesName() {
		return ClassesName;
	}
	public void setClassesName(String classesName) {
		ClassesName = classesName;
	}
	public String getBelongsProfessionPronoun() {
		return BelongsProfessionPronoun;
	}
	public void setBelongsProfessionPronoun(String belongsProfessionPronoun) {
		BelongsProfessionPronoun = belongsProfessionPronoun;
	}
	public String getBelongsInstitutePronoun() {
		return BelongsInstitutePronoun;
	}
	public void setBelongsInstitutePronoun(String belongsInstitutePronoun) {
		BelongsInstitutePronoun = belongsInstitutePronoun;
	}
	public int getSequences() {
		return Sequences;
	}
	public void setSequences(int sequences) {
		Sequences = sequences;
	}
	public String getEnables() {
		return Enables;
	}
	public void setEnables(String enables) {
		Enables = enables;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	
	
	
	
	
	
	
}
