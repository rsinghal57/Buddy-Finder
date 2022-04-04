import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuddyListComponent } from './buddy-list/buddy-list.component';
import { CreateBuddyComponent } from './create-buddy/create-buddy.component';
import { UpdateBuddyComponent } from './update-buddy/update-buddy.component';

const routes: Routes = [
  { path: "buddies", component: BuddyListComponent },
  { path: "", redirectTo: "buddies", pathMatch: "full" },
  { path: "create-buddy", component: CreateBuddyComponent },
  {path:"update-buddy/:id" , component:UpdateBuddyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
