package com.example.khotiun.criminalintent.database;

/**
 * Created by hotun on 08.07.2017.
 */

public class CrimeDbSchema {
    public static final class CrimeTable {//Класс CrimeTable существует только для определения строковых констант, необходимых для описания основных частей определения таблицы.
        // Определение начинается с имени таблицы в базе данных CrimeTable.NAME, за которым следуют описания столбцов.
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
