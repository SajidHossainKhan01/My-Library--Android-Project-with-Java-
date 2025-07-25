package org.meicde.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVOURITE_BOOKS = "favourite_books";
    private SharedPreferences sharedPreferences;


//    private static ArrayList<Book> allBooks;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyReadingBooks;
//    private static ArrayList<Book> favoriteBooks;

    private Utils(Context context) {

        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(null == getAllBooks()){
            initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == getAlreadyReadBooks()){
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getCurrentlyReadingBooks()){
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getFavoriteBooks()){
            editor.putString(FAVOURITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {
        //TODO: add initial data

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(
                1,
                "Java: How To Program",
                "PAUL DEITEL, HARVEY DEITEL",
                1535,
                "https://m.media-amazon.com/images/I/41wujZsYJ+L._SX379_BO1,204,203,200_.jpg",
                "Vice President and Editorial Director: Marcia J. Horton\n" +
                        "Editor-in-Chief: Michael Hirsch\n" +
                        "Associate Editor: Carole Snyder\n" +
                        "Vice President, Marketing: Patrice Jones\n" +
                        "Marketing Manager: Yezan Alayan\n" +
                        "Senior Marketing Coordinator: Kathryn Ferranti\n" +
                        "Vice President, Production: Vince O’Brien\n" +
                        "Managing Editor: Jeff Holcomb\n" +
                        "Associate Managing Editor: Robert Engelhardt\n" +
                        "Operations Specialist: Lisa McDowell\n" +
                        "Art Director: Linda Knowle\n" +
                        "Cover Design: Abbey S. Deitel, Harvey M. Deitel, Marta Samsel\n" +
                        "Cover Photo Credit: © Gonzalo E. Brea/Flickr/Getty Images\n" +
                        "Media Editor: Daniel Sandin\n" +
                        "Media Project Manager: Wanda Rockwell",
                "The authors and publisher of this book have used their best efforts in preparing this book. These efforts include the\n" +
                        "\n" +
                        "development, research, and testing of the theories and programs to determine their effectiveness. The authors and pub-\n" +
                        "lisher make no warranty of any kind, expressed or implied, with regard to these programs or to the documentation\n" +
                        "\n" +
                        "contained in this book. The authors and publisher shall not be liable in any event for incidental or consequential dam-\n" +
                        "ages in connection with, or arising out of, the furnishing, performance, or use of these programs.\n" +
                        "\n" +
                        "Copyright © 2012, 2009, 2007, 2005, 2003 Pearson Education, Inc., publishing as Prentice Hall. All rights reserved.\n" +
                        "Manufactured in the United States of America. This publication is protected by Copyright, and permission should be\n" +
                        "obtained from the publisher prior to any prohibited reproduction, storage in a retrieval system, or transmission in any\n" +
                        "form or by any means, electronic, mechanical, photocopying, recording, or likewise. To obtain permission(s) to use\n" +
                        "material from this work, please submit a written request to Pearson Education, Inc., Permissions Department, 501\n" +
                        "Boylston Street, Suite 900, Boston, Massachusetts 02116.\n" +
                        "Many of the designations by manufacturers and sellers to distinguish their products are claimed as trademarks. Where\n" +
                        "those designations appear in this book, and the publisher was aware of a trademark claim, the designations have been\n" +
                        "printed in initial caps or all caps.",
                "java_book.pdf"
        ));
        books.add(new Book(
                2,
                "Fundamentals of Electric Circuits",
                "Charles K. Alexander, Matthew N.O Sadiku",
                998,
                "https://lms.su.edu.pk/storage/uploads/1588498236-cover-page.JPG",
                "Vice President & Editor-in-Chief: Marty Lange\n" +
                        "Vice President & Director of Specialized Publishing: Janice M. Roerig-Blong\n" +
                        "Editorial Director: Michael Lange\n" +
                        "Publisher: Raghothaman Srinivasan\n" +
                        "Marketing Manager: Curt Reynolds\n" +
                        "Developmental Editor: Lora Neyens\n" +
                        "Project Manager: Joyce Watters/Lisa Bruflodt\n" +
                        "Design Coordinator: Margarite Reynolds\n" +
                        "Cover Designer: Studio Montage, St. Louis, Missouri\n" +
                        "Cover Image Credit: NASA. Artist’s Concept of Rover on Mars\n" +
                        "Buyer: Sherry L. Kane\n" +
                        "Media Project Manager: Balaji Sundararaman\n" +
                        "Compositor: MPS Limited, a Macmillan Company\n" +
                        "Typeface: 10/12 Times Roman\n" +
                        "Printer: RR Donnelly",
                "A model for magnetic coupling is presented in Chapter 13 that will make\n" +
                        "\n" +
                        "analysis easier as well as enhance your ability to find errors. We have suc-\n" +
                        "cessfully used this model for years and felt it was now time to add it to\n" +
                        "\n" +
                        "the book. In addition, there are over 600 new end-of-chapter problems,\n" +
                        "changed end-of-chapter problems, and changed practice problems.\n" +
                        "We have also added National Instruments MultisimTM solutions for\n" +
                        "almost all of the problems solved using PSpice®. There is a Multisim\n" +
                        "tutorial available on our website. We have added National Instruments\n" +
                        "Multisim since it is very user-friendly with many more options for\n" +
                        "analysis than PSpice. In addition, it allows the ability to modify circuits\n" +
                        "easily in order to see how changing circuit parameters impacts voltages,\n" +
                        "\n" +
                        "currents, and power. We have also moved the tutorials for PSpice, MAT-\n" +
                        "LAB®, and KCIDE to our website to allow us to keep up with changes\n" +
                        "\n" +
                        "in the software.\n" +
                        "We have also added 43 new problems to Chapter 16. We did this\n" +
                        "to enhance using the powerful s-domain analysis techniques to finding\n" +
                        "voltages and currents in circuits.",
                "eee.pdf"
        ));
        books.add(new Book(3,"1Q84","Haruki Murakami",1350,"https://jameskennedymonash.files.wordpress.com/2013/01/1q84-cover.jpg",
                "A work of maddenig brilliance", "Long Description", null));
        books.add(new Book(4,"ELECTRICAL ENGINEERS","Alexandar",1350,"https://images.interestingengineering.com/img/iea/V0OyLWZ2wQ/51exflyfrol-sx384-bo1204203200.jpg",
                "A great book on electrical engineering should be easy to understand, cover a broad variety of topics, and include practical and theoretical applications. ", "Long Description",
                null));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.commit();

    }

    public static Utils getInstance(Context context) {
        if (null != instance){
            return instance;
        }else{
            instance =new Utils(context);
            return instance;
        }
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null),type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS, null),type);
        return books;
    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS, null),type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS, null),type);
        return books;
    }

    public ArrayList<Book> getFavoriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVOURITE_BOOKS, null),type);
        return books;
    }

    public Book getBookById(int id){
        ArrayList<Book> books = getAllBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == id){
                    return b;
                }
            }
        }
        return null;
    }
    //TODO: Start from here video time: 2:52:47;
    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addWantToRead (Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToFavourite (Book book) {
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVOURITE_BOOKS);
                editor.putString(FAVOURITE_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToCurrentlyReadingBook (Book book) {
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromWantToRead (Book book) {
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromCurrentlyReading (Book book) {
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromFavourites (Book book) {
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVOURITE_BOOKS);
                        editor.putString(FAVOURITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
