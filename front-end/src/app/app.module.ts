import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './admin/routes/dashboard/main.component';
import { SidebarComponent } from './admin/components/sidebar/sidebar.component';
import { HeaderComponent } from './admin/components/header/header.component';
import { DataTableComponent } from './admin/components/data-table/data-table.component';
import { IndexComponent } from './admin/routes/dashboard/index/index.component';
import { UsersComponent } from './admin/routes/dashboard/users/users.component';
import { NgDataJsonserviceService } from './admin/services/ng-data-jsonservice.service';
import { KeysPipe } from './pipes/json-to-array';
import { SearchComponent } from './admin/components/search/search.component';
import { PaginationComponent } from './admin/components/pagination/pagination.component';
import { CategoriesComponent } from './admin/routes/dashboard/categories/categories.component';
import { EditComponent } from './admin/routes/dashboard/users/edit/edit.component';
import { AddUserComponent } from './admin/routes/dashboard/users/add/add.component';
import { UsersIndexComponent } from './admin/routes/dashboard/users/index/index.component';
import { FormComponent } from './admin/components/form/form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserServiceService } from './admin/services/user/user-service.service';
import { HttpClientModule } from '@angular/common/http';
import { ViewComponent } from './admin/routes/dashboard/users/view/view.component';



const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: '',
    component: MainComponent,
    children: [
      {path: 'index', component: IndexComponent},
      {
        path: 'users',
        component: UsersComponent,
        children: [
          {
            path: '',
            component: UsersIndexComponent,
            children: [{path: 'view/:userId', component: ViewComponent}]
          },
          {path: 'add', component: AddUserComponent}
        ]
      },
      {path: 'categories', component: CategoriesComponent},
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
    PaginationComponent,
    CategoriesComponent,
    EditComponent,
    AddUserComponent,
    UsersIndexComponent,
    FormComponent,
    ViewComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [NgDataJsonserviceService, UserServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
