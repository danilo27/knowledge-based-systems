package com;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.Disease;
import com.model.DiseaseHistory;
import com.model.Drug;
import com.model.Ingredient;
import com.model.Patient;
import com.model.Symptom;
import com.model.User;
import com.repositories.DiseasesRepo;
import com.repositories.DrugRepo;
import com.repositories.HistoryRepo;
import com.repositories.IngredientRepo;
import com.repositories.PatientRepo;
import com.repositories.SymptomRepo;
import com.repositories.UserRepo;

@SpringBootApplication

public class SbzApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SbzApplication.class, args);
	}
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PatientRepo patRepo;
	
	@Autowired
	DrugRepo drugRepo;
	
	@Autowired
	DiseasesRepo disRepo;
	
	@Autowired
	HistoryRepo histRepo;
	
	@Autowired
	IngredientRepo ingRepo;
	
	@Autowired
	SymptomRepo sympRepo;
	
	@Override
	public void run(String... args) throws Exception {
		data();
	}
	
	public void data(){
		userRepo.deleteAll();
		patRepo.deleteAll();
		drugRepo.deleteAll();
		disRepo.deleteAll();
		histRepo.deleteAll();
		ingRepo.deleteAll();
		
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setType("admin");
		userRepo.save(admin);
		
		User doc = new User();
		doc.setUsername("doc");
		doc.setPassword("doc");
		doc.setFirstname("Danilo");
		doc.setLastname("Bujisa");
		doc.setLicenceId("4323");
		doc.setType("doctor");
		userRepo.save(doc);
		
		Patient pat1 = new Patient((Long)patRepo.count(), "Mitar", "Miric", new ArrayList<Ingredient>(), new ArrayList<DiseaseHistory>()); 
		Patient pat2 = new Patient((Long)patRepo.count(), "Boris", "Brejcha", new ArrayList<Ingredient>(), new ArrayList<DiseaseHistory>());
		Patient pat3 = new Patient((Long)patRepo.count(), "Yoel", "Romero", new ArrayList<Ingredient>(), new ArrayList<DiseaseHistory>()); 
		patRepo.save(pat1);
		patRepo.save(pat2);
		patRepo.save(pat3);
		
		Drug drug1 = new Drug((Long)drugRepo.count(),"Panadol Extra", "Analgetik", new ArrayList<Ingredient>());
		Drug drug2 = new Drug((Long)drugRepo.count(),"Penicilin", "Antibiotik", new ArrayList<Ingredient>());
		Drug drug3 = new Drug((Long)drugRepo.count(),"Strepsils", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug1);
		drugRepo.save(drug2);
		drugRepo.save(drug3);
		
		
		Symptom curenje = new Symptom((Long)sympRepo.count(), "Curenje iz nosa");
		Symptom bol_u_grlu = new Symptom((Long)sympRepo.count(), "Bol u grlu");
		Symptom glavobolja = new Symptom((Long)sympRepo.count(), "Glavobolja");
		Symptom kijanje = new Symptom((Long)sympRepo.count(), "Kijanje");
		Symptom kasalj = new Symptom((Long)sympRepo.count(), "Kasalj");
		Symptom temp38 = new Symptom((Long)sympRepo.count(), "Temperatura veca od 38 C");
		Symptom drhtavica = new Symptom((Long)sympRepo.count(), "Drhtavica");
		Symptom bol_do_usiju = new Symptom((Long)sympRepo.count(), "Bol koji se siri do usiju");
		Symptom temp40_41 = new Symptom((Long)sympRepo.count(), "Temperatura od 40 C do 41 C");
		Symptom gubitak_apetita = new Symptom((Long)sympRepo.count(), "Gubitak apetita");
		Symptom umor = new Symptom((Long)sympRepo.count(), "Umor");
		Symptom zuti_sekret = new Symptom((Long)sympRepo.count(), "Zuti sekret iz nosa");
		Symptom oticanje_ociju = new Symptom((Long)sympRepo.count(), "Oticanje oko ociju");
		
		Symptom urin = new Symptom((Long)sympRepo.count(), "Cesto uriniranje");
		Symptom gubitak_tezine = new Symptom((Long)sympRepo.count(), "Gubitak telesne tezine");
		Symptom zamor = new Symptom((Long)sympRepo.count(), "Zamor");
		Symptom mucnina_i_povracanje = new Symptom((Long)sympRepo.count(), "Mucnina i povracanje");
		
		Symptom nocturia = new Symptom((Long)sympRepo.count(), "Nocturia");
		Symptom oticanje_nogu = new Symptom((Long)sympRepo.count(), "Otoci nogu i zglobova");
		Symptom gusenje = new Symptom((Long)sympRepo.count(), "Gušenje");
		Symptom bol_u_grudima = new Symptom((Long)sympRepo.count(), "Bol u grudima");
		
		Symptom dijareja = new Symptom((Long)sympRepo.count(), "Dijareja");
		
		sympRepo.save(curenje);
		sympRepo.save(bol_u_grlu);
		sympRepo.save(glavobolja);
		sympRepo.save(kijanje);
		sympRepo.save(kasalj);
		sympRepo.save(temp38);
		sympRepo.save(drhtavica);
		sympRepo.save(bol_do_usiju);
		sympRepo.save(temp40_41);
		sympRepo.save(gubitak_apetita);
		sympRepo.save(umor);
		sympRepo.save(zuti_sekret);
		sympRepo.save(oticanje_ociju);
		sympRepo.save(urin);
		sympRepo.save(gubitak_tezine);
		sympRepo.save(zamor);
		sympRepo.save(mucnina_i_povracanje);
		sympRepo.save(nocturia);
		sympRepo.save(oticanje_nogu);
		sympRepo.save(gusenje);
		sympRepo.save(bol_u_grudima);
		sympRepo.save(dijareja);
		
		//1. grupa
		Disease prehlada = new Disease((Long)disRepo.count(), "Prehlada", 1, new ArrayList<Symptom>());
		Disease groznica = new Disease((Long)disRepo.count(), "Groznica", 1, new ArrayList<Symptom>());
		Disease upala_krajnika = new Disease((Long)disRepo.count(), "Upala Krajnika", 1, new ArrayList<Symptom>());
		Disease sinusna_infekcija = new Disease((Long)disRepo.count(), "Sinusna infekcija", 1, new ArrayList<Symptom>());
		
		prehlada.getSymptoms().add(curenje);
		prehlada.getSymptoms().add(bol_u_grlu);
		prehlada.getSymptoms().add(glavobolja);
		prehlada.getSymptoms().add(kijanje);
		prehlada.getSymptoms().add(kasalj);
		
		groznica.getSymptoms().add(kijanje);
		groznica.getSymptoms().add(bol_u_grlu);
		groznica.getSymptoms().add(kasalj);
		groznica.getSymptoms().add(temp38);
		groznica.getSymptoms().add(curenje);
		groznica.getSymptoms().add(glavobolja);
		prehlada.getSymptoms().add(drhtavica);
		
		upala_krajnika.getSymptoms().add(bol_u_grlu);
		upala_krajnika.getSymptoms().add(bol_do_usiju);
		upala_krajnika.getSymptoms().add(glavobolja);
		upala_krajnika.getSymptoms().add(temp40_41);
		upala_krajnika.getSymptoms().add(drhtavica);
		upala_krajnika.getSymptoms().add(gubitak_apetita);
		upala_krajnika.getSymptoms().add(umor);
		upala_krajnika.getSymptoms().add(zuti_sekret);
		
		sinusna_infekcija.getSymptoms().add(oticanje_ociju);
		sinusna_infekcija.getSymptoms().add(glavobolja);
		sinusna_infekcija.getSymptoms().add(zuti_sekret);
		sinusna_infekcija.getSymptoms().add(bol_u_grlu);
		sinusna_infekcija.getSymptoms().add(temp38);
		sinusna_infekcija.getSymptoms().add(kasalj);
		
		
		
		//2. grupa
		Disease hipertenzija = new Disease((Long)disRepo.count(), "Hipertenzija", 2, new ArrayList<Symptom>());
		Disease dijabetes = new Disease((Long)disRepo.count(), "Dijabetes", 2, new ArrayList<Symptom>());
		
		dijabetes.getSymptoms().add(urin);
		dijabetes.getSymptoms().add(gubitak_tezine);
		dijabetes.getSymptoms().add(zamor);
		dijabetes.getSymptoms().add(mucnina_i_povracanje);
		
		
		//3. grupa
		Disease hronicna_bubrezna_bolest = new Disease((Long)disRepo.count(), "Hronična bubrezna bolest,", 3, new ArrayList<Symptom>());
		Disease akutna_bubrezna_povreda = new Disease((Long)disRepo.count(), "Akutna bubrezna povreda:", 3, new ArrayList<Symptom>());
		
		hronicna_bubrezna_bolest.getSymptoms().add(zamor);
		hronicna_bubrezna_bolest.getSymptoms().add(nocturia);
		hronicna_bubrezna_bolest.getSymptoms().add(oticanje_nogu);
		hronicna_bubrezna_bolest.getSymptoms().add(gusenje);
		hronicna_bubrezna_bolest.getSymptoms().add(bol_u_grudima);
		
		
		
		akutna_bubrezna_povreda.getSymptoms().add(zamor);
		akutna_bubrezna_povreda.getSymptoms().add(gusenje);
		akutna_bubrezna_povreda.getSymptoms().add(zamor);
		akutna_bubrezna_povreda.getSymptoms().add(oticanje_nogu);
		akutna_bubrezna_povreda.getSymptoms().add(dijareja);
	
		
		disRepo.save(prehlada);
		disRepo.save(groznica);
		disRepo.save(upala_krajnika);
		disRepo.save(sinusna_infekcija);
		disRepo.save(hipertenzija);
		disRepo.save(dijabetes);
		disRepo.save(hronicna_bubrezna_bolest);
		disRepo.save(akutna_bubrezna_povreda);
	}
}