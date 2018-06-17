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
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

    diseases: any;
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
    resetPat(){
        this.pat_added = [];
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
    warnings = [];
    @ViewChild('warning_modal') warning_modal:ElementRef;
    validate(){
        this.ings_strings = [];
        this.alergies_strings = [];

        for(let drug of this.drugs_added){
            for(let ing of drug.ingridients)
                this.ings_strings.push(ing.name);
        }
        for(let aler of this.pat_added[0].alergies)
        {
            this.alergies_strings.push(aler.name);
        }

        var validation_dto = {
            prepisani: this.ings_strings,
            allergies: this.alergies_strings,
            patientId: this.id,
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

chronics = [];
addicts = [];
lows = [];

chronic(){
    this.http.get('/drools/chronics').subscribe(data=>{
        this.chronics = data as any [];
        this.what = 'chronics_result';

    });
}
addict(){
    this.http.get('/drools/addicts/').subscribe(data=>{
        console.log(data);
        this.addicts = data as any [];
        this.what = 'addicts_result';
    });
}

lowim(){
    this.http.get('/drools/lows/').subscribe(data=>{
        this.lows = data as any [];
        this.what = 'low_result';

    });
}

}

    declare var $:any;
