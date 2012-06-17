package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import domain.Subiect;

@ApplicationScoped
public class SubiectManager {
	
	private List<Subiect> db = new ArrayList<Subiect>();

	public void addSubiect(Subiect subiect) {
		Subiect newSubiect = new Subiect();

		newSubiect.setNumer(subiect.getNumer());
		newSubiect.setName(subiect.getName());

		db.add(newSubiect);
	}

	public void deleteSubiect(Subiect subiect) {
		Subiect subiectToRemove = null;
		for (Subiect s : db) {
			if (subiect.getNumer() == (s.getNumer())) {
				subiectToRemove = s;
				break;
			}
		}
		if (subiectToRemove != null)
			db.remove(subiectToRemove);
	}

	public List<Subiect> getAllSubiect() {
		return db;
	}
}