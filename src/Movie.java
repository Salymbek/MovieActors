import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Movie implements Findable,Sortable{
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    public Movie(String name, int year, String description, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    @Override
    public List<Movie> getAllMovies(List<Movie> movies) {
        return movies;
    }

    @Override
    public void findMovieByName(List<Movie> movies, String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().equals(movieName.toLowerCase())){
                System.out.println(movie);
            }
        }
    }

    @Override
    public void findMovieByActorName(List<Movie> movies, String actorName) {
        for (Movie movie : movies) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                if (movie.getCast().get(i).getActorFullName().toLowerCase().contains(actorName.trim().toLowerCase())){
                    System.out.println(movie);
                }
            }
        }
    }

    @Override
    public void findMovieByYear(List<Movie> movies, int year) {
        for (Movie movie : movies) {
            if (movie.getYear() == year) {
                System.out.println(movie);
            }
        }
    }

    @Override
    public void findMovieByDirector(List<Movie> movies, String director) {
        for (Movie movie : movies) {
            String fullName = movie.getDirector().getName() + " " + movie.getDirector().getLastName();
            if (fullName.trim().toLowerCase().contains(director.trim().toLowerCase())) {
                System.out.println(movie);
            }
        }
    }

    @Override
    public void findMoviesAndRolesByActor(List<Movie> movies, String actorName) {
        int counter = 0;
        for (Movie movie : movies) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                if (movie.getCast().get(i).getActorFullName().toLowerCase().contains(actorName.toLowerCase())){
                    counter ++;
                    if(counter == 1) {
                        System.out.println(
                                "\n------------------------------------------------------------" +
                                        "\n              Actor: " + movie.getCast().get(i).getActorFullName() +
                                        "\n------------------------------------------------------------");
                    }

                    System.out.println(
                            "\nMovie: " + movie.getName() +
                                    "\nRole: " + movie.getCast().get(i).getRole() +
                                    "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
        }
    }

    @Override
    public void findMovieByRole(List<Movie> movies, String role) {
        for (Movie movie : movies) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                if (movie.getCast().get(i).getRole().toUpperCase().equals(role.toUpperCase())){
                    System.out.println(movie);
                }
            }
        }
    }

    @Override
    public void sortByMovieName(List<Movie> movies, int num) {
        switch (num) {
            case 1 -> {
                Collections.sort(movies, Movie.sortByMovieNameAtoZ);
                movies.forEach(System.out::println);
            }

            case 2 -> {
                Collections.sort(movies, Movie.getSortByMovieNameZtoA);
                movies.forEach(System.out::println);
            }
        }
    }
    public static Comparator<Movie> sortByMovieNameAtoZ = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Movie> getSortByMovieNameZtoA = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    @Override
    public void sortByYear(List<Movie> movies, int num) {
        switch (num){
            case 1 -> {
                movies.sort(Movie.sortByYearAscending);
                for (Movie movie : movies) {
                    System.out.println(
                            "\nYear: " + movie.getYear() +
                                    "\nName: " + movie.getName() +
                                    "\nDescription: " + movie.getDescription() +
                                    "\nDirector: " + movie.getDirector() +
                                    "\n* Cast of " + movie.getName() + " *" + movie.getCast() +
                                    "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    );
                }

            }
            case 2 -> {
                movies.sort(Movie.sortByYearDescending);
                for (Movie movie : movies) {
                    System.out.println(
                            "\nYear: " + movie.getYear() +
                                    "\nName: " + movie.getName() +
                                    "\nDescription: " + movie.getDescription() +
                                    "\nDirector: " + movie.getDirector() +
                                    "\n* Cast of " + movie.getName() + " *" + movie.getCast() +
                                    "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    );
                }
            }
        }
    }
    public static Comparator<Movie> sortByYearAscending = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getYear() - o2.getYear();
        }
    };
    public static Comparator<Movie> sortByYearDescending = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.getYear() - o1.getYear();
        }
    };

    @Override
    public void sortByDirector(List<Movie> movies, int num) {
        switch (num){
            case 1 -> {
                Collections.sort(movies,Movie.sortByDirectorAtoZ);
                for (Movie movie : movies) {
                    System.out.println(
                            "\nDirector: " + movie.getDirector() +
                                    "\nName: " + movie.getName() +
                                    "\nYear: " + movie.getYear() +
                                    "\nDescription: " + movie.getDescription() +
                                    "\n* Cast of " + movie.getName() + " *" + movie.getCast() +
                                    "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    );
                }
            }
            case 2 -> {
                movies.sort(Movie.sortByDirectorZtoA);
                for (Movie movie : movies) {
                    System.out.println(
                            "\nDirector: " + movie.getDirector() +
                                    "\nName: " + movie.getName() +
                                    "\nYear: " + movie.getYear() +
                                    "\nDescription: " + movie.getDescription() +
                                    "\n* Cast of " + movie.getName() + " *" + movie.getCast() +
                                    "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    );
                }
            }
        }
    }

    public static Comparator<Movie> sortByDirectorAtoZ = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getDirector().getName().compareTo(o2.getDirector().getName());
        }
    };
    public static Comparator<Movie> sortByDirectorZtoA = new Comparator<Movie>(){
        @Override
        public int compare(Movie o1, Movie o2){
            return o2.getDirector().getName().compareTo(o1.getDirector().getName());
        }
    };
    @Override
    public void sortAllActors(List<Movie> movies) {
        for (Movie movie : movies) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                System.out.println("Actor: " + movie.getCast().get(i).getActorFullName());
                System.out.println("Role: " + movie.getCast().get(i).getRole());
                System.out.println("Movie: " + movie.getName());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }

    @Override
    public String toString() {
        return  "\nName: " + name +
                "\nYear: " + year +
                "\nDescription: " + description +
                "\nDirector: " + director +
                "\n* Cast of " + getName() + " *" + getCast() +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}