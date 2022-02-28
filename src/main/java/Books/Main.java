package Books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

    public class Main {

        public static void main(String[] args) {
            HashMap<Author, ArrayList<Book>> map = new HashMap<>();
            Map<String, Integer> bookCount = new HashMap<>();
            ArrayList<String> TitleofBook=new ArrayList<String>();
            ArrayList<String> AuthorName=new ArrayList<String>();
            ArrayList<String> BookName=new ArrayList<String>();
            ArrayList<Book> bookhash = null;
            Scanner sc = new Scanner(System.in);

            ArrayList<String> authorName = new ArrayList<>();
            ArrayList<Author> authorArray = new ArrayList<>();
            ArrayList<Book> bookArray = new ArrayList<>();
            Set<String> ba = null;
            Author author;
            Book book;
            String line = "";
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\Library\\src\\main\\resources\\Books.csv"));
                int k=0;
                while ((line = br.readLine()) != null)
                {
                    if(k == 0){
                        k++;
                        continue;
                    }
                    String BookData[] = line.split(";");

                    AuthorName.add(BookData[6]);
                    BookName.add(BookData[8]);
                    if (BookData[6].contains(",")) {
                        String storedata[] = BookData[6].split(",");
                        for (int i = 0; i < storedata.length; i++) {
                            authorName.add(storedata[i]);
                            book = new Book(BookData[8], Double.parseDouble(BookData[7]), Double.parseDouble(BookData[10]));
                            bookArray.add(book);
                        }
                    } else {
                        authorName.add(BookData[6]);
                        book = new Book(BookData[8], Double.parseDouble(BookData[7]), Double.parseDouble(BookData[10]));
                        bookArray.add(book);
                    }
                }
            } catch (
                    IOException e)
            {
                e.printStackTrace();
            }

            for (int i = 0; i < authorName.size(); i++) {
                String author_name = authorName.get(i);
                bookhash = new ArrayList<Book>();
                for (int k = 0; k < authorName.size(); k++) {
                    if (author_name.equals(authorName.get(k))) {
                        bookhash.add(bookArray.get(k));
                    }
                }
                author = new Author(author_name, bookhash);
                authorArray.add(author);
                map.put(author, bookhash);
            }
            Main main1 =new Main();
            int temp=0;
            while (temp!=7) {
                System.out.println(
                        "\n1. Display Book Name in descending order of each author " +
                        "\n2. Display publication year in descending order of each author" +
                        "\n3. Display rating in descending order of each author" +
                        "\n4. Enter Name of book, know who is the author" +
                        "\n5. How many books has an author written" +
                        "\n6. Enter a Date-books written in that year" +
                        "\n7. Exit"
                );
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        main1.sort(authorArray, 1);
                        break;
                    case 2:
                        main1.sort(authorArray, 2);
                        break;
                    case 3:
                        main1.sort(authorArray, 3);
                        break;
                    case 4:
                        System.out.println("Enter Name Of the Book = ");
                        Scanner sc1 = new Scanner(System.in);
                        String bookName = sc1.nextLine();
                        ba = new HashSet<>();
                        for (Author author1 : authorArray) {
                            for (Book book1 : author1.getBook()) {
                                if (book1.getTitle().equals(bookName)) {
                                    ba.add(author1.getName());
                                }
                            }
                        }
                        for (String AutherNametoprint : ba) {
                            System.out.println("Author =" + AutherNametoprint);
                        }
                        break;
                    case 5:
                        System.out.println("Enter Name Of the Author = ");
                        sc = new Scanner(System.in);
                        String autherName = sc.nextLine();
                        ba = new HashSet<>();
                        for (Author author1 : authorArray) {
                            if (author1.getName().equals(autherName)) {
                                for (Book book1 : author1.getBook()) {
                                    ba.add(book1.getTitle());
                                }
                            }
                        }
                        System.out.println(ba.size()+"Books written By" + " = " + autherName);
                        break;
                    case 6:
                        System.out.println("Enter Name Of the Author = ");
                        System.out.println("Enter Year = ");
                        sc = new Scanner(System.in);
                        int year = sc.nextInt();
                        Set<String> nameOfBook = new HashSet<>();
                        for (Author author1 : authorArray) {
                            for (Book book1 : author1.getBook()) {
                                if (book1.getYear() == year) {
                                    nameOfBook.add(book1.getTitle());
                                }
                            }
                        }

                        System.out.println("Books in " + year + " are=");
                        for (String s : nameOfBook) {
                            System.out.println(s);
                        }
                        break;
                    case 7:
                        temp=7;
                        break;
                    default:
                        break;
                }
            }
        }
        public void sort(ArrayList<Author> sortArray, int abc){
            if(abc==1){
                System.out.println("Display Book Name in descending order of each author");
            }else if(abc==2){
                System.out.println("Display publication year in descending order of each author ");
            }else{
                System.out.println("Display Rating in descending order of each author");
            }
            for (int i = 0; i < sortArray.size(); i++) {
                if(abc==1) {
                    Collections.sort(sortArray.get(i).getBook(), new DescAuthorname());
                }else if(abc==2){
                    Collections.sort(sortArray.get(i).getBook(), new DescYearofPublication());
                }else{
                    Collections.sort(sortArray.get(i).getBook(), new DescRatingofBooks());
                }
            }
            for (Author author1 : sortArray) {
                System.out.println("Author = " + author1.getName());
                for (Book book1 : author1.getBook()) {
                    if(abc==1) {
                        System.out.println("Title  =  " + book1.getTitle());
                    }else if(abc==2){
                        System.out.println("Year  = " + book1.getYear());
                    }else {
                        System.out.println("Ratings = " + book1.getRating());
                    }
                }
            }
        }
    }
class DescYearofPublication implements Comparator<Book> {

    public int compare(Book a, Book b)
    {
        return (int) (b.getYear() - a.getYear());
    }
}
class DescAuthorname implements Comparator<Book> {
    public int compare(Book a, Book b)
    {
        return b.getTitle().compareToIgnoreCase(a.getTitle());
    }
}
class DescRatingofBooks implements Comparator<Book> {

    public int compare(Book a, Book b)
    {
        return  Double.compare(b.getRating(), a.getRating());
    }
}

