package com;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Disease;
import com.model.DiseaseHistory;
import com.model.Drug;
import com.model.Ingredient;
import com.model.Patient;
import com.model.Symptom;
import com.model.Terapy;
import com.model.User;
import com.repositories.DiseasesRepo;
import com.repositories.DrugRepo;
import com.repositories.HistoryRepo;
import com.repositories.IngredientRepo;
import com.repositories.PatientRepo;
import com.repositories.SymptomRepo;
import com.repositories.TerapyRepo;
import com.repositories.UserRepo;
import com.services.PatientSI;

@Component
public class GenerateData {
	private   UserRepo userRepo;
	private   PatientRepo patRepo;
	private   DrugRepo drugRepo;
	private   DiseasesRepo disRepo;
	private   HistoryRepo histRepo;
	private   IngredientRepo ingRepo;
	private   SymptomRepo sympRepo;
	private   TerapyRepo terapyRepo;
	private   PatientSI patService;
	@Autowired
	public GenerateData(
			UserRepo userRepo, PatientRepo patRepo, DrugRepo drugRepo, 
			DiseasesRepo disRepo, HistoryRepo histRepo, IngredientRepo ingRepo, SymptomRepo sympRepo, TerapyRepo terapyRepo,
			PatientSI patService
			){
		this.userRepo = userRepo;
		this.patRepo= patRepo;
		this.drugRepo = drugRepo;
		this.disRepo = disRepo;
		this.histRepo = histRepo;
		this.ingRepo = ingRepo;
		this.sympRepo = sympRepo;
		this.terapyRepo = terapyRepo;
		this.patService = patService;
	}
	
	@PostConstruct
	public void data(){
		userRepo.deleteAll();
		patRepo.deleteAll();
		drugRepo.deleteAll();
		disRepo.deleteAll();
		histRepo.deleteAll();
		ingRepo.deleteAll();
		sympRepo.deleteAll();
		terapyRepo.deleteAll();
		
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setType("admin");
		admin.setId(Long.valueOf(0));
		userRepo.save(admin);
		
		User doc = new User();
		User doc2 = new User();
		User doc3 = new User();
		
		doc.setUsername("doc");
		doc.setPassword("doc");
		doc.setFirstname("Danilo");
		doc.setLastname("Bujisa");
		doc.setLicenceId("4323");
		doc.setType("doctor");
		doc.setDezuran(true);
		doc.setId(Long.valueOf(1));
		userRepo.save(doc);
		
		doc2.setUsername("doc2");
		doc2.setPassword("doc");
		doc2.setFirstname("Dom");
		doc2.setLastname("Cruz");
		doc2.setLicenceId("4323");
		doc2.setType("doctor");
		doc2.setDezuran(true);
		doc2.setId(Long.valueOf(2));
		userRepo.save(doc2);
		
		doc3.setUsername("doc3");
		doc3.setPassword("doc");
		doc3.setFirstname("Nick");
		doc3.setLastname("Diaz");
		doc3.setLicenceId("4323");
		doc3.setType("doctor");
		doc3.setDezuran(true);
		doc3.setId(Long.valueOf(3));
		userRepo.save(doc3);
		
		Ingredient secer = new Ingredient((Long)ingRepo.count(),"Sugar");
		ingRepo.save(secer);
		Ingredient lactose = new Ingredient((Long)ingRepo.count(),"Lactose");
		ingRepo.save(lactose);		
		Ingredient gluten = new Ingredient((Long)ingRepo.count(),"Gluten");
		ingRepo.save(gluten);

		Drug drug1 = new Drug((Long)drugRepo.count(),"Panadol Extra", "Analgetic", new ArrayList<Ingredient>());
		drug1.getIngridients().add(secer);
		drugRepo.save(drug1);
		Drug drug2 = new Drug((Long)drugRepo.count(),"Penicilin", "Antibiotik", new ArrayList<Ingredient>());
		drugRepo.save(drug2);
		Drug drug3 = new Drug((Long)drugRepo.count(),"Strepsils", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug3);
		Drug drug4 = new Drug((Long)drugRepo.count(),"HGH", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug4);
		Drug drug5 = new Drug((Long)drugRepo.count(),"TRT", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug5);
		Drug drug6 = new Drug((Long)drugRepo.count(),"Axiron", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug6);
		Drug drug7 = new Drug((Long)drugRepo.count(),"Fortesta", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug7);
		Drug drug8 = new Drug((Long)drugRepo.count(),"Anadrol", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug8);
		Drug drug9 = new Drug((Long)drugRepo.count(),"Adderal", "Ostalo", new ArrayList<Ingredient>());
		drugRepo.save(drug9);
		
		Patient pat1 = new Patient((Long)patRepo.count(), "Mitar", "Miric", new ArrayList<Ingredient>(), new ArrayList<DiseaseHistory>()); 
		pat1.getAlergies().add(secer);
		pat1.getDrugAllergies().add(drug2.getNaziv());
		patRepo.save(pat1);
		Patient pat2 = new Patient((Long)patRepo.count(), "Boris", "Brejcha", new ArrayList<Ingredient>(), new ArrayList<DiseaseHistory>());
		patRepo.save(pat2);
		Patient pat3 = new Patient((Long)patRepo.count(), "Yoel", "Romero", new ArrayList<Ingredient>(), new ArrayList<DiseaseHistory>()); 
		patRepo.save(pat3);
		
		
		
		
		
		Symptom curenje = new Symptom((Long)sympRepo.count(), "Curenje iz nosa");
		sympRepo.save(curenje);
		Symptom bol_u_grlu = new Symptom((Long)sympRepo.count(), "Bol u grlu");
		sympRepo.save(bol_u_grlu);
		Symptom glavobolja = new Symptom((Long)sympRepo.count(), "Glavobolja");
		sympRepo.save(glavobolja);
		Symptom kijanje = new Symptom((Long)sympRepo.count(), "Kijanje");
		sympRepo.save(kijanje);
		Symptom kasalj = new Symptom((Long)sympRepo.count(), "Kasalj");
		sympRepo.save(kasalj);
		Symptom temp38 = new Symptom((Long)sympRepo.count(), "Temperatura veca od 38 C");
		sympRepo.save(temp38);
		Symptom drhtavica = new Symptom((Long)sympRepo.count(), "Drhtavica");
		sympRepo.save(drhtavica);
		Symptom bol_do_usiju = new Symptom((Long)sympRepo.count(), "Bol koji se siri do usiju");
		sympRepo.save(bol_do_usiju);
		Symptom temp40_41 = new Symptom((Long)sympRepo.count(), "Temperatura od 40 C do 41 C");
		sympRepo.save(temp40_41);
		Symptom gubitak_apetita = new Symptom((Long)sympRepo.count(), "Gubitak apetita");
		sympRepo.save(gubitak_apetita);
		Symptom umor = new Symptom((Long)sympRepo.count(), "Umor");
		sympRepo.save(umor);
		Symptom zuti_sekret = new Symptom((Long)sympRepo.count(), "Zuti sekret iz nosa");
		sympRepo.save(zuti_sekret);
		Symptom oticanje_ociju = new Symptom((Long)sympRepo.count(), "Oticanje oko ociju");
		sympRepo.save(oticanje_ociju);
		
		Symptom urin = new Symptom((Long)sympRepo.count(), "Cesto uriniranje");
		sympRepo.save(urin);
		Symptom gubitak_tezine = new Symptom((Long)sympRepo.count(), "Gubitak telesne tezine");
		sympRepo.save(gubitak_tezine);
		Symptom zamor = new Symptom((Long)sympRepo.count(), "Zamor");
		sympRepo.save(zamor);
		Symptom mucnina_i_povracanje = new Symptom((Long)sympRepo.count(), "Mucnina i povracanje");
		sympRepo.save(mucnina_i_povracanje);
		
		Symptom nocturia = new Symptom((Long)sympRepo.count(), "Nocturia");
		sympRepo.save(nocturia);
		Symptom oticanje_nogu = new Symptom((Long)sympRepo.count(), "Otoci nogu i zglobova");
		sympRepo.save(oticanje_nogu);
		Symptom gusenje = new Symptom((Long)sympRepo.count(), "Gusenje");
		sympRepo.save(gusenje);
		Symptom bol_u_grudima = new Symptom((Long)sympRepo.count(), "Bol u grudima");
		sympRepo.save(bol_u_grudima);
		
		Symptom dijareja = new Symptom((Long)sympRepo.count(), "Dijareja");
		sympRepo.save(dijareja);
		
		//spec///////
		Symptom dana_60 = new Symptom((Long)sympRepo.count(), "Bolovao od prehlade odnosno groznice u poslednjih 60 dana");
		dana_60.setSpecific(true);
		sympRepo.save(dana_60);
	
		
		Symptom meseci_6 = new Symptom((Long)sympRepo.count(), "U poslednjih 6 meseci preko 10 puta imao visok pritisak");
		meseci_6.setSpecific(true);
		sympRepo.save(meseci_6);
		
		Symptom boluje_od_hip_6_mes = new Symptom((Long)sympRepo.count(), "Boluje od hipertenzije vise od 6 meseci");
		boluje_od_hip_6_mes.setSpecific(true);
		sympRepo.save(boluje_od_hip_6_mes);
		Symptom boluje_od_dijabetesa = new Symptom((Long)sympRepo.count(), "Boluje od dijabetesa");
		boluje_od_dijabetesa.setSpecific(true);
		sympRepo.save(boluje_od_dijabetesa);
		
		Symptom oporavlja_se = new Symptom((Long)sympRepo.count(), "Oporavlja se od operacije");
		oporavlja_se.setSpecific(true);
		sympRepo.save(oporavlja_se);
		
		Symptom dana_14 = new Symptom((Long)sympRepo.count(), "U poslednjih 14 dana dijagnostikovana povisena temperatura");
		dana_14.setSpecific(true);
		sympRepo.save(dana_14);
		Symptom dana_21 = new Symptom((Long)sympRepo.count(), "U poslednjih 21 dan primao antibiotike");
		dana_21.setSpecific(true);
		sympRepo.save(dana_21);
		
		//////////////
		
		
		
		
		//1. grupa
		Disease prehlada = new Disease((Long)disRepo.count(), "Prehlada", 1, new ArrayList<Symptom>());
		
		
		prehlada.getSymptoms().add(curenje);
		prehlada.getSymptoms().add(bol_u_grlu);
		prehlada.getSymptoms().add(glavobolja);
		prehlada.getSymptoms().add(kijanje);
		prehlada.getSymptoms().add(kasalj);
		disRepo.save(prehlada);
		
		Disease groznica = new Disease((Long)disRepo.count(), "Groznica", 1, new ArrayList<Symptom>());
		
		groznica.getSymptoms().add(kijanje);
		groznica.getSymptoms().add(bol_u_grlu);
		groznica.getSymptoms().add(kasalj);
		groznica.getSymptoms().add(temp38);
		groznica.getSymptoms().add(curenje);
		groznica.getSymptoms().add(glavobolja);
		prehlada.getSymptoms().add(drhtavica);
		disRepo.save(groznica);
		
		Disease upala_krajnika = new Disease((Long)disRepo.count(), "Upala Krajnika", 1, new ArrayList<Symptom>());	
		upala_krajnika.getSymptoms().add(bol_u_grlu);
		upala_krajnika.getSymptoms().add(bol_do_usiju);
		upala_krajnika.getSymptoms().add(glavobolja);
		upala_krajnika.getSymptoms().add(temp40_41);
		upala_krajnika.getSymptoms().add(drhtavica);
		upala_krajnika.getSymptoms().add(gubitak_apetita);
		upala_krajnika.getSymptoms().add(umor);
		upala_krajnika.getSymptoms().add(zuti_sekret);
		disRepo.save(upala_krajnika);
		
		Disease sinusna_infekcija = new Disease((Long)disRepo.count(), "Sinusna infekcija", 1, new ArrayList<Symptom>());
		sinusna_infekcija.getSymptoms().add(oticanje_ociju);
		sinusna_infekcija.getSymptoms().add(glavobolja);
		sinusna_infekcija.getSymptoms().add(zuti_sekret);
		sinusna_infekcija.getSymptoms().add(bol_u_grlu);
		sinusna_infekcija.getSymptoms().add(temp38);
		sinusna_infekcija.getSymptoms().add(kasalj);
		sinusna_infekcija.getSymptoms().add(dana_60);
		disRepo.save(sinusna_infekcija);
		
		
		//2. grupa
		Disease hipertenzija = new Disease((Long)disRepo.count(), "Hipertenzija", 2, new ArrayList<Symptom>());
		hipertenzija.getSymptoms().add(meseci_6);
		disRepo.save(hipertenzija);
		
		Disease dijabetes = new Disease((Long)disRepo.count(), "Dijabetes", 2, new ArrayList<Symptom>());
		dijabetes.getSymptoms().add(urin);
		dijabetes.getSymptoms().add(gubitak_tezine);
		dijabetes.getSymptoms().add(zamor);
		dijabetes.getSymptoms().add(mucnina_i_povracanje);
		disRepo.save(dijabetes);
		
		//3. grupa
		Disease hronicna_bubrezna_bolest = new Disease((Long)disRepo.count(), "Hronična bubrezna bolest", 3, new ArrayList<Symptom>());	
		hronicna_bubrezna_bolest.getSymptoms().add(zamor);
		hronicna_bubrezna_bolest.getSymptoms().add(nocturia);
		hronicna_bubrezna_bolest.getSymptoms().add(oticanje_nogu);
		hronicna_bubrezna_bolest.getSymptoms().add(gusenje);
		hronicna_bubrezna_bolest.getSymptoms().add(bol_u_grudima);
		hronicna_bubrezna_bolest.getSymptoms().add(boluje_od_hip_6_mes);
		hronicna_bubrezna_bolest.getSymptoms().add(boluje_od_dijabetesa);
		disRepo.save(hronicna_bubrezna_bolest);
		
		Disease akutna_bubrezna_povreda = new Disease((Long)disRepo.count(), "Akutna bubrezna povreda", 3, new ArrayList<Symptom>());
		akutna_bubrezna_povreda.getSymptoms().add(oporavlja_se);
		akutna_bubrezna_povreda.getSymptoms().add(zamor);
		akutna_bubrezna_povreda.getSymptoms().add(gusenje);
		akutna_bubrezna_povreda.getSymptoms().add(zamor);
		akutna_bubrezna_povreda.getSymptoms().add(oticanje_nogu);
		akutna_bubrezna_povreda.getSymptoms().add(dijareja);
		akutna_bubrezna_povreda.getSymptoms().add(dana_14);
		akutna_bubrezna_povreda.getSymptoms().add(dana_21);
		disRepo.save(akutna_bubrezna_povreda);
		
		List<Drug> terapy_drugs = new ArrayList<Drug>();
		terapy_drugs.add(drug1);
		terapy_drugs.add(drug1);
		terapy_drugs.add(drug1);
		terapy_drugs.add(drug1);
		terapy_drugs.add(drug1);
		terapy_drugs.add(drug1);
		
		Terapy t1 = new Terapy((Long)terapyRepo.count(),terapy_drugs, "Sinusna infekcija", doc, pat1, new GregorianCalendar(2018, Calendar.APRIL, 11).getTime());
		
		Patient p = patRepo.findOne(pat1.getId());
		p.getTerapies().add(terapyRepo.save(t1));
		patService.update(p);
		
		
		Terapy t2 = new Terapy((Long)terapyRepo.count(),terapy_drugs, "Sinusna infekcija", doc2, pat1, new GregorianCalendar(2018, Calendar.MARCH, 12).getTime());
		Patient p2 = patRepo.findOne(pat1.getId());
		p2.getTerapies().add(terapyRepo.save(t2));
		patService.update(p2);
		
		Terapy t3 = new Terapy((Long)terapyRepo.count(),terapy_drugs, "Sinusna infekcija", doc3, pat1, new GregorianCalendar(2018, Calendar.MARCH, 13).getTime());
		Patient p3 = patRepo.findOne(pat1.getId());
		p3.getTerapies().add(terapyRepo.save(t3));
		patService.update(p3);
		
		
		Terapy t4 = new Terapy((Long)terapyRepo.count(),terapy_drugs, "Sinusna infekcija", doc, pat1, new GregorianCalendar(2018, Calendar.APRIL, 11).getTime());
		Patient p4 = patRepo.findOne(pat1.getId());
		p4.getTerapies().add(terapyRepo.save(t4));
		patService.update(p4);
		
		Terapy t5 = new Terapy((Long)terapyRepo.count(),terapy_drugs, "Sinusna infekcija", doc3, pat1, new GregorianCalendar(2018, Calendar.MAY, 11).getTime());
		Patient p5 = patRepo.findOne(pat1.getId());
		p5.getTerapies().add(terapyRepo.save(t5));
		patService.update(p5);
		
		Terapy t6 = new Terapy((Long)terapyRepo.count(),terapy_drugs, "Sinusna infekcija", doc, pat1, new GregorianCalendar(2018, Calendar.JUNE, 11).getTime());
		Patient p6 = patRepo.findOne(pat1.getId());
		p6.getTerapies().add(terapyRepo.save(t6));
		patService.update(p6);
 	
	}
}
