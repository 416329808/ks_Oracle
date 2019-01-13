package com.oracle.daomain;

public class InstitutePronoun {

private	String  InstitutePronoun;
private	String InstituteName;
private	int Sequences;
private	String Enables;
private	String Remarks;




public InstitutePronoun(String institutePronoun, String instituteName, int sequences, String enables, String remarks) {
	super();
	InstitutePronoun = institutePronoun;
	InstituteName = instituteName;
	Sequences = sequences;
	Enables = enables;
	Remarks = remarks;
}

public String getInstitutePronoun() {
	return InstitutePronoun;
}
public void setInstitutePronoun(String institutePronoun) {
	InstitutePronoun = institutePronoun;
}
public String getInstituteName() {
	return InstituteName;
}
public void setInstituteName(String instituteName) {
	InstituteName = instituteName;
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
