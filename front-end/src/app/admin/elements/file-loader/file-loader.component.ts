import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-file-loader',
  templateUrl: './file-loader.component.html',
  styleUrls: ['./file-loader.component.sass']
})
export class FileLoaderComponent implements OnInit {
  public image: any;
  public name: string;
  public loaded = false;

  constructor() { }

  setImage(e) {
    const file = e.dataTransfer ? e.dataTransfer.files[0] : e.target.files[0],
          pattern = /image-*/,
          reader = new FileReader();

    if (!file.type.match(pattern)) {
      alert('invalid format');
      return;
    }

    this.loaded = false;
    this.name = e.target.files[0].name;

    reader.onload = this._handleReaderLoaded.bind(this);
    reader.readAsDataURL(file);
  }

  _handleReaderLoaded(e) {
    const reader = e.target;
    this.image = reader.result;
    this.loaded = true;
  }

  removeImage() {
    this.image = null;
    this.name = null;
    this.loaded = false;
  }

  ngOnInit() {
  }

}
