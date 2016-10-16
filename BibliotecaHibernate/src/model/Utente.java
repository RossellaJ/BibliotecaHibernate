package model;

import java.util.HashSet;
import java.util.Set;

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
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUtente;
	
	private String nome;
	private String cognome;
	private int numeroPrestiti;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "utente", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Biblioteca> bibliotecheFollowed = new HashSet<Biblioteca>();

	
	
	
	
	
	
	
	//costruttori
	
	public Utente() {
		
	}

	public Utente(long idUtente, String nome, String cognome, int numeroPrestiti) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroPrestiti = numeroPrestiti;
	}

	public long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getNumeroPrestiti() {
		return numeroPrestiti;
	}

	public void setNumeroPrestiti(int numeroPrestiti) {
		this.numeroPrestiti = numeroPrestiti;
	}

	public Set<Biblioteca> getBibliotecheFollowed() {
		return bibliotecheFollowed;
	}

	public void setBibliotecheFollowed(Set<Biblioteca> bibliotecheFollowed) {
		this.bibliotecheFollowed = bibliotecheFollowed;
	}
	
	
	

}
