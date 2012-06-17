package web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import service.SubiectManager;

import domain.Subiect;


@SessionScoped
@Named("subiectBean")
public class SubiectFormBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Subiect subiect = new Subiect();

	private ListDataModel<Subiect> subiects = new ListDataModel<Subiect>();
	
	@Inject
	private SubiectManager sm;

	public Subiect getSubiect() {
		return subiect;
	}

	public void setSubiect(Subiect subiect) {
		this.subiect = subiect;
	}

	public ListDataModel<Subiect> getAllSubiects() {
		subiects.setWrappedData(sm.getAllSubiect());
		return subiects;
	}

	// Actions
	public String addSubiect() {
		sm.addSubiect(subiect);
		return "showSubiects";
	}
	
	public String correctSubiect(){
		return "addSubiect";
	}
	
	public String dataSubiect(){
		return "dataSubiect";
	}

	public String deleteSubiect() {
		Subiect subiectToDelete = subiects.getRowData();
		sm.deleteSubiect(subiectToDelete);
		return null;
	}


}
