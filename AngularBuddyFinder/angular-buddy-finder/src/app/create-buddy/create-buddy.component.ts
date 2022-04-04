import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Buddy } from '../buddy';
import { BuddyService } from '../buddy.service';

@Component({
  selector: 'app-create-buddy',
  templateUrl: './create-buddy.component.html',
  styleUrls: ['./create-buddy.component.css']
})
export class CreateBuddyComponent implements OnInit {

  buddy: Buddy = new Buddy();

  constructor(private buddyService: BuddyService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    this.saveBuddy();
  }

  saveBuddy() {
    // this.buddyService.createBuddy(this.buddy).subscribe(data => {
    //   console.log(data);
    // },
    //   error => console.log(error));
  this.buddyService.createBuddy(this.buddy).subscribe({
    next: (data) => { 
      console.log(data);
      this.router.navigate(["/buddies"]);
    },
      error: (e) => console.error(e),
    });
  }

}

