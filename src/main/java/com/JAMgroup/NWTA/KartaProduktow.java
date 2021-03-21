package com.JAMgroup.NWTA;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KartaProduktow {

    @Id
    @Column(name = "NumerKarty")
    private int numerKarty;
    
    @Column(name = "KoszykNumerKoszyka")
    private int koszykNumerKoszyka;
    
    @Column(name = "ProduktIdProduktu")
    private int produktIdProduktu ;
    
    @Column(name = "IloscElementow")
    private int iloscElementow;
    
    @Column(name = "DataDodania")
    private java.sql.Timestamp dataDodania;

    public int getNumerKoszyka() {
        return numerKarty;
    }

    public void setNumerKoszyka(int numerKoszyka) {
        this.numerKarty = numerKoszyka;
    }

    public int getKoszykNumerKoszyka() {
        return koszykNumerKoszyka;
    }

    public void setKoszykNumerKoszyka(int koszykNumerKoszyka) {
        this.koszykNumerKoszyka = koszykNumerKoszyka;
    }

    public int getProduktIdProduktu() {
        return produktIdProduktu;
    }

    public void setProduktIdProduktu(int produktIdProduktu) {
        this.produktIdProduktu = produktIdProduktu;
    }

    public int getIloscElementow() {
        return iloscElementow;
    }

    public void setIloscElementow(int iloscElementow) {
        this.iloscElementow = iloscElementow;
    }

    public Timestamp getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Timestamp dataDodania) {
        this.dataDodania = dataDodania;
    }

}
