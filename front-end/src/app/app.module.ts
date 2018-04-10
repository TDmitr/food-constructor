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

import { EditComponent } from './admin/routes/dashboard/users/edit/edit.component';
import { AddUserComponent } from './admin/routes/dashboard/users/add/add.component';
import { UsersIndexComponent } from './admin/routes/dashboard/users/index/index.component';
import { FormComponent } from './admin/components/form/form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserServiceService } from './admin/services/user/user-service.service';
import { HttpClientModule } from '@angular/common/http';
import { ViewComponent } from './admin/routes/dashboard/users/view/view.component';

import { CategoriesComponent } from './admin/routes/dashboard/categories/categories.component';
import { CategoriesIndexComponent } from './admin/routes/dashboard/categories/index/index.component';
import { CategoriesAddComponent } from './admin/routes/dashboard/categories/add/add.component';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddFirstStepComponent } from './admin/routes/dashboard/categories/add/add-first-step/add-first-step.component';
import { AddSecondStepComponent } from './admin/routes/dashboard/categories/add/add-second-step/add-second-step.component';
import { AddThirdStepComponent } from './admin/routes/dashboard/categories/add/add-third-step/add-third-step.component';
import { AddThirdStepPopupComponent } from './admin/routes/dashboard/categories/add/add-third-step-popup/add-third-step-popup.component';
import { IngredientsGroupComponent} from './admin/routes/dashboard/ingredients/group/group.component';
import { IngredientsAddGroupComponent } from './admin/routes/dashboard/ingredients/group/add/add.component';
import { IngredientsIndexGroupComponent} from './admin/routes/dashboard/ingredients/group/index/index.component';
import { GridComponent } from './admin/components/grid/grid.component';
import {SiteMainRouter} from './site/routes/main/main.component';
import { SiteCategoryComponent } from './site/routes/site-category/site-category.component';
import { SiteCategoryItemComponent } from './site/components/site-category-item/site-category-item.component';
import { SiteCategoryItemInfoComponent } from './site/routes/site-category-item-info/site-category-item-info.component';
import {CartService} from "./site/services/cart.service";


const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: SiteMainRouter},
  {
    path: 'admin',
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
      {
        path: 'categories',
        component: CategoriesComponent,
        children: [
          { path: '', component: CategoriesIndexComponent},
          { path: 'add', component: CategoriesAddComponent}
        ]
      },
      {
        path: 'ingredients/groups',
        component: IngredientsGroupComponent,
        children: [
          {path: '', component: IngredientsIndexGroupComponent},
          {path: 'add', component: IngredientsAddGroupComponent}
        ]
      }
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
    CategoriesIndexComponent,
    CategoriesAddComponent,
    EditComponent,
    AddUserComponent,
    UsersIndexComponent,
    FormComponent,
    ViewComponent,
    AddFirstStepComponent,
    AddSecondStepComponent,
    AddThirdStepComponent,
    AddThirdStepPopupComponent,
    IngredientsGroupComponent,
    IngredientsAddGroupComponent,
    IngredientsIndexGroupComponent,
    GridComponent,
    SiteMainRouter,
    SiteCategoryComponent,
    SiteCategoryItemComponent,
    SiteCategoryItemInfoComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [NgDataJsonserviceService, UserServiceService, CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
