package model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
public class Biblioteca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idBiblioteca;
	
	private String nome;
	
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "Biblioteca", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Utente> utenti = new TreeSet<Utente>();

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "Biblioteca", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Libro> libri = new HashSet<Libro>();

	//costruttore di default con nome della classe anche se non passo nome argomento del metodo
	public Biblioteca() {
		this.nome="";
	}


	public Biblioteca(String nome) {
		
		this.nome = nome;
	}




	public Biblioteca(long idBiblioteca, String nome, Set<Utente> utenti) {
		
		this.idBiblioteca = idBiblioteca;
		this.nome = nome;
		this.utenti = utenti;
	}


	public long getIdBiblioteca() {
		return idBiblioteca;
	}


	public void setIdBiblioteca(long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Set<Utente> getUtenti() {
		return utenti;
	}


	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
