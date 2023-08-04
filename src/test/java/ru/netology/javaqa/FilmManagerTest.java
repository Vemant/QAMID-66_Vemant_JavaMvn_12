package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {
    // ТЕСТ FilmManager()
    @Test
    public void FilmManagerDefault() {
        FilmManager filmManager = new FilmManager();

        int expected = 5;
        int actual = filmManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ FilmManager(int limit)
    // Лимит -3
    @Test
    public void FilmManagerLimitLessThanZero() {
        FilmManager filmManager = new FilmManager(-3);

        int expected = 5;
        int actual = filmManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }
    // Лимит -1
    @Test
    public void FilmManagerLimitOneLessThanZero() {
        FilmManager filmManager = new FilmManager(-1);

        int expected = 5;
        int actual = filmManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }
    // Лимит 0
    @Test
    public void FilmManagerLimitIsZero() {
        FilmManager filmManager = new FilmManager(0);

        int expected = 0;
        int actual = filmManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }
    // Лимит 1
    @Test
    public void FilmManagerLimitOneMoreThanZero() {
        FilmManager filmManager = new FilmManager(1);

        int expected = 1;
        int actual = filmManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }
    // Лимит 3
    @Test
    public void FilmManagerLimitMoreThanZero() {
        FilmManager filmManager = new FilmManager(3);

        int expected = 3;
        int actual = filmManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ addNewFilm и findAll
    // ДОбавление 3-х фильмов
    @Test
    public void AddAnyQuantityOfNewFilms() {
        FilmManager filmManager = new FilmManager();

        filmManager.addNewFilm("F-1");
        filmManager.addNewFilm("F-2");
        filmManager.addNewFilm("F-3");

        String[] expected = { "F-1", "F-2", "F-3" };
        String[] actual = filmManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Добавление 1-го фильма
    @Test
    public void AddOneNewFilm() {
        FilmManager filmManager = new FilmManager();

        filmManager.addNewFilm("F-1");

        String[] expected = { "F-1" };
        String[] actual = filmManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Добавление 0 фильмов
    @Test
    public void AddZeroFilms() {
        FilmManager filmManager = new FilmManager();

        String[] expected = {};
        String[] actual = filmManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // ТЕСТЫ findLast
    //      Длина 4
    // Лимит намного больше длины 4
    @Test
    public void findLastLengthMoreThanZeroLimitMoreThanLength() {
        FilmManager filmManager = new FilmManager(7);

        filmManager.addNewFilm("F-1");
        filmManager.addNewFilm("F-2");
        filmManager.addNewFilm("F-3");
        filmManager.addNewFilm("F-4");

        String[] expected = { "F-4", "F-3", "F-2", "F-1" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит больше длины 4 на 1
    @Test
    public void findLastLengthMoreThanZeroLimitOneMoreThanLength() {
        FilmManager filmManager = new FilmManager(5);

        filmManager.addNewFilm("F-1");
        filmManager.addNewFilm("F-2");
        filmManager.addNewFilm("F-3");
        filmManager.addNewFilm("F-4");

        String[] expected = { "F-4", "F-3", "F-2", "F-1" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит равен длине 4
    @Test
    public void findLastLengthMoreThanZeroLimitIsEqualLength() {
        FilmManager filmManager = new FilmManager(4);

        filmManager.addNewFilm("F-1");
        filmManager.addNewFilm("F-2");
        filmManager.addNewFilm("F-3");
        filmManager.addNewFilm("F-4");

        String[] expected = { "F-4", "F-3", "F-2", "F-1" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит меньше длины 4 на 1
    @Test
    public void findLastLengthMoreThanZeroLimitOneLessThanLength() {
        FilmManager filmManager = new FilmManager(3);

        filmManager.addNewFilm("F-1");
        filmManager.addNewFilm("F-2");
        filmManager.addNewFilm("F-3");
        filmManager.addNewFilm("F-4");

        String[] expected = { "F-4", "F-3", "F-2" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит намного меньше длины 4
    @Test
    public void findLastLengthMoreThanZeroLimitLessThanLength() {
        FilmManager filmManager = new FilmManager(2);

        filmManager.addNewFilm("F-1");
        filmManager.addNewFilm("F-2");
        filmManager.addNewFilm("F-3");
        filmManager.addNewFilm("F-4");

        String[] expected = { "F-4", "F-3" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    //      Длина 1
    // Лимит намного больше длины 1
    @Test
    public void findLastLengthIsOneLimitMoreThanLength() {
        FilmManager filmManager = new FilmManager(5);

        filmManager.addNewFilm("F-1");

        String[] expected = { "F-1" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит больше длины 1 на 1
    @Test
    public void findLastLengthIsOneLimitOneMoreThanLength() {
        FilmManager filmManager = new FilmManager(2);

        filmManager.addNewFilm("F-1");

        String[] expected = { "F-1" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит равен длине 1
    @Test
    public void findLastLengthIsOneLimitIsEqualLength() {
        FilmManager filmManager = new FilmManager(1);

        filmManager.addNewFilm("F-1");

        String[] expected = { "F-1" };
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит меньше длины 1 на 1
    @Test
    public void findLastLengthIsOneLimitOneLessThanLength() {
        FilmManager filmManager = new FilmManager(0);

        filmManager.addNewFilm("F-1");

        String[] expected = {};
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    //      Длина 0
    // Лимит намного больше длины 0
    @Test
    public void findLastLengthIsZeroLimitMoreThanLength() {
        FilmManager filmManager = new FilmManager(5);

        String[] expected = {};
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит больше длины 0 на 1
    @Test
    public void findLastLengthIsZeroLimitOneMoreThanLength() {
        FilmManager filmManager = new FilmManager(1);

        String[] expected = {};
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    // Лимит равен длине 0
    @Test
    public void findLastLengthIsZeroLimitIsEqualLength() {
        FilmManager filmManager = new FilmManager(0);

        String[] expected = {};
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
