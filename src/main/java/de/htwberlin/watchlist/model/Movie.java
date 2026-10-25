package de.htwberlin.watchlist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    private boolean watched;
    private String recommendBy; //wer hat den Film empfohlen
    private String recommendation; //was dazu gesagt ist
    private String imdbRating; //OMDb-Api in die Zukunft
}


