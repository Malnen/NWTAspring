package com.JAMgroup.NWTA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Koszyk {

    @Id
    @Column(name = "NumerKoszyka")
    private int numerKoszyka;
    
    @Column(name = "KontoLoginKonta")
    private String kontoLoginKonta;

    public int getNumerKoszyka() {
        return numerKoszyka;
    }

    public void setNumerKoszyka(int numerKoszyka) {
        this.numerKoszyka = numerKoszyka;
    }

    public String getKontoLoginKonta() {
        return kontoLoginKonta;
    }

    public void setKontoLoginKonta(String kontoLoginKonta) {
        this.kontoLoginKonta = kontoLoginKonta;
    }
}
