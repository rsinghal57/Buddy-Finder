import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Buddy } from '../buddy';
import { BuddyService } from '../buddy.service';

@Component({
  selector: 'app-update-buddy',
  templateUrl: './update-buddy.component.html',
  styleUrls: ['./update-buddy.component.css']
})
export class UpdateBuddyComponent implements OnInit {

  id!: number;
  buddy: Buddy = new Buddy();
  constructor(private buddyService:BuddyService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.buddyService.getBuddyById(this.id).subscribe({
      next: (data) => { 
        console.log(data);
      },
        error: (e) => console.error(e),
    })
  }

  onSubmit()
  {
    this.buddyService.updateBuddy(this.id,this.buddy).subscribe({
      next: (data) => { 
        console.log(data);
        this.router.navigate(["/buddies"]);
      },
        error: (e) => console.error(e),
    })
  }


}
