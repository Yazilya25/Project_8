package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    Radio radio = new Radio();


    @Test
    void shouldChangeRadio() {
        Radio radio1 = new Radio(20);

        radio1.setCurrentRadioStation(15);
        assertEquals(15, radio1.getCurrentRadioStation());
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            " 0, 0",
            " 1, 1",
            " 5, 5",
            " 9, 9 ",
            "10, 0"
    })
    void shouldChangeRadioStation(int newCurrentRadioStation, int expected) {

        radio.setCurrentRadioStation(newCurrentRadioStation);

        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            " 0, 1",
            " 1, 2",
            " 5, 6",
            " 8, 9",
            " 9, 0 "
    })
    void shouldNextRadioStation(int newCurrentRadioStation, int expected) {

        radio.setCurrentRadioStation(newCurrentRadioStation);
        radio.nextRadioStation();

        int actual = radio.getCurrentRadioStation();

        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            " 0, 9",
            " 1, 0",
            " 6, 5",
            " 9, 8"
    })
    void shouldPrevRadioStation(int newCurrentRadioStation, int expected) {

        radio.setCurrentRadioStation(newCurrentRadioStation);
        radio.prevRadioStation();

        int actual = radio.getCurrentRadioStation();

        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            " 0, 1",
            " 1, 2",
            " 100, 100"
    })
    void shouldIncreaseVolume(int newCurrentVolume, int expected) {

        radio.setCurrentVolume(newCurrentVolume);
        radio.increaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            " 0, 0",
            " 1, 0",
            " 10, 9"
    })
    void shouldDecreaseVolume(int newCurrentVolume, int expected) {

        radio.setCurrentVolume(newCurrentVolume);
        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(actual, expected);
    }
}

