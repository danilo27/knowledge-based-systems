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
  selector: 'app-drugs',
  templateUrl: './drugs.component.html',
  styleUrls: ['./drugs.component.css']
})
export class DrugsComponent implements OnInit {
    drugs: any;
    constructor(private unit_service: UnitService,
                private login_service: LoginService,
                private http: HttpClient,
                calendar: NgbCalendar,
                private uploadService: UploadFileService,
                private modalService: NgbModal,
                private _sanitizer: DomSanitizer
    ){ }

    ngOnInit() {
        this.getdrugs();
        this.getingredients();
    }

    getdrugs(){
          this.http.get('/Drugs').subscribe(data => {
          if(data != null){
            console.log('Drugs: ',data);
            this.drugs = data as any[];
          }
        })
    }
    delete(i){this.http.delete('/Drug/'+i).subscribe(data => {this.getdrugs();})}
    //put(i){this.http.put('/Drug/'+i).subscribe(data => {this.drugs = data as any[]; }})
    ings_added:any;

    save(dis_name, dis_type){
        var dis = {
            naziv: dis_name,
            type: dis_type,
            ingridients: this.ings_added
        }
        console.log(dis);
        this.http.post('/Drug/add', dis).subscribe(data=>{this.getdrugs()});

    }
    ingredients: any;
    getingredients(){
          this.http.get('/Ingredients').subscribe(data => {
          if(data != null){
            console.log('ingredients: ',data);
            this.ingredients = data as any[];
          }
        })
    }
}
