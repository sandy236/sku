import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SkuDataComponent } from './sku-data/sku-data.component';


const routes: Routes = [
  { path: 'sku', component: SkuDataComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
