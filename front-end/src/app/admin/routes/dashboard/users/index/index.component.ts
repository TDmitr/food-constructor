import { Component, OnInit } from '@angular/core';
import {NgDataJsonserviceService} from '../../../../services/ng-data-jsonservice.service';
import {ActivatedRoute} from '@angular/router';
import {UserServiceService} from "../../../../services/user/user-service.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.sass']
})
export class UsersIndexComponent implements OnInit {
  data: any;
  outputData: any;
  columns: any = ['NAME', 'EMAIL'];
  constructor(private getDataService: NgDataJsonserviceService, private userService: UserServiceService) { }

  changeData(data) {
    this.outputData = data;
  }

  ngOnInit() {
    this.userService.fetch().subscribe(res => {
      console.log('all users', res);
      this.outputData = res;
    });
    // this.getDataService.getData('users.json').subscribe(res => {
    //   this.outputData = res;
    // });
  }

}
