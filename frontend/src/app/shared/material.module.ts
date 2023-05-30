import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatCheckboxModule } from '@angular/material/checkbox';
import {MatMenuModule} from '@angular/material/menu';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatDialogModule,
    MatTooltipModule,
    MatPaginatorModule,
    MatSelectModule,
    MatTableModule,
    MatCheckboxModule,
    MatMenuModule,
    FormsModule,
    ReactiveFormsModule,HttpClientModule
  ],
  exports: [
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatDialogModule,
    MatTooltipModule,
    MatPaginatorModule,
    MatSelectModule,
    MatTableModule,
    MatCheckboxModule,
    MatMenuModule,
    FormsModule,
    ReactiveFormsModule,HttpClientModule
  ],
})
export class MaterialModule {}