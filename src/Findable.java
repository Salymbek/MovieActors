import java.util.List;

public interface Findable {
    List<Movie> getAllMovies(List<Movie>movies);
    void findMovieByName(List<Movie>movies,String movieName);
    void findMovieByActorName(List<Movie>movies, String actorName);
    void findMovieByYear(List<Movie>movies,int year);
    void findMovieByDirector(List<Movie>movies, String director);
    void findMoviesAndRolesByActor(List<Movie>movies, String actorName);
    void findMovieByRole(List<Movie>movies, String role);
}