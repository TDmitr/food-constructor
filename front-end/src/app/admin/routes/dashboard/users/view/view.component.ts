import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {UserServiceService} from "../../../../services/user/user-service.service";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.sass']
})
export class ViewComponent implements OnInit {
  data: any;
  constructor(private route: ActivatedRoute, private userService: UserServiceService) { }

  ngOnInit() {
    // this.route.params.subscribe(params => {
    //   this.userService.get(params.userId).subscribe(res => {
    //     console.log('user', res);
    //     this.data = res;
    //   });
    // });
  }

}
