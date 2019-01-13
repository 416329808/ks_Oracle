package com.oracle.daomain;

public class Profession {

	private String ProfessionID;
	private String ProfessionPronoun;
	private String ProfessionName;
	private String BelongsInstitutePronoun;
	private String ProfessionIntroduction;
	private int Sequences;
	private String Enables;
	private String Remarks;
	
	public Profession() {
	
	}

	public Profession(String professionID, String professionPronoun, String professionName,
			String belongsInstitutePronoun, String professionIntroduction, int sequences, String enables,
			String remarks) {
		super();
		ProfessionID = professionID;
		ProfessionPronoun = professionPronoun;
		ProfessionName = professionName;
		BelongsInstitutePronoun = belongsInstitutePronoun;
		ProfessionIntroduction = professionIntroduction;
		Sequences = sequences;
		Enables = enables;
		Remarks = remarks;
	}

	public String getProfessionID() {
		return ProfessionID;
	}

	public void setProfessionID(String professionID) {
		ProfessionID = professionID;
	}

	public String getProfessionPronoun() {
		return ProfessionPronoun;
	}

	public void setProfessionPronoun(String professionPronoun) {
		ProfessionPronoun = professionPronoun;
	}

	public String getProfessionName() {
		return ProfessionName;
	}

	public void setProfessionName(String professionName) {
		ProfessionName = professionName;
	}

	public String getBelongsInstitutePronoun() {
		return BelongsInstitutePronoun;
	}

	public void setBelongsInstitutePronoun(String belongsInstitutePronoun) {
		BelongsInstitutePronoun = belongsInstitutePronoun;
	}

	public String getProfessionIntroduction() {
		return ProfessionIntroduction;
	}

	public void setProfessionIntroduction(String professionIntroduction) {
		ProfessionIntroduction = professionIntroduction;
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

