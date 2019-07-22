import { Component, OnInit } from '@angular/core';

import { CategService} from '../services/CategService';



import { LocalDataSource } from 'ng2-smart-table';

import Swal from 'sweetalert2';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})

export class EmployeeComponent implements OnInit {
  public categList;
  public selectedOption: string;

  public data = [


  ];

  public settings = {
    mode: 'inline',
    add: {
      confirmCreate: true,
    },
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
  user: any;


  constructor(private categsrv:CategService) { 


    this.source = new LocalDataSource();

     this.categsrv.getAllCateg().subscribe(categ => {
           
      this.categList = categ["result"];
    

     }, error => console.log(error))





  }

    selectChangeHandler (event: any) {
      this.selectedOption = event.target.value;      
    }

  setUserTable(){

    this.categsrv.getAllUsers(this.selectedOption).subscribe(
      NListUsers =>{

        
      this.source.load(NListUsers["result"]);     
        
      },(err)=>{
        console.log(err);
        
        Swal.fire({
          title: 'fail to retrieve users ',
          type:'warning',
      });
        
      }
    );

  }

  ngOnInit() {
  }


  MyCustom(element:any){
    switch(element.action){
      case "delete":
          this.data = this.data.filter((value,index,arr)=>{
            //add api call to demet
            return value!= element.data;  
          },(err)=>{
            Swal.fire({
              title: 'fail to delete user',
              type:'warning',
            });
          });
          
          this.source.load(this.data);
          break;
    }
   
 }
 Save(element:any){
  this.data[this.data.indexOf(element.data)] = element.newData;
  this.source.load(this.data);

  
 }
  

 async SaveUser(){
  const {value: formValue} = await Swal.fire({
     title:"add user's phone ",
     input: 'number',
     showCancelButton: true,
     confirmButtonText:"getUser",
   });

  await  Swal.fire({text:"pulling user info ...",onBeforeOpen:()=>{

  this.categsrv.getUserByphoneNumber(formValue).subscribe(resp =>{

  this.user = resp["result"];
  console.log(this.user);
});

  }});
  console.log(this.user);

  const {value: accept} =  await    Swal.fire({
    title:"add user ? ",
    type:"question",
    showCancelButton: true,
    html: 
    "firstName: " + this.user.firstName + "<br> " +
    "lastName: " + this.user.lastName+"<br> " +
    "email: " + this.user.email,
  showCloseButton: true,
    confirmButtonText:"add",
  
});

if (accept){
  console.log("sending");
  
  this.categsrv.sendRequestToUser(this.user.id).subscribe(resp => {
    console.log(resp);
    
  });
}
  






 

   
 }

 async confirmchoice(){

  if (this.user != undefined)
  {
  
 
  
  }
 }
    


}
