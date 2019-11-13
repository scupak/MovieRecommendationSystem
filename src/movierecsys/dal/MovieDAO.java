/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import movierecsys.be.Movie;

/**
 *
 * @author pgn
 */
public class MovieDAO
{

    private static final String MOVIE_SOURCE = "data/movie_titles.txt";

    /**
     * Gets a list of all movies in the persistence storage.
     *
     * @return List of movies.
     * @throws java.io.FileNotFoundException
     */
    public List<Movie> getAllMovies() throws FileNotFoundException, IOException
    {
        List<Movie> allMovies = new ArrayList<>();
        File file = new File(MOVIE_SOURCE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                try
                {
                    Movie mov = stringArrayToMovie(line);
                    allMovies.add(mov);
                } catch (Exception ex)
                {
                    //Do nothing we simply do not accept malformed lines of data.
                    //In a perfect world you should at least log the incident.
                }
            }
        }
        return allMovies;
    }

    /**
     * Reads a movie from a , s
     *
     * @param t
     * @return
     * @throws NumberFormatException
     */
    private Movie stringArrayToMovie(String t)
    {
        String[] arrMovie = t.split(",");

        int id = Integer.parseInt(arrMovie[0]);
        int year = Integer.parseInt(arrMovie[1]);
        String title = arrMovie[2];

        Movie mov = new Movie(id, year, title);
        return mov;
    }

    /**
     * Creates a movie in the persistence storage.
     *
     * @param releaseYear The release year of the movie
     * @param title The title of the movie
     * @return The object representation of the movie added to the persistence
     * storage.
     */
    private Movie createMovie(int releaseYear, String title)
    {
       Path path = new File(MOVIE_SOURCE).toPath();
        int id = -1;
        try ( BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.SYNC, StandardOpenOption.APPEND, StandardOpenOption.WRITE))
        {
            id = getNextAvailableMovieID();
            bw.newLine();
            bw.write(id + "," + releaseYear + "," + title);
        } catch (IOException ex)
        {
            
        }
        return new Movie(id, releaseYear, title);
    }

    
    private int getNextAvailableMovieID() throws IOException 
    {   
        List<Movie> allMovies = getAllMovies();
        if (allMovies == null || allMovies.isEmpty())
        {
            return 1;
        }
        allMovies.sort((Movie arg0, Movie arg1) -> arg0.getId() - arg1.getId());
        int id = allMovies.get(0).getId();
        for (int i = 0; i < allMovies.size(); i++)
        {
            if (allMovies.get(i).getId() <= id)
            {
                id++;
            } else
            {
                return id;
            }
        }
        return id;
    }
    

    /**
     * Deletes a movie from the persistence storage.
     *
     * @param movie The movie to delete.
     */
    public void deleteMovie(Movie movie) throws IOException
    {
        List<Movie> allMovies = getAllMovies();
        if (allMovies.remove(movie))
        {
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter(new File(MOVIE_SOURCE))))
            {
                for (Movie mov : allMovies)
                {
                    bw.write(mov.getId() + "," + mov.getYear() + "," + mov.getTitle());
                    bw.newLine();
                }
            }
        }
    }

    /**
     * Updates the movie in the persistence storage to reflect the values in the
     * given Movie object.
     *
     * @param movie The updated movie.
     */
    private void updateMovie(Movie movie) throws IOException
    {
       List<Movie> allMovies = getAllMovies();
       
        if (allMovies.remove(movie))
        {
            allMovies.add(movie);
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter(new File(MOVIE_SOURCE))))
            {
                for (Movie mov : allMovies)
                {
                    bw.write(mov.getId() + "," + mov.getYear() + "," + mov.getTitle());
                    bw.newLine();
                }
            }
        }
    }

    /**
     * Gets a the movie with the given ID.
     *
     * @param id ID of the movie.
     * @return A Movie object.
     */
    private Movie getMovie(int id)
    {
        //TODO Get one Movie
        return null;
    }

}
