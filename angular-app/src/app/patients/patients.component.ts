import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent implements OnInit {
  patients: any;
  constructor() { }

  ngOnInit() {
      this.patients();
  }

  patients(){
        this.http.get('/patients').subscribe(data => {
        if(data != null){
          console.log('Patients: ',data);
          this.patients = data as any[];
        }
      })
  }
}
