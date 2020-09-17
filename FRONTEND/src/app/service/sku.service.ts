import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface Sku {
    skuId;
    skuName;
    price;
    quantity;
}

@Injectable({
  providedIn: 'root'
})
export class SkuService {

  constructor(private http: HttpClient) {}

  getSkus() {
    return this.http.get<any>('http://localhost:8081/api/v1/skus')
      .toPromise()
      .then(res => <Sku[]>res)
      ;
    }

    postSkus(submitSku) {
      return  this.http.post<any>('http://localhost:8081/api/v1/addpromotions', 
{skus:submitSku});
        // return this.http.post<any>('http://localhost:8081/api/v1/addpromotions')
        //   .toPromise()
        //   .then(res => {
           
        //     <Sku[]>res.data})
        //   .then(data => { return data; });
        }
}
