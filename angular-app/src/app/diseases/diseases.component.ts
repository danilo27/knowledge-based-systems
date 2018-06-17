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
  selector: 'app-diseases',
  templateUrl: './diseases.component.html',
  styleUrls: ['./diseases.component.css']
})
export class DiseasesComponent implements OnInit {

    diseases: any;
    symps: any;
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
}
