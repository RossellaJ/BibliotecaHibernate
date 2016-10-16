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
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLibro;

	private String titolo;
	private String autore;
	private String serialNumber;
	private int copieTotali;
	private int copieDisponibili;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "libro", cascade = CascadeType.ALL)//mapped?
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Biblioteca> bibliotecheFollowed = new HashSet<Biblioteca>();

	//costruttori
	
	public Libro(long idLibro, String titolo, String autore,
			String serialNumber, int copieTotali, int copieDisponibili) {
		
		this.idLibro = idLibro;
		this.titolo = titolo;
		this.autore = autore;
		this.serialNumber = serialNumber;
		this.copieTotali = copieTotali;
		this.copieDisponibili = copieDisponibili;
	}

	public Libro() {
		
	}

	
	
	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getCopieTotali() {
		return copieTotali;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}

	public Set<Biblioteca> getBibliotecheFollowed() {
		return bibliotecheFollowed;
	}

	public void setBibliotecheFollowed(Set<Biblioteca> bibliotecheFollowed) {
		this.bibliotecheFollowed = bibliotecheFollowed;
	}
	
	
		
		
		
		

}
