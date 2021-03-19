package com.JAMgroup.NWTA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transakcja {

    @Id
    @Column(name = "KodTransakcji")
    private int kodTransakcji ;
    
    @Column(name = "SumaTransakcji")
    private int sumaTransakcji ;
    
    @Column(name = "IloscProduktow")
    private int iloscProduktow ;
    
    @Column(name = "ProduktIdProduktu")
    private int produktIdProduktu ;
    
    @Column(name = "KlientIdKlienta")
    private int klientIdKlienta ;

    public int getKodTransakcji() {
        return kodTransakcji;
    }

    public void setKodTransakcji(int kodTransakcji) {
        this.kodTransakcji = kodTransakcji;
    }

    public int getSumaTransakcji() {
        return sumaTransakcji;
    }

    public void setSumaTransakcji(int sumaTransakcji) {
        this.sumaTransakcji = sumaTransakcji;
    }

    public int getIloscProduktow() {
        return iloscProduktow;
    }

    public void setIloscProduktow(int iloscProduktow) {
        this.iloscProduktow = iloscProduktow;
    }

    public int getProduktIdProduktu() {
        return produktIdProduktu;
    }

    public void setProduktIdProduktu(int produktIdProduktu) {
        this.produktIdProduktu = produktIdProduktu;
    }

    public int getKlientIdKlienta() {
        return klientIdKlienta;
    }

    public void setKlientIdKlienta(int klientIdKlienta) {
        this.klientIdKlienta = klientIdKlienta;
    }
    
}
