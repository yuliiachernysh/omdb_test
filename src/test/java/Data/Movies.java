package Data;

import models.Movie;

import java.util.Arrays;
import java.util.List;

public class Movies {
    private List<Movie> movies;

    public Movies(){
        movies = CreateTestMovies();
    }

    public Movie FindMovieByIdAndPlotType(String id, String plotType){
        Movie foundMovie = movies.stream()
                .filter(movie -> id.equals(movie.getId()) && plotType.equals(movie.getPlotType()))
                .findAny()
                .orElse(null);

        return foundMovie;
    }

    private static List<Movie> CreateTestMovies() {
        {
            return Arrays.asList(new Movie[]{
                    new Movie("tt0120338", "Titanic", "1997", "short", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic."),
                    new Movie("tt0120338", "Titanic", "1997", "full", "84 years later, a 100 year-old woman named Rose DeWitt Bukater tells the story to her granddaughter Lizzy Calvert, Brock Lovett, Lewis Bodine, Bobby Buell and Anatoly Mikailavich on the Keldysh about her life set in April 10th 1912, on a ship called Titanic when young Rose boards the departing ship with the upper-class passengers and her mother, Ruth DeWitt Bukater, and her fiancé, Caledon Hockley. Meanwhile, a drifter and artist named Jack Dawson and his best friend Fabrizio De Rossi win third-class tickets to the ship in a game. And she explains the whole story from departure until the death of Titanic on its first and last voyage April 15th, 1912 at 2:20 in the morning."),
                    new Movie("tt0330994", "Titanic: The Legend Goes On...", "2000", "short", "A Cinderella meets her Prince Charming on the ill-fated Titanic. Along for the ride are a rapping dog, other talking animals, and an assortment of wacky humans."),
                    new Movie("tt0499549", "Avatar", "2009", "full", "When his brother is killed in a robbery, paraplegic Marine Jake Sully decides to take his place in a mission on the distant world of Pandora. There he learns of greedy corporate figurehead Parker Selfridge's intentions of driving off the native humanoid \"Na'vi\" in order to mine for the precious material scattered throughout their rich woodland. In exchange for the spinal surgery that will fix his legs, Jake gathers intel for the cooperating military unit spearheaded by gung-ho Colonel Quaritch, while simultaneously attempting to infiltrate the Na'vi people with the use of an \"avatar\" identity. While Jake begins to bond with the native tribe and quickly falls in love with the beautiful alien Neytiri, the restless Colonel moves forward with his ruthless extermination tactics, forcing the soldier to take a stand - and fight back in an epic battle for the fate of Pandora."),
                    new Movie("tt0499549", "Avatar", "2009", "short", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.")
            });
        }
    }
}
