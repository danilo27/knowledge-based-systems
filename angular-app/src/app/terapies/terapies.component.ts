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
  selector: 'app-terapies',
  templateUrl: './terapies.component.html',
  styleUrls: ['./terapies.component.css']
})
export class TerapiesComponent implements OnInit {
  terapies: any;
  constructor(private unit_service: UnitService,
              private login_service: LoginService,
              private http: HttpClient,
              calendar: NgbCalendar,
              private uploadService: UploadFileService,
              private modalService: NgbModal,
              private _sanitizer: DomSanitizer
  ) { }

  ngOnInit() {
      this.getterapies();
      this.getdrugs();
      this.getdiseases();
  }

  getterapies(){
        this.http.get('/Terapies').subscribe(data => {
        if(data != null){
          console.log('Terapies: ',data);
          this.terapies = data as any[];
        }
      })
  }

  delete(i){this.http.delete('/Terapy/'+i).subscribe(data => {this.getterapies();})}

 save(dis_name){
     var dis = {
         name: dis_name
     }
     console.log(dis);
     this.http.post('/Terapy/add', dis).subscribe(data=>{this.getterapies()});

 }

 getdiseases(){
     console.log('get diseases')
       this.http.get('/Diseases').subscribe(data => {
       if(data != null){
         console.log('diseases: ',data);
         this.diseases = data as any[];
       }
     })
 }
diseases = [];
res_dis = [];
 drugs_added = [];
 all_drugs = [];
 getdrugs(){
       this.http.get('/Drugs').subscribe(data => {
       if(data != null){

         this.all_drugs = data as any[];
       }
     })
 }
dis_chosen = [];
 id_na_editu: any;
 dr: any;
 @ViewChild('edit') edit:ElementRef;
   saveUpdate(){
       console.log('id: ', this.id_na_editu);

       if(this.drugs_added.length == 0){
           for(let t of this.terapies){
               if(t.id == this.id_na_editu){
                   for(let d of t.drugs){
                    this.drugs_added.push(d);
                   }

               }
           }

       }
       if(this.dis_chosen.length == 0){
           for(let t of this.terapies){
               if(t.id == this.id_na_editu){
                   this.res_dis = t.disease;
               }
           }

       } else {
           this.res_dis = this.dis_chosen[0].name;
       }
       for(let t of this.terapies){
           if(t.id == this.id_na_editu){
               this.dr = t.doctor;
           }
       }
       var patient;
       for(let t of this.terapies){
           if(t.id == this.id_na_editu){
               patient = t.patient;
           }
       }
       var terapy = {
           doctor: this.dr,
           id: this.id_na_editu,
           drugs: this.drugs_added,
           disease: this.res_dis,
           patient: patient
       }
       console.log(terapy);

       this.http.put('/Terapy/', terapy).subscribe(data => {this.getterapies() })


   }

   update_set(i){
       this.id_na_editu = i;
        $(this.edit.nativeElement).modal('show');
   }
}

declare var $:any;
