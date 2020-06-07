package cartoleria;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ordine {
	private  int codiceOrdine,prodottoID,qta, scontoApplicato; //tab ordini
	private GregorianCalendar date;// tab ordini
	private float prezzoFinale;// tab ordini
	
	private String nomeProdotto,produttore,cognome,nome;
	private float prezzoProdotto,peso, spesaAttuale;

	
	

	public Ordine(int codiceOrdine, int prodottoID, int qta, int scontoApplicato, GregorianCalendar date,
			float prezzoFinale, String nomeProdotto, String produttore, float prezzoProdotto, float peso, String cognome, String nome, float spesaAttuale) {
		super();
		this.codiceOrdine = codiceOrdine;
	
		this.prodottoID = prodottoID;
		this.qta = qta;
		this.scontoApplicato = scontoApplicato;
		this.date = date;
		this.prezzoFinale = prezzoFinale;
		this.nomeProdotto = nomeProdotto;
		this.produttore = produttore;
		this.prezzoProdotto = prezzoProdotto;
		this.peso = peso;
		this.cognome=cognome;
		this.nome=nome;
		this.spesaAttuale=spesaAttuale;
	}

	public float getSpesaAttuale() {
		return spesaAttuale;
	}

	public void setSpesaAttuale(float spesaAttuale) {
		this.spesaAttuale = spesaAttuale;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ordine() {
		super();
	}

	public int getCodiceOrdine() {
		return codiceOrdine;
	}

	public void setCodiceOrdine(int codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}
	

	public String getProduttore() {
		return produttore;
	}

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}


	

	public int getScontoApplicato() {
		return scontoApplicato;
	}

	public void setScontoApplicato(int scontoApplicato) {
		this.scontoApplicato = scontoApplicato;
	}

	public float getPrezzoFinale() {
		return prezzoFinale;
	}

	public void setPrezzoFinale(float prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public float getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(float prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public int getProdottoID() {
		return prodottoID;
	}

	public void setProdottoID(int prodottoID) {
		this.prodottoID = prodottoID;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public GregorianCalendar setDate(GregorianCalendar date) {
		
		return this.date = date;
	}
	
	public  String format(GregorianCalendar date) {
	    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
	    fmt.setCalendar(date);
	    String dateFormatted = fmt.format(date.getTime());
	    return dateFormatted;
	}

	
}
