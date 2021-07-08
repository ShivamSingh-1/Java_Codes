package collections_project_08_07_2021;

import java.util.*;

public class NewAddress {    //New Structure according to given question
	
	private Structure structure;
	private List<User> ls;
	
	public NewAddress(Structure structure, List<User> ls) {
		this.structure = structure;
		this.setLs(ls);
	}
	public Structure getStructure() {
		return structure;
	}
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	public List<User> getLs() {
		return ls;
	}
	public void setLs(List<User> ls) {
		this.ls = ls;
	}
	

}
