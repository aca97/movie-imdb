import { Component } from '@angular/core';
import { MovieService } from './movie.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss'],
})
export class MovieComponent {
  movies: any[] = []

  constructor(private _movieServie: MovieService) {}

  ngOnInit() {
    this._movieServie.getMovies().subscribe({
      next: (res) => {
        this.movies = res;
      },
    });
  }
}
