import {Component, Input, OnInit} from '@angular/core';
import {
  trigger,
  state,
  style,
  animate,
  transition,
  query,
  stagger
} from '@angular/animations';


@Component({
  selector: 'app-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.sass'],
  animations: [
    trigger('articleAnimation', [
      transition(':enter', [
        query('article', style({ opacity: '0', transform: 'translateY(-15px)'})),
        query('article',
          stagger('150ms', [
            animate('300ms', style({ opacity: '1', transform: 'translateY(0)'}))
          ]))
      ])
    ])
  ]
})
export class GridComponent implements OnInit {
  @Input() data: any;
  @Input() totalDescription: string;

  constructor() { }

  ngOnInit() {
  }

}
