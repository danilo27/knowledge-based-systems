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
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.css']
})
export class IngredientsComponent implements OnInit {
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
      this.getingredients();
  }

  getingredients(){
        this.http.get('/Ingredients').subscribe(data => {
        if(data != null){
          console.log('ingredients: ',data);
          this.ingredients = data as any[];
        }
      })
  }

  delete(i){this.http.delete('/Ingredient/'+i).subscribe(data => {this.getingredients();})}
 // put(i){this.http.put('/Ingredient/'+i).subscribe(data => {this.ingredients = data as any[]; }})
 save(dis_name){
     var dis = {
         name: dis_name
     }
     console.log(dis);
     this.http.post('/Ingredient/add', dis).subscribe(data=>{this.getingredients()});

 }
}
