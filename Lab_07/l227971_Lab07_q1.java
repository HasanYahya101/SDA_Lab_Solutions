interface Genre {
    void display();
}

class AnimeGenre implements Genre {
    @Override
    public void display() {
        System.out.println("This is the anime genre book info. Read it it's really good");
    }
}

class ThrillerGenre implements Genre {
    @Override
    public void display() {
        System.out.println("No one really likes thriller, but OK!.");
    }
}

class MysteryGenre implements Genre {
    @Override
    public void display() {
        System.out.println("Sherlock Holmes is cool.");
    }
}

class HorrorGenre implements Genre {
    @Override
    public void display() {
        System.out.println("I don't know what to write here.");
    }
}

interface GenreFactory {
    Genre createGenre();
}

class AnimeGenreFactory implements GenreFactory {
    @Override
    public Genre createGenre() {
        return new AnimeGenre();
    }
}

class ThrillerGenreFactory implements GenreFactory {
    @Override
    public Genre createGenre() {
        return new ThrillerGenre();
    }
}

class MysteryGenreFactory implements GenreFactory {
    @Override
    public Genre createGenre() {
        return new MysteryGenre();
    }
}

class HorrorGenreFactory implements GenreFactory {
    @Override
    public Genre createGenre() {
        return new HorrorGenre();
    }
}

class BookStore { // to add new genres without modifying the BookStore class, we can use the factory pattern
    private GenreFactory genreFactory;

    public BookStore(GenreFactory genreFactory) {
        this.genreFactory = genreFactory;
    }

    public void addGenre() {
        Genre genre = genreFactory.createGenre();
        genre.display();
    }
}

public class l227971_Lab07_q1 {
    public static void main(String[] args) {
        GenreFactory fictionGenreFactory = new AnimeGenreFactory();
        BookStore fictionBookStore = new BookStore(fictionGenreFactory);
        fictionBookStore.addGenre();

        GenreFactory nonFictionGenreFactory = new ThrillerGenreFactory();
        BookStore nonFictionBookStore = new BookStore(nonFictionGenreFactory);
        nonFictionBookStore.addGenre();

        GenreFactory mysteryGenreFactory = new MysteryGenreFactory();
        BookStore mysteryBookStore = new BookStore(mysteryGenreFactory);
        mysteryBookStore.addGenre();

        GenreFactory scienceFictionGenreFactory = new HorrorGenreFactory();
        BookStore scienceFictionBookStore = new BookStore(scienceFictionGenreFactory);
        scienceFictionBookStore.addGenre();
    }
}
