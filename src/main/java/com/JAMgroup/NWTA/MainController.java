package com.JAMgroup.NWTA;

import java.util.Map;
import java.util.Optional;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private DzialRepository dzialRepository;

    @Autowired
    private ZoologicznyPunktSprzedazyRepository zoologicznyPunktSprzedazyRepository;

    @Autowired
    private KontoRepository kontoRepository;

    @Autowired
    private KlientRepository klientRepository;

    @Autowired
    private ProduktRepository produktRepository;

    @Autowired
    private TransakcjaRepository transkcjaRepository;

    @Autowired
    private KoszykRepository koszykRepository;

    @Autowired
    private KartaProduktowRepository kartaProduktowRepository;

    @GetMapping(path = "/")
    public @ResponseBody
    String welcome() {
        return "<b>JAMgroup wita :)<b>";
    }

    //Dział
    @PostMapping(path = "/dzial/add")
    public @ResponseBody
    String addNewDzial(@RequestBody Map<String, Object> body) {
        Dzial d = new Dzial();
        d.setNazwa(body.get("nazwa").toString());
        d.setOpis(body.get("opis").toString());
        d.setIdPunktuSprzedazy(Integer.parseInt(body.get("idPunktuSprzedazy").toString()));
        dzialRepository.save(d);
        return "Saved";

    }

    @GetMapping(path = "/dzial/all")
    public @ResponseBody
    Iterable<Dzial> getDzialy() {
        return dzialRepository.findAll();
    }

    @GetMapping(path = "/dzial/{id}/produkt/all")
    public @ResponseBody
    Iterable<Produkt> getAllProduktsInDzial(@PathVariable int id) {
        return produktRepository.findByDzialNumerDzialu(id);
    }

    @PutMapping("/dzial/{id}")
    public Dzial replaceDzial(@RequestBody Map<String, Object> body, @PathVariable int id) {

        return dzialRepository.findById(id)
                .map(dzial -> {
                    dzial.setNazwa(body.get("nazwa").toString());
                    dzial.setOpis(body.get("opis").toString());
                    dzial.setIdPunktuSprzedazy(Integer.parseInt(body.get("idPunktuSprzedazy").toString()));
                    return dzialRepository.save(dzial);
                })
                .orElseGet(() -> {
                    Dzial d = new Dzial();
                    d.setNazwa(body.get("nazwa").toString());
                    d.setOpis(body.get("opis").toString());
                    d.setIdPunktuSprzedazy(Integer.parseInt(body.get("idPunktuSprzedazy").toString()));
                    return dzialRepository.save(d);
                });
    }

    @GetMapping(path = "/dzial/{id}")
    public ResponseEntity<Dzial> getDzialById(@PathVariable("id") int id) {
        Optional<Dzial> opt = dzialRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/dzial/{id}")
    String deleteDzialById(@PathVariable int id) {
        dzialRepository.deleteById(id);
        return "Deleted";
    }

    //Punkt
    @PostMapping(path = "/punkt/add")
    public @ResponseBody
    String addNewPunkt(@RequestBody Map<String, Object> body) {
        ZoologicznyPunktSprzedazy p = new ZoologicznyPunktSprzedazy();
        p.setAutorzy(body.get("autorzy").toString());
        p.setOpis(body.get("opis").toString());
        p.setDataOstatniejEdycjiWitryny(java.sql.Timestamp.valueOf(body.get("dataOstatniejEdycjiWitryny").toString()));
        p.setDataPowstania(java.sql.Timestamp.valueOf(body.get("dataPowstania").toString()));
        p.setTechnologieWykonaniaWitryny(body.get("technologieWykonaniaWitryny").toString());

        zoologicznyPunktSprzedazyRepository.save(p);
        return "Saved";

    }

    @PutMapping("/punkt/{id}")
    public ZoologicznyPunktSprzedazy replacePunkt(@RequestBody Map<String, Object> body, @PathVariable int id) {

        return zoologicznyPunktSprzedazyRepository.findById(id)
                .map(punkt -> {
                    punkt.setAutorzy(body.get("autorzy").toString());
                    punkt.setOpis(body.get("opis").toString());
                    punkt.setDataOstatniejEdycjiWitryny(java.sql.Timestamp.valueOf(body.get("dataOstatniejEdycjiWitryny").toString()));
                    punkt.setDataPowstania(java.sql.Timestamp.valueOf(body.get("dataPowstania").toString()));
                    punkt.setTechnologieWykonaniaWitryny(body.get("technologieWykonaniaWitryny").toString());
                    return zoologicznyPunktSprzedazyRepository.save(punkt);
                })
                .orElseGet(() -> {
                    ZoologicznyPunktSprzedazy p = new ZoologicznyPunktSprzedazy();
                    p.setAutorzy(body.get("autorzy").toString());
                    p.setOpis(body.get("opis").toString());
                    p.setDataOstatniejEdycjiWitryny(java.sql.Timestamp.valueOf(body.get("dataOstatniejEdycjiWitryny").toString()));
                    p.setDataPowstania(java.sql.Timestamp.valueOf(body.get("dataPowstania").toString()));
                    p.setTechnologieWykonaniaWitryny(body.get("technologieWykonaniaWitryny").toString());
                    return zoologicznyPunktSprzedazyRepository.save(p);
                });
    }

    @GetMapping(path = "/punkt/all")
    public @ResponseBody
    Iterable<ZoologicznyPunktSprzedazy> getPunkty() {
        return zoologicznyPunktSprzedazyRepository.findAll();
    }

    @GetMapping(path = "/punkt/{id}")
    public ResponseEntity<ZoologicznyPunktSprzedazy> getZoologicznyPunktSprzedazyById(@PathVariable("id") int id) {
        Optional<ZoologicznyPunktSprzedazy> opt = zoologicznyPunktSprzedazyRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/punkt/{id}")
    String deletePunktById(@PathVariable int id) {
        zoologicznyPunktSprzedazyRepository.deleteById(id);
        return "Deleted";
    }

    //Konto 
    @PostMapping(path = "/konto/add")
    public @ResponseBody
    String addNewKonto(@RequestBody Map<String, Object> body) {
        Konto k = new Konto();
        k.setAwatar(body.get("awatar").toString());
        k.setEmail(body.get("email").toString());
        k.setHaslo(body.get("haslo").toString());
        k.setLogin(body.get("login").toString());
        k.setDataDolaczenia(new Timestamp(System.currentTimeMillis()));
        kontoRepository.save(k);
        return "Saved";

    }

    @PutMapping("/konto/{login}")
    public Konto replaceKonto(@RequestBody Map<String, Object> body, @PathVariable String login) {

        return kontoRepository.findById(login)
                .map(konto -> {
                    konto.setAwatar(body.get("awatar").toString());
                    konto.setEmail(body.get("email").toString());
                    konto.setHaslo(body.get("haslo").toString());
                    konto.setLogin(body.get("login").toString());
                    return kontoRepository.save(konto);
                })
                .orElseGet(() -> {
                    Konto k = new Konto();
                    k.setAwatar(body.get("awatar").toString());
                    k.setEmail(body.get("email").toString());
                    k.setHaslo(body.get("haslo").toString());
                    k.setLogin(body.get("login").toString());
                    return kontoRepository.save(k);
                });
    }

    @GetMapping(path = "/konto/all")
    public @ResponseBody
    Iterable<Konto> getKonta() {
        return kontoRepository.findAll();
    }

    @GetMapping(path = "/konto/{login}")
    public ResponseEntity<Konto> getKontoByLogin(@PathVariable("login") String login) {
        Optional<Konto> opt = kontoRepository.findById(login);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/konto/{login}")
    String deleteKontoByLogin(@PathVariable String login) {
        kontoRepository.deleteById(login);
        return "Deleted";
    }

    //Klient
    @PostMapping(path = "/klient/add")
    public @ResponseBody
    String addNewKlient(@RequestBody Map<String, Object> body) {
        Klient k = new Klient();
        k.setIdPunktuSprzedazy(Integer.parseInt(body.get("idPunktuSprzedazy").toString()));
        k.setImie(body.get("imie").toString());
        k.setNazwisko(body.get("nazwisko").toString());
        k.setInneDane(body.get("inneDane").toString());
        k.setMiasto(body.get("miasto").toString());
        k.setUlica(body.get("ulica").toString());
        k.setNumerDomu(Integer.parseInt(body.get("numerDomu").toString()));
        k.setOpis(body.get("opis").toString());
        k.setKontoLoginKonta(body.get("kontoLoginKonta").toString());
        klientRepository.save(k);
        return "Saved";

    }

    @PutMapping("/klient/{nrKlienta}")
    public Klient replaceKlient(@RequestBody Map<String, Object> body, @PathVariable int nrKlienta) {

        return klientRepository.findById(nrKlienta)
                .map(klient -> {
                    klient.setIdPunktuSprzedazy(Integer.parseInt(body.get("idPunktuSprzedazy").toString()));
                    klient.setImie(body.get("imie").toString());
                    klient.setNazwisko(body.get("nazwisko").toString());
                    klient.setInneDane(body.get("inneDane").toString());
                    klient.setMiasto(body.get("miasto").toString());
                    klient.setUlica(body.get("ulica").toString());
                    klient.setNumerDomu(Integer.parseInt(body.get("numerDomu").toString()));
                    klient.setOpis(body.get("opis").toString());
                    klient.setKontoLoginKonta(body.get("kontoLoginKonta").toString());
                    return klientRepository.save(klient);
                })
                .orElseGet(() -> {
                    Klient k = new Klient();
                    k.setIdPunktuSprzedazy(Integer.parseInt(body.get("idPunktuSprzedazy").toString()));
                    k.setImie(body.get("imie").toString());
                    k.setNazwisko(body.get("nazwisko").toString());
                    k.setInneDane(body.get("inneDane").toString());
                    k.setMiasto(body.get("miasto").toString());
                    k.setUlica(body.get("ulica").toString());
                    k.setNumerDomu(Integer.parseInt(body.get("numerDomu").toString()));
                    k.setOpis(body.get("opis").toString());
                    k.setKontoLoginKonta(body.get("kontoLoginKonta").toString());
                    return klientRepository.save(k);
                });
    }

    @GetMapping(path = "/klient/all")
    public @ResponseBody
    Iterable<Klient> getKlient() {
        return klientRepository.findAll();
    }

    @GetMapping(path = "/klient/{nrKlienta}")
    public ResponseEntity<Klient> getKlientByLogin(@PathVariable("nrKlienta") int nrKlienta) {
        Optional<Klient> opt = klientRepository.findById(nrKlienta);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/klient/{nrKlienta}")
    String deleteKlientByLogin(@PathVariable int nrKlienta) {
        klientRepository.deleteById(nrKlienta);
        return "Deleted";
    }

    //Produkt
    @PostMapping(path = "/produkt/add")
    public @ResponseBody
    String addNewProdukt(@RequestBody Map<String, Object> body) {
        Produkt p = new Produkt();
        p.setCena(Integer.parseInt(body.get("cena").toString()));
        p.setOpis(body.get("opis").toString());
        p.setZdjecieProduktu(body.get("zdjecieProduktu").toString());
        p.setNazwa(body.get("nazwa").toString());
        p.setDzialNumerDzialu(Integer.parseInt(body.get("dzialNumerDzialu").toString()));

        produktRepository.save(p);
        return "Saved";

    }

    @PutMapping("/produkt/{idProduktu}")
    public Produkt replaceProdukt(@RequestBody Map<String, Object> body, @PathVariable int idProduktu) {

        return produktRepository.findById(idProduktu)
                .map(produkt -> {
                    produkt.setCena(Integer.parseInt(body.get("cena").toString()));
                    produkt.setOpis(body.get("opis").toString());
                    produkt.setZdjecieProduktu(body.get("zdjecieProduktu").toString());
                    produkt.setDzialNumerDzialu(Integer.parseInt(body.get("dzialNumerDzialu").toString()));
                    produkt.setNazwa(body.get("nazwa").toString());
                    return produktRepository.save(produkt);
                })
                .orElseGet(() -> {
                    Produkt p = new Produkt();
                    p.setCena(Integer.parseInt(body.get("cena").toString()));
                    p.setOpis(body.get("opis").toString());
                    p.setZdjecieProduktu(body.get("zdjecieProduktu").toString());
                    p.setNazwa(body.get("nazwa").toString());
                    p.setDzialNumerDzialu(Integer.parseInt(body.get("dzialNumerDzialu").toString()));
                    return produktRepository.save(p);
                });
    }

    @GetMapping(path = "/produkt/all")
    public @ResponseBody
    Iterable<Produkt> getProdukt() {
        return produktRepository.findAll();
    }

    @GetMapping(path = "/produkt/{idProduktu}")
    public ResponseEntity<Produkt> getProduktById(@PathVariable("idProduktu") int idProduktu) {
        Optional<Produkt> opt = produktRepository.findById(idProduktu);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/produkt/{idProduktu}")
    String deleteProduktById(@PathVariable int idProduktu) {
        produktRepository.deleteById(idProduktu);
        return "Deleted";
    }

    //Transakcja
    @PostMapping(path = "/transakcja/add")
    public @ResponseBody
    String addNewTransakcja(@RequestBody Map<String, Object> body) {
        Transakcja t = new Transakcja();
        t.setIloscProduktow(Integer.parseInt(body.get("iloscProduktow").toString()));
        t.setKlientIdKlienta(Integer.parseInt(body.get("klientIdKlienta").toString()));
        t.setProduktIdProduktu(Integer.parseInt(body.get("produktIdProduktu").toString()));
        t.setSumaTransakcji(Integer.parseInt(body.get("sumaTransakcji").toString()));

        transkcjaRepository.save(t);
        return "Saved";

    }

    @PutMapping("/transakcja/{kodTransakcji}")
    public Transakcja replaceTransakcja(@RequestBody Map<String, Object> body, @PathVariable int kodTransakcji) {

        return transkcjaRepository.findById(kodTransakcji)
                .map(transakcja -> {
                    transakcja.setIloscProduktow(Integer.parseInt(body.get("iloscProduktow").toString()));
                    transakcja.setKlientIdKlienta(Integer.parseInt(body.get("klientIdKlienta").toString()));
                    transakcja.setProduktIdProduktu(Integer.parseInt(body.get("produktIdProduktu").toString()));
                    transakcja.setSumaTransakcji(Integer.parseInt(body.get("sumaTransakcji").toString()));
                    return transkcjaRepository.save(transakcja);
                })
                .orElseGet(() -> {
                    Transakcja t = new Transakcja();
                    t.setIloscProduktow(Integer.parseInt(body.get("iloscProduktow").toString()));
                    t.setKlientIdKlienta(Integer.parseInt(body.get("klientIdKlienta").toString()));
                    t.setProduktIdProduktu(Integer.parseInt(body.get("produktIdProduktu").toString()));
                    t.setSumaTransakcji(Integer.parseInt(body.get("sumaTransakcji").toString()));
                    return transkcjaRepository.save(t);
                });
    }

    @GetMapping(path = "/transakcja/all")
    public @ResponseBody
    Iterable<Transakcja> getTransakcja() {
        return transkcjaRepository.findAll();
    }

    @GetMapping(path = "/transakcja/{kodTransakcji}")
    public ResponseEntity<Transakcja> getTransakcjaById(@PathVariable("kodTransakcji") int kodTransakcji) {
        Optional<Transakcja> opt = transkcjaRepository.findById(kodTransakcji);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/transakcja/{kodTransakcji}")
    String deleteTransakcjaById(@PathVariable int kodTransakcji) {
        transkcjaRepository.deleteById(kodTransakcji);
        return "Deleted";
    }

    //Koszyk
    @PostMapping(path = "/koszyk/add")
    public @ResponseBody
    String addNewKoszyk(@RequestBody Map<String, Object> body) {
        Koszyk k = new Koszyk();
        k.setKontoLoginKonta(body.get("kontoLoginKonta").toString());

        koszykRepository.save(k);
        return "Saved";

    }

    @PutMapping("/koszyk/{kontoLoginKonta}")
    public Koszyk replaceKoszyk(@RequestBody Map<String, Object> body, @PathVariable String kontoLoginKonta) {

        return koszykRepository.findByKontoLoginKonta(kontoLoginKonta)
                .map(koszyk -> {
                    koszyk.setNumerKoszyka(Integer.parseInt(body.get("numerKoszyka").toString()));
                    return koszykRepository.save(koszyk);
                })
                .orElseGet(() -> {
                    Koszyk k = new Koszyk();
                    k.setNumerKoszyka(Integer.parseInt(body.get("numerKoszyka").toString()));
                    k.setKontoLoginKonta(body.get("kontoLoginKonta").toString());
                    return koszykRepository.save(k);
                });
    }

    @GetMapping(path = "/koszyk/all")
    public @ResponseBody
    Iterable<Koszyk> getKoszyk() {
        return koszykRepository.findAll();
    }

    @GetMapping(path = "/koszyk/{kontoLoginKonta}")
    public ResponseEntity<Koszyk> getKoszykById(@PathVariable("kontoLoginKonta") String kontoLoginKonta) {
        Optional<Koszyk> opt = koszykRepository.findByKontoLoginKonta(kontoLoginKonta);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/koszyk/{kodTransakcji}")
    String deleteKoszykById(@PathVariable int kodTransakcji) {
        koszykRepository.deleteById(kodTransakcji);
        return "Deleted";
    }

    // KartaProduktow
    @PostMapping(path = "/kartaProduktow/add")
    public @ResponseBody
    String addNewKartaProduktow(@RequestBody Map<String, Object> body) {
        KartaProduktow k = new KartaProduktow();
        k.setIloscElementow(Integer.parseInt(body.get("iloscElementow").toString()));
        k.setKoszykNumerKoszyka(Integer.parseInt(body.get("koszykNumerKoszyka").toString()));
        k.setProduktIdProduktu(Integer.parseInt(body.get("produktIdProduktu").toString()));
        k.setDataDodania(java.sql.Timestamp.valueOf(body.get("dataDodania").toString()));
        kartaProduktowRepository.save(k);
        return "Saved";

    }

    @PutMapping("/kartaProduktow/{numerKoszyka}")
    public KartaProduktow replaceKartaProduktow(@RequestBody Map<String, Object> body, @PathVariable int numerKoszyka) {

        return kartaProduktowRepository.findById(numerKoszyka)
                .map(koszyk -> {

                    koszyk.setIloscElementow(Integer.parseInt(body.get("iloscElementow").toString()));
                    koszyk.setKoszykNumerKoszyka(Integer.parseInt(body.get("koszykNumerKoszyka").toString()));
                    koszyk.setProduktIdProduktu(Integer.parseInt(body.get("produktIdProduktu").toString()));
                    koszyk.setDataDodania(java.sql.Timestamp.valueOf(body.get("dataDodania").toString()));
                    return kartaProduktowRepository.save(koszyk);
                })
                .orElseGet(() -> {
                    KartaProduktow k = new KartaProduktow();
                    k.setIloscElementow(Integer.parseInt(body.get("iloscElementow").toString()));
                    k.setKoszykNumerKoszyka(Integer.parseInt(body.get("koszykNumerKoszyka").toString()));
                    k.setProduktIdProduktu(Integer.parseInt(body.get("produktIdProduktu").toString()));
                    k.setDataDodania(java.sql.Timestamp.valueOf(body.get("dataDodania").toString()));
                    return kartaProduktowRepository.save(k);
                });
    }

    @GetMapping(path = "/kartaProduktow/all")
    public @ResponseBody
    Iterable<KartaProduktow> getKartaProduktow() {
        return kartaProduktowRepository.findAll();
    }

    @GetMapping(path = "/kartaProduktow/{numerKoszyka}")
    public @ResponseBody
    Iterable<KartaProduktow> getKartaProduktowByKoszykId(@PathVariable("numerKoszyka") int numerKoszyka) {
        return kartaProduktowRepository.findByKoszykNumerKoszyka(numerKoszyka);
    }

    @DeleteMapping("/kartaProduktow/{numerKarty}")
    String deleteKartaProduktowById(@PathVariable int numerKarty) {
        kartaProduktowRepository.deleteById(numerKarty);
        return "Deleted";
    }
    
    @DeleteMapping("/kartaProduktow/deleteProdukty/{numerKarty}")
    String deleteProduktyByKartaProduktowId(@PathVariable int numerKarty) {
        kartaProduktowRepository.deleteByKoszykNumerKoszyka(numerKarty);
        return "Deleted";
    }
}
