package com.JAMgroup.NWTA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klient {

    @Id
    @Column(name = "NrKlienta")
    private int nrKlienta;
    
    @Column(name = "Imie")
    private String imie;
    
    @Column(name = "Nazwisko")
    private String nazwisko;
    
    @Column(name = "Ulica")
    private String ulica;
    
    @Column(name = "NumerDomu")
    private int numerDomu;
    
    @Column(name = "Miasto")
    private String miasto;
    
    @Column(name = "InneDane")
    private String inneDane;
    
    @Column(name = "IdPunktuSprzedazy")
    private int idPunktuSprzedazy;
    
    @Column(name = "KontoLoginKonta")
    private String kontoLoginKonta;
    
    @Column(name = "Opis")
    private String opis;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getNrKlienta() {
        return nrKlienta;
    }

    public void setNrKlienta(int nrKlienta) {
        this.nrKlienta = nrKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getInneDane() {
        return inneDane;
    }

    public void setInneDane(String inneDane) {
        this.inneDane = inneDane;
    }

    public int getIdPunktuSprzedazy() {
        return idPunktuSprzedazy;
    }

    public void setIdPunktuSprzedazy(int idPunktuSprzedazy) {
        this.idPunktuSprzedazy = idPunktuSprzedazy;
    }

    public String getKontoLoginKonta() {
        return kontoLoginKonta;
    }

    public void setKontoLoginKonta(String kontoLoginKonta) {
        this.kontoLoginKonta = kontoLoginKonta;
    }

}
