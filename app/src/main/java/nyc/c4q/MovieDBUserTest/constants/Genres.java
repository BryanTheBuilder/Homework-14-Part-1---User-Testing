package nyc.c4q.MovieDBUserTest.constants;

/**
 * Created by Shant on 1/9/2018.
 */

public enum Genres {
    ACTION(28,"Action"),
    ADVENTURE(12,"Adventure"),
    ANIMATION(16,"Animation"),
    COMEDY(35,"Comedy"),
    CRIME(80,"Crime"),
    DOCUMENTARY(99,"Documentary"),
    DRAMA(18,"Drama"),
    FAMILY(10751,"Family"),
    FANTASY(14,"Fantasy"),
    HISTORY(36,"History"),
    HORROR(27,"Horror"),
    MUSIC(10402,"Music"),
    MYSTERY(9648,"Mystery"),
    ROMANCE(10749,"Romance"),
    SCIENCE_FICTION(878,"Science Fiction"),
    TV_MOVIE(10770,"TV Movie"),
    THRILLER(53,"Thriller"),
    WAR(10752,"War"),
    WESTERN(37,"Western");


    private int id;
    private String genre;

    Genres(int i, String genre) {
        this.genre = genre;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}

