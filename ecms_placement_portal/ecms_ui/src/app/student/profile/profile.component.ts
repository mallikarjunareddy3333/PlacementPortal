import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'student-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profileForm: FormGroup;

  constructor(private fb: FormBuilder) { 

  }

  ngOnInit() {
    this.profileForm = this.fb.group({
      rollNo: [''],
      firstName: [''],
      middleName: [''],
      lastName: [''],
      gender: [''],
      dob: [''],
      email: [''],
      phone: [''],
      branch: [''],
      yearOfJoin: [''],
      yearOfPass: [''],
      address: this.fb.group({
        doorNo: [''],
        streetName: [''],
        city: [''],
        state: [''],
        country: [''],
        pincode: ['']
      }),
      academicInfo: this.fb.group({
        ssc_aggr: [''],
		    inter_aggr: [''],
		    b11_aggr: [''],
		    b12_aggr: [''],
		    b21_aggr: [''],
		    b22_aggr: [''],
		    b31_aggr: [''],
		    b32_aggr: [''],
		    b41_aggr: [''],
		    b42_aggr: [''],
		    total_aggr: ['']
      })
    });
  }

}
