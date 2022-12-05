import java.util.List;

public interface Sortable {
    void sortByMovieName(List<Movie> movies, int num);

    void sortByYear(List<Movie> movies, int num);

    void sortByDirector(List<Movie> movies, int num);

    void sortAllActors(List<Movie> movies);


}