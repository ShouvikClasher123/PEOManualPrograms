import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '../../../node_modules/@angular/forms';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'program-login',
  templateUrl: './program-login.component.html',
  styleUrls: ['./program-login.component.css']
})
export class ProgramLoginComponent implements OnInit {
  userId:String='';
  loginForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private router:Router) { }
  showData(){
    // alert(JSON.stringify(this.loginForm.value));
    localStorage.setItem('userName',this.loginForm.value.userName);
    if(this.loginForm.value.userName=='admin'){

      this.router.navigate(['/programApproval']);
      
    }
    else{
      this.router.navigate(['/programCreation']);
    }
  }
  ngOnInit() {
    this.loginForm = this.formBuilder.group({

      userName: [null, [Validators.required]],
      password: [null, [Validators.required]]
  
    });
  }

}
