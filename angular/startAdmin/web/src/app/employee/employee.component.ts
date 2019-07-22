import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { CategService} from '../services/CategService';



import { LocalDataSource , ViewCell} from 'ng2-smart-table';



@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})

export class EmployeeComponent implements OnInit {
  public categList;
  public selectedOption: string;

  public data = [
    {
      "id":"1",
      "firstName":"med",
      "lastName":"amine",
      "phoneNumber":"99656288",
      "email":"m@m.fr",
      "createdOn":"12/1/2019",
    },
    {
      "id":"3",
      "firstName":"med",
      "lastName":"amine",
      "phoneNumber":"99656288",
      "email":"m@m.fr",
      "createdOn":"12/1/2019",
    },
    {
      "id":"2",
      "firstName":"med",
      "lastName":"amine",
      "phoneNumber":"99656288",
      "email":"m@m.fr",
      "createdOn":"12/1/2019",
    }
  ];

  public settings = {
    mode: 'inline',
    edit: {
      confirmSave: true
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
      firstName: {
        title: 'First Name'
      },

      lastName: {
        title: 'Last Name'
      },
      phoneNumber: {
        title: 'Phone Number'
      },
      email: {
        title: 'Email'
      },
      createdOn: {
        title:'Joined On '
      }
    }
  };

  public source: LocalDataSource;


  constructor(private categsrv:CategService) { 

    var id="ff8080816a3096a4016a309726b70000";

    this.source = new LocalDataSource();
    this.source.load(this.data);

     this.categsrv.getAllCateg(id).subscribe(categ => {
           
      this.categList = categ;
     }, error => console.log(error))





  }

    selectChangeHandler (event: any) {
      this.selectedOption = event.target.value;      
    }

  setUserTable(){

    this.categsrv.getAllUsers(this.selectedOption).subscribe(
      NListUsers =>{
        
      this.source.load(NListUsers);
      console.log(NListUsers);
      
        
      }
    );

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
 Save(element:any){   
  this.data[this.data.indexOf(element.data)] = element.newData;
  this.source.load(this.data);
  
 }
  
    


}
