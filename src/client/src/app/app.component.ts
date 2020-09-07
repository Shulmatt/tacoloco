// Angular
import { Component, ViewEncapsulation, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  encapsulation: ViewEncapsulation.None,
  selector: 'app-root',
  styleUrls: ["./app.component.scss"],
  templateUrl: "./app.component.html"
})
export class AppComponent implements OnInit {
  public form: FormGroup;
  public orderAmount: any;

  constructor(
    private formBuilder: FormBuilder,
    private httpClient: HttpClient
  ) {}
  public ngOnInit(): void {
    this.initComponent();
  }
  
  public initComponent(): void {
    this.form = this.formBuilder.group({
      veggieTaco: [0, Validators.required],
      chickenTaco: [0, Validators.required],
      beefTaco: [0, Validators.required],
      chorizoTaco: [0, Validators.required],
    });
  }

  public submit(): void {
    if (!this.form.valid) {
      return;
    }
    
    this.httpClient.post('tacos/calculate', this.form.getRawValue(), { responseType: 'json', observe: 'response'})
    .subscribe(response => {
      this.orderAmount = response.body;
    });
  }
}
