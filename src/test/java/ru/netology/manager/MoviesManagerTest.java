package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterMovies;


import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {
    private MoviesManager manager = new MoviesManager();
    PosterMovies first = new PosterMovies(1,"Бладшот", "Боевик");
    PosterMovies second = new PosterMovies(2, "Вперед", "Мультфильм");
    PosterMovies third = new PosterMovies(3, "Отель 'Белград'", "Комедия");
    PosterMovies fourth = new PosterMovies(4,  "Джентльмены", "Боевик");
    PosterMovies fifth = new PosterMovies(5,  "Человек-невидимка", "Ужасы");
    PosterMovies sixth = new PosterMovies(6,"Тролли. Мировой тур", "Мультфильм");
    PosterMovies seventh = new PosterMovies (7, "Номер один", "Комедия");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

    }

    @Test
    public void addMoviesToEmpty() {
        manager.add(first);
        assertArrayEquals(new PosterMovies[]{first}, manager.getAllMovies());
    }

    @Test
    public void addMoviesToExisted() {
        manager.add(first);
        PosterMovies[] expected = new PosterMovies[]{first};
        PosterMovies[] actual = manager.getAllMovies();
        assertArrayEquals(new PosterMovies[]{first}, manager.getAllMovies());

        manager.add(second);
        PosterMovies[] expectedAdded = new PosterMovies[]{second, first};
        PosterMovies[] actualAdded = manager.getAllMovies();
        assertArrayEquals(expectedAdded, actualAdded);
    }

    @Test
    void moviesForFeed() {
        setUp();
        PosterMovies[] expected = new PosterMovies[]{seventh, sixth, fifth, fourth, third, second, first};
        PosterMovies[] actual = manager.getTenMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void MoviesMinFeed() {
        manager = new MoviesManager(2);
        setUp();
        PosterMovies[] expected = new PosterMovies[]{seventh, sixth};
        PosterMovies[] actual = manager.getTenMovies();
        assertArrayEquals(expected, actual);
    }

}