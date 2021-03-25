package com.JAMgroup.NWTA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "zoologicznyPunktSprzedazy")
public class ZoologicznyPunktSprzedazy {

    @Id
    @Column(name = "IdPunktuSprzedazy ")
    private Integer idPunktuSprzedazy;

    @Column(name = "DataPowstania")
    private java.sql.Timestamp dataPowstania;

    @Column(name = "DataOstatniejEdycjiWitryny")
    private java.sql.Timestamp dataOstatniejEdycjiWitryny;

    @Column(name = "TechnologieWykonaniaWitryny")
    private String technologieWykonaniaWitryny;

    @Column(name = "Autorzy")
    private String autorzy;

    @Column(name = "Opis")
    private String opis;

    public Integer getIdPunktuSprzedazy() {
        return idPunktuSprzedazy;
    }

    public void setIdPunktuSprzedazy(Integer idPunktuSprzedazy) {
        this.idPunktuSprzedazy = idPunktuSprzedazy;
    }

    public java.sql.Timestamp getDataPowstania() {
        return dataPowstania;
    }

    public void setDataPowstania(java.sql.Timestamp dataPowstania) {
        this.dataPowstania = dataPowstania;
    }

    public java.sql.Timestamp getDataOstatniejEdycjiWitryny() {
        return dataOstatniejEdycjiWitryny;
    }

    public void setDataOstatniejEdycjiWitryny(java.sql.Timestamp dataOstatniejEdycjiWitryny) {
        this.dataOstatniejEdycjiWitryny = dataOstatniejEdycjiWitryny;
    }

    public String getTechnologieWykonaniaWitryny() {
        return technologieWykonaniaWitryny;
    }

    public void setTechnologieWykonaniaWitryny(String technologieWykonaniaWitryny) {
        this.technologieWykonaniaWitryny = technologieWykonaniaWitryny;
    }

    public String getAutorzy() {
        return autorzy;
    }

    public void setAutorzy(String autorzy) {
        this.autorzy = autorzy;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
