import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {VanbandenListComponent} from "./vanbanden/vanbanden-list/vanbanden-list.component";
import { VanbandenCreateComponent } from './vanbanden/vanbanden-create/vanbanden-create.component';
import { VanbandenDetailComponent } from './vanbanden/vanbanden-detail/vanbanden-detail.component';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AccountEditComponent } from './account/account-edit/account-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    VanbandenListComponent,
    VanbandenCreateComponent,
    VanbandenDetailComponent,
    AccountListComponent,
    AccountEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path:"vanbanden", component:VanbandenListComponent},
      {path:"vanbanden/create", component:VanbandenCreateComponent},
      {path:"vanbanden/detail/:id", component:VanbandenDetailComponent},
      {path:"account",component:AccountListComponent},
      {path:"account/edit/:id",component:AccountEditComponent}

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
