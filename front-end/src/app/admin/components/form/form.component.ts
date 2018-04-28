import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserServiceService } from '../../services/user/user-service.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.sass']
})
export class FormComponent implements OnInit {
  loading = false;

  constructor(private userService: UserServiceService ) { }

  save(form: NgForm) {
    console.log(form);
    this.userService.add(form).subscribe(result => {
      console.log('add user', result)
    });
  }

  ngOnInit() {
  }

}
