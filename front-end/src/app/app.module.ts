import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './routes/login/login.component';
import { MainComponent } from './routes/dashboard/main/main.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HeaderComponent } from './components/header/header.component';
import { DataTableComponent } from './components/data-table/data-table.component';
import { IndexComponent } from './dashboard/index/index.component';
import { UsersComponent } from './dashboard/users/users.component';
import {NgDataJsonserviceService} from "./services/ng-data-jsonservice.service";
import {KeysPipe} from "./pipes/json-to-array";
import { SearchComponent } from './components/search/search.component';
import { PaginationComponent } from './components/pagination/pagination.component';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: '',
    component: MainComponent,
    children: [
      {path: 'index', component: IndexComponent},
      {path: 'users', component: UsersComponent},
    ]
  }
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    SidebarComponent,
    HeaderComponent,
    DataTableComponent,
    IndexComponent,
    UsersComponent,
    KeysPipe,
    SearchComponent,
    PaginationComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [NgDataJsonserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
