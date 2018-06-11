package com.davissylvester.musicalstructuralappjava.DomainClasses;

public class Song {
    public String Name;
    public Artist Artist;
    public String Genre;
    public String Url = null;

    public Song(String name, Artist artist, String genre, String url) {

        Name = name;
        Artist = artist;
        Genre = genre;
        Url = url;
    }

}
