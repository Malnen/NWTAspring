package com.JAMgroup.NWTA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produkt {

    @Id
    @Column(name = "IdProduktu")
    private int idProduktu;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    @Column(name = "ZdjeciePogladowe")
    private String zdjeciePogladowe;

    @Column(name = "Opis")
    private String opis;

    @Column(name = "Cena")
    private int cena;

    @Column(name = "DzialNumerDzialu")
    private int dzialNumerDzialu;
    @Column(name = "Nazwa")
    private String nazwa;

    public int getIdProduktu() {
        return idProduktu;
    }

    public void setIdProduktu(int idProduktu) {
        this.idProduktu = idProduktu;
    }

    public String getZdjeciePogladowe() {
        return zdjeciePogladowe;
    }

    public void setZdjeciePogladowe(String zdjeciePogladowe) {
        this.zdjeciePogladowe = zdjeciePogladowe;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getDzialNumerDzialu() {
        return dzialNumerDzialu;
    }

    public void setDzialNumerDzialu(int dzialNumerDzialu) {
        this.dzialNumerDzialu = dzialNumerDzialu;
    }

}
