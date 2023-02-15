package CDG.GestionEvent.dto;

import CDG.GestionEvent.model.Groupe;

public class UserRegistrationDto {
	private String nom;
	private String prenom;
	private String sexe;
	private String email;
	private String telephone;
	private String password;
	private String DateN;
	private boolean enabled;
	private Groupe groupe;
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDateN() {
		return DateN;
	}


	public void setDateN(String dateN) {
		DateN = dateN;
	}
	

	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public UserRegistrationDto(){
		
	}


	public Groupe getGroupe() {
		return groupe;
	}


	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}


	public UserRegistrationDto(String nom, String prenom, String sexe, String email, String telephone, String password,
			String dateN, boolean enabled, Groupe groupe) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.DateN = dateN;
		this.enabled = enabled;
		this.groupe = groupe;
	}
	
	
}