import {Component, Directive, Input, ViewChild, OnInit, ElementRef, AfterViewInit, Pipe, PipeTransform } from '@angular/core';
import { UnitService } from '../services/unit.service';
import {HttpClient} from "@angular/common/http";
import {LoginService} from '../services/login.service';
import {FormsModule} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {UploadFileService} from '../upload-file.service';
import {NgbDateStruct, NgbCalendar, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import 'rxjs/add/observable/of';
import { DomSanitizer, SafeResourceUrl, SafeUrl} from '@angular/platform-browser';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-diagnose',
  templateUrl: './diagnose.component.html',
  styleUrls: ['./diagnose.component.css']
})
export class DiagnoseComponent implements OnInit {

    diseases = [];
    symps = [];
    constructor(private unit_service: UnitService,
                private login_service: LoginService,
                private http: HttpClient,
                calendar: NgbCalendar,
                private uploadService: UploadFileService,
                private modalService: NgbModal,
                private _sanitizer: DomSanitizer
    ) { }

    ngOnInit() {
        this.getdiseases();
        this.getsymps();
        this.getdrugs();
        this.getpatients();
        this.what_diagnose = 'add_patient';

    }
    what_diagnose:string;
    pats = [];
    pat_added = [];
    getdiseases(){
        console.log('get diseases')
          this.http.get('/Diseases').subscribe(data => {
          if(data != null){
            console.log('diseases: ',data);
            this.diseases = data as any[];
          }
        })
    }

    getpatients(){
          this.http.get('/patients').subscribe(data => {
          if(data != null){
            console.log('Patients: ',data);
            this.pats = data as any[];

          }
        })
    }

    delete(i){this.http.delete('/Disease/'+i).subscribe(data => {this.getdiseases();})}
    put(i){
        var new_dis = {}
        //this.http.put('/Disease/'+i, new_dis).subscribe(data => {this.getdiseases() }})
    }
    getsymps(){
          this.http.get('/Symptoms').subscribe(data => {
          if(data != null){
            console.log('Symptoms: ',data);
            this.symps = data as any[];
          }
        })
    }
    symps_added:any;

    save(dis_name, dis_type){
        var dis = {
            name: dis_name,
            type: dis_type,
            symptoms: this.symps_added
        }
        console.log(dis);
        this.http.post('/Disease/add', dis).subscribe(data=>{this.getdiseases()});

    }
    what:string;

    choosing_symps(){
        this.what = 'symp_choosing';
    }

    reset(){
        this.what = '';
    }

    res_dis =  'No recommended disease by resoner...';
    strings_symps = [];
    startResoner(){
        this.res_dis =  'No recommended disease by resoner...';
        this.strings_symps = [];
        for(let s of this.symps_added){
            this.strings_symps.push(s.name);
        }
        console.log(this.strings_symps);
        var diag_dto = {
            symps: this.strings_symps
        }
        this.http.post('/drools/mostprobable', diag_dto).subscribe(data=>{
            if(data!=null){
                this.res_dis = data['name'];
                this.what = 'terapy_result';
            } else {
                this.res_dis = 'No recommended disease by resoner...';
                this.what = 'terapy_result';
            }
            console.log(this.res_dis);
            console.log(data);

        });

    }
    drugs_added = [];
    all_drugs = [];
    getdrugs(){
          this.http.get('/Drugs').subscribe(data => {
          if(data != null){

            this.all_drugs = data as any[];
          }
        })
    }

    savePat(){
        this.what_diagnose='patient_chosen';
    }

    id: any;
    firstname: string;
    lastname: string;
    patAdded(){
        this.id = this.pat_added[0].id;
        this.firstname = this.pat_added[0].firstname;
        this.lastname= this.pat_added[0].lastname;
    }
    ings_strings = [];
    alergies_strings = [];
    drug_prepisani = [];
    drug_allergies = [];
    warnings = [];
    @ViewChild('warning_modal') warning_modal:ElementRef;
    validate(){
        this.ings_strings = [];
        this.alergies_strings = [];
        this.drug_prepisani = [];
        this.drug_allergies = [];
        for(let drug of this.drugs_added){
            this.drug_prepisani.push(drug.naziv);
            for(let ing of drug.ingridients)
                this.ings_strings.push(ing.name);
        }
        for(let aler of this.pat_added[0].alergies){
            this.alergies_strings.push(aler.name);
        }
        var validation_dto = {
            prepisani: this.ings_strings,
            allergies: this.alergies_strings,
            patientId: this.id,
            drug_prepisani: this.drug_prepisani,
            drug_allergies: this.pat_added[0].drugAllergies,
            warnings: []

        }
        console.log('validation_dto', validation_dto);
        this.http.post('/drools/validate', validation_dto).subscribe(data=>{
            this.warnings = data as any[];
              $(this.warning_modal.nativeElement).modal('show');
        });
    }

dis_name: string;
returned_symps = {
    specific: null,
    general: null
}
@ViewChild('symps_for_dis') symps_for_dis:ElementRef;
searchForDis(n){
    this.dis_name = n;
    this.http.get('/drools/symptomsForDisease/'+n).subscribe(data=>{

        this.returned_symps = data as any;
          $(this.symps_for_dis.nativeElement).modal('show');
    });

}
vracenaBolest(){

}
resetPat(){
    this.pat_added = [];
}
dis_chosen = [];
saveDiag(){
    this.res_dis = this.dis_chosen[0].name;
    this.what = 'terapy_result';
}
saveTerapy(){
    var dr = {
        username: 'daca',
        firstname: 'Danilo',
        lastname: 'Bujisa'
    }
    var terapy = {
        drugs: this.drugs_added,
        disease: this.res_dis,
        doctor: dr,
        patient: this.pat_added[0]
    }
    this.http.post('/Terapy/add/',terapy).subscribe(data=>{
        this.reset();
        this.what_diagnose = 'add_patient';
        alert('Terapy saved.');

    })

}
    all_possible = [];
    allPossible(){
            this.all_possible = [];
            this.strings_symps = [];
            for(let s of this.symps_added){
                this.strings_symps.push(s.name);
            }
            console.log(this.strings_symps);

            this.http.post('/drools/allpossible', this.strings_symps).subscribe(data=>{
                if(data!=null){
                    this.all_possible = data as any [];
                    this.what = 'all_dis_div';
                } else {
                    this.all_possible.push('No connection beetween given symptoms and diseases in database...');
                    this.what = 'all_dis_div';
                }

                console.log(data);

            });


    }

}

    declare var $:any;
