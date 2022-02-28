package Books;

import java.util.Comparator;

public class Book {
        private String title;
        private double year;
        private double rating;
        private Author author;


        public Book(){
            String title="";
            double year=0;
            double rating=0.0;
            String Name=" ";
        }

        public Book(String title, double year, double rating) {
            this.title = title;
            this.year = year;
            this.rating = rating;
            this.author = author;
        }


        public String getTitle() {
            return title;
        }

        public double getYear() {
            return year;
        }

        public double getRating() {
            return rating;
        }
    }






