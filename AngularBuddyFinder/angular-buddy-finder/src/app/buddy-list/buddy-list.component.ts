import { Component, OnInit } from '@angular/core';
import { Buddy } from '../buddy';
import { BuddyService } from '../buddy.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-buddy-list',
  templateUrl: './buddy-list.component.html',
  styleUrls: ['./buddy-list.component.css']
})
export class BuddyListComponent implements OnInit {

  buddies!: Buddy[];
  searchCity!: string;
  searchName!: string;
  constructor(private buddyService: BuddyService, private router:Router) { }

  private getBuddies()
  {
    console.log("working");
    
    this.buddyService.getBuddiesList().subscribe(data => {
      this.buddies = data;
    });
  }

  updateBuddy(id:number)
  {
    this.router.navigate(["update-buddy", id]);
  }

  deleteBuddy(id: number)
  {
    this.buddyService.deleteBuddy(id).subscribe(data => {
      console.log(data);
      // window.location.reload();
      this.getBuddies();
    })
  }

  ngOnInit(): void {
    this.getBuddies();
  }

  searchByCity()
  {
    if (this.searchCity == "") {
      this.ngOnInit();
    }
    else {
      this.buddies = this.buddies.filter(res => {
        return res.companyCity.toLocaleLowerCase().match(this.searchCity.toLocaleLowerCase());
      });
    }
  }

  searchByName()
  {
    if (this.searchName == "") {
      this.ngOnInit();
    }
    else {
      this.buddies = this.buddies.filter(res => {
        return res.companyName.toLocaleLowerCase().match(this.searchName.toLocaleLowerCase());
      });
    }
  }

}
