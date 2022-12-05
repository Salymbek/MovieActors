import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cast> actors1 = new ArrayList<>();
        actors1.add(new Cast("Some Girl","Angry Fae"));
        actors1.add(new Cast("David Tennant", "Crowley"));

        List<Cast> actors2 = new ArrayList<>();
        actors2.add(new Cast("David Tennant", "Crowley"));
        actors2.add(new Cast("Una Stubs", "Mrs. Hudson"));

        List<Cast> actors3 = new ArrayList<>();
        actors3.add(new Cast("Daniel Radcliffer", "Harry Potter"));
        actors3.add(new Cast("Tom Holland","Spider Man"));

        List<Cast> actors4 = new ArrayList<>();
        actors4.add(new Cast("Macaulay Culkin", "Kevin McKal"));

        List<Cast> actors5 = new ArrayList<>();
        actors5.add(new Cast("Richard Armitage", "Thorin"));
        actors5.add(new Cast("Lee Pace", "Thranduil"));

        List<Cast> actors6 = new ArrayList<>();
        actors6.add(new Cast("Lee Pace", "Thranduil"));
        actors6.add(new Cast("Some Girl","Angry Fae"));

        List<Cast> actors7 = new ArrayList<>();
        actors7.add(new Cast("Chris Hemsworth", "Thor"));
        actors7.add(new Cast("Tom Holland","Spider Man"));

        List<Cast> actors8 = new ArrayList<>();
        actors8.add(new Cast("Keanu Reeves", "Neo"));
        actors8.add(new Cast("Carrie Moss", "Trinity"));


        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Carnival Row", 2019, "TV series", new Director("Some","Director"), actors1));
        movies.add(new Movie("Good omens",2019, "TV series",new Director("Douglas", "Mackinnon"), actors2));
        movies.add(new Movie("Harry Potter", 2005, "movie", new Director("Happy", "Guy"), actors3));
        movies.add(new Movie("Home Alone", 1990, "movie", new Director("Christopher", "Columbus"), actors4));
        movies.add(new Movie("The Hobbit: The Desolation of Smaug", 2013, "movie", new Director("Peter", "Jackson"), actors5));
        movies.add(new Movie("The Hobbit: The Battle of the Five Armies", 2014, "movie", new Director("Peter", "Jackson"), actors6));
        movies.add(new Movie("Avengers: Endgame", 2019, "movie", new Director("Anthony", "Russo"), actors7));
        movies.add(new Movie("The Matrix", 1999, "movie", new Director("Laurence", "Wachowski"), actors8));


        search(movies);
    }

    private static void search(List<Movie> movies) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            commands();
            Movie movie = new Movie();
            int num = scanner1.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println("======================= ALL MOVIES =======================");
                    movie.getAllMovies(movies).forEach(System.out::println);

                }
                case 2 -> {
                    System.out.println("Write movie's name:");
                    String word = scanner.nextLine();
                    movie.findMovieByName(movies, word);
                }
                case 3 -> {
                    System.out.println("Press 1 to sort by ascending\nPress 2 to sort by descending");
                    int number = scanner.nextInt();
                    movie.sortByYear(movies, number);
                }
                case 4 -> {
                    System.out.println("Press 1 to sort by A to Z\nPress 2 to sort by Z to A");
                    int number = scanner.nextInt();
                    movie.sortByMovieName(movies, number);
                }
                case 5 -> {
                    System.out.println("Press 1 to sort by A to Z\nPress 2 to sort by Z to A");
                    int number = scanner.nextInt();
                    movie.sortByDirector(movies, number);
                }
                case 6 -> {
                    System.out.println("Write actor's name:");
                    String word = scanner.nextLine();
                    movie.findMovieByActorName(movies, word);
                }
                case 7 -> {
                    System.out.println("Write director's name:");
                    String word = scanner.nextLine();
                    movie.findMovieByDirector(movies, word);
                }
                case 8 -> {
                    System.out.println("Write year:");
                    int number = scanner.nextInt();
                    movie.findMovieByYear(movies, number);
                }
                case 9 -> {
                    System.out.println("Write role: ");
                    String word = scanner.nextLine();
                    movie.findMovieByRole(movies, word);
                }
                case 10 -> {
                    System.out.println("Write actor's name:");
                    String word = scanner.nextLine();
                    movie.findMoviesAndRolesByActor(movies, word);
                }
                case 11 -> movie.sortAllActors(movies);
            }
        }
    }
    public static void commands(){
        System.out.println("""
                 ====================== Commands =======================
                ||Press 1 to print catalog                               ||
                ||Press 2 to find a movie by full or part name           ||
                ||Press 3 to sort by year                                ||
                ||Press 4 to sort by name                                ||
                ||Press 5 to sort by director                            ||
                ||Press 6 to find movies by actor's name                 ||
                ||Press 7 to find movies by director's name              ||
                ||Press 8 to find movies by year                         ||
                ||Press 9 to find movies by role                         ||
                ||Press 10 to list all movies and roles by actor's name  ||
                ||Press 11 to sort list of all actors with his roles     ||
                 =======================================================""");
    }
}