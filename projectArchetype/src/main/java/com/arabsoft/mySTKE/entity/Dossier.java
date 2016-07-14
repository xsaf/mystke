package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Dossier extends AbsDoc {

	@OneToMany(mappedBy = "dossier")
	private Set<AbsDoc> absDocs;
	

	public Dossier() {
		super();
	}

	public Set<AbsDoc> getAbsDocs() {
		return absDocs;
	}

	public void setAbsDocs(Set<AbsDoc> absDoc) {
		this.absDocs = absDoc;
	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub
	}
	
	public void add(AbsDoc absDoc){
		absDoc.niveauAbsDoc = this.niveauAbsDoc + 1;
		absDocs.add(absDoc);
	}
	
	public void remove(AbsDoc absDoc){
		absDocs.remove(absDoc);
	}
	
	

}