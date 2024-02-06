import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { MyPageComponent } from './components/my-page/my-page.component';
import { PageComponent } from './components/page/page.component';
import { SearchComponent } from './components/search/search.component';
import { SliderComponent } from './components/slider/slider.component';
import { BottomSheetComponent } from './components/bottom-sheet/bottom-sheet.component';

const routes: Routes = [
  { path: 'new', component: HomeComponent},
  { path: 'search', component: SearchComponent},
  { path: 'mypage', component: MyPageComponent},
  { path: 'admin', component: AdminComponent},
  { path: 'page', component: PageComponent},
  { path: 'slider', component: SliderComponent},
  { path: 'bottom_sheet', component: BottomSheetComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
