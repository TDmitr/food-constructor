import { Component, OnInit } from '@angular/core';
import {NgDataJsonserviceService} from '../../services/ng-data-jsonservice.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  data: any;
  outputData: any;
  columns: any = ['NAME', 'EMAIL'];
  constructor(private getDataService: NgDataJsonserviceService, private route: ActivatedRoute) { }

  changeData(data) {
    this.outputData = data;
  }

  ngOnInit() {
    this.getDataService.getData('users.json').subscribe(res => {
      this.data = res.map(e => {
        return {
          id: e.id,
          data: {
            name: e.name,
            email: e.email
          },
          photo: e.photo
        };
      });
      this.outputData = this.data;
    });
    this.route.queryParams.subscribe(params => {
      console.log(params);
    });
  }

}
