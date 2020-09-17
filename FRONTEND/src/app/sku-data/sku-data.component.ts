import { Component, OnInit } from '@angular/core';
import { SkuService, Sku } from '../service/sku.service';
import { SelectItem } from 'primeng/components/common/selectitem';

@Component({
  selector: 'app-sku-data',
  templateUrl: './sku-data.component.html',
  styleUrls: ['./sku-data.component.css']
})
export class SkuDataComponent implements OnInit {



  displayDialog: boolean;
  displayDialog2: boolean;

    sku : Sku[];
    selectedSku:Sku;
    selectedSkuId : string;
    skuQty: any=0;
    submitSku: Sku[]=[];
    dropdownValues: SelectItem[];
totalAmount:any;
    selectedCar: string;

    

    cols: any[];

    constructor(private skuService: SkuService) { }

    ngOnInit() {
       let aa:any=[];
      this.skuService.getSkus().
      then(sku => {
          console.log(sku);
          this.sku=sku;
        sku.forEach(function(val,index) {
            console.log(val.skuId);
            aa.push({label: val.skuName, value: val.skuId})
            
         })       
         
         this.dropdownValues=aa;

       // this.sku = sku
    });

       

        this.cols = [
            { field: 'skuName', header: 'Sku Name' },
            { field: 'quantity', header: 'Quantity' },
            { field: 'price', header: 'Price' }
        ];
    }

    showDialogToAdd() {
        
        this.displayDialog = true;
    }
    buy(){
this.skuService.postSkus(this.submitSku).subscribe(data => {
    console.log(data);  
    this.totalAmount =data;
    this.displayDialog2 = true;
});
    }
    close(){
        this.displayDialog2 = false;
    }

    save() {
console.log("sss")
let sku2 :Sku={
    skuId:0, skuName:'', price:0, quantity :1 
};
this.sku.forEach(v=>{
    if(v.skuId==this.selectedSkuId){
        this.selectedSku=v;
    }
});

sku2 = this.selectedSku;
sku2.quantity = this.skuQty;

       this.submitSku.push(sku2);
        this.displayDialog = false;
    }

    


 

}
