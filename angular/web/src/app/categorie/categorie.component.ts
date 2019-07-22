import { Component, OnInit } from '@angular/core';

import { CategService} from '../services/CategService';



import { LocalDataSource } from 'ng2-smart-table';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.scss']
})
export class CategorieComponent implements OnInit {


  public data = [
 
  ];

  public settings = {
    mode: 'inline',
    

    edit: {
      confirmSave: true,
    },
    add: {
      confirmCreate: true,
    },
    delete: {
      confirmDelete: true,
    },
    actions: {
      custom: [
        {
          name: 'delete',
          title: 'delete ',
        },
      ],
    },
    columns: {
      id: {
        title: 'Id'
      },
      name: {
        title: 'Name'
      },

      description: {
        title: 'Description'
      },
      balance: {
        title: 'Amount'
      },

    }
  };

  public source: LocalDataSource;
  public categList;

  public id="ff8080816a4b1eeb016a4b207bcc0000";
    

  constructor(private categsrv:CategService) {


    this.source = new LocalDataSource();
    this.source.load(this.data);

     this.categsrv.getAllCateg().subscribe(categ => {
       console.log(categ);
       
           
      this.categList = categ["result"];
      this.data = this.categList;
      this.source.load(this.categList)
     }, error => console.log(error))

 



   }

  ngOnInit() {
  }


  MyCustom(element:any){
    switch(element.action){
      case "delete":
          this.data = this.data.filter((value,index,arr)=>{
            
            return value!= element.data;  
            
          });
          
          this.source.load(this.data);
          break;
    }
   
 }


 saveCateg(element:any){
  console.log(element);


  this.categsrv.save(element.newData).subscribe((res) => {
    console.log(res["result"]);
    this.data.push(res["result"]);
    this.source.load(this.data);
    Swal.fire({
      title: 'category was created',
      type:'success',
  });
    
  },(err)=>{
    console.log(err);
    Swal.fire({
      title: 'fail to create',
      type:'warning',
  });
    });

  
 }



 save(element:any){
  this.categsrv.update(element.newData,this.id).subscribe((res) => {
    const index = this.data.indexOf(element.data);
    if (index > -1) {
       this.data.splice(index, 1);
    }
    this.data.push(element.newData);
    this.source.load(this.data);
    Swal.fire({
      title: 'category was updated',
      type:'success',
  });
    
  },(err)=>{
    console.log(err);
    Swal.fire({
      title: 'fail to update',
      type:'warning',
  });
    });

  
 }


 delete(element:any){
   console.log("deleting");
   
   this.categsrv.delete(element.data).subscribe((res) => {
    console.log(this.data.indexOf(element.data),this.data);    
    const index = this.data.indexOf(element.data);
if (index > -1) {
   this.data.splice(index, 1);
}
    this.source.load(this.data);
    Swal.fire({
      title: 'category was deleted',
      type:'success',
  });
    
  },(err)=>{
    console.log(err);

  });


 }

}
