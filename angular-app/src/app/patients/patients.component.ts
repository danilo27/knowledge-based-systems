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
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent implements OnInit {
  patients: any;
  ingredients: any;
  constructor(private unit_service: UnitService,
              private login_service: LoginService,
              private http: HttpClient,
              calendar: NgbCalendar,
              private uploadService: UploadFileService,
              private modalService: NgbModal,
              private _sanitizer: DomSanitizer
  ) { }

  ngOnInit() {
      this.getpatients();
      this.getingredients();
  }

  getpatients(){
        this.http.get('/patients').subscribe(data => {
        if(data != null){
          console.log('Patients: ',data);
          this.patients = data as any[];
        }
      })
  }

  delete(i){
        this.http.delete('/patient/'+i).subscribe(data => {

          this.getpatients();

      })
  }

  update(first,last){
      var patient = {
          firstname: first,
          lastname: last,
          alergies: this.alergies,
          id: this.id_na_editu
      }
        this.http.put('/patient/', patient).subscribe(data => { this.getpatients();  })
  }

  getingredients(){
        this.http.get('/Ingredients').subscribe(data => {
        if(data != null){
          this.ingredients = data as any[];
        }
      })
  }
  alergies: any;
  save(first,last){
      var patient = {
          firstname: first,
          lastname: last,
          alergies: this.alergies
      }
      console.log(patient);
      this.http.post('/patient/add', patient).subscribe(data=>{this.getpatients()});

  }

  dismiss(){}
  id_na_editu: any;
  @ViewChild('edit') edit:ElementRef;
    update_set(i){
        this.id_na_editu = i;
    
        (<HTMLInputElement>document.getElementById('edit_firstname')).value = this.patients[i].firstname;
        (<HTMLInputElement>document.getElementById('edit_lastname')).value = this.patients[i].lastname;
        this.alergies = this.patients[i].alergies;
        console.log(this.alergies);
        $(this.edit.nativeElement).modal('show');
    }






}

declare var $:any;
