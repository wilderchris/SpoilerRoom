import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { MyPageComponent } from './components/my-page/my-page.component';
import { SearchComponent } from './components/search/search.component';

const routes: Routes = [
  { path: 'new', component: HomeComponent},
  { path: 'search', component: SearchComponent},
  { path: 'mypage', component: MyPageComponent},
  { path: 'admin', component: AdminComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
