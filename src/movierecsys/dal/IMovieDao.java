/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.IOException;
import java.util.List;
import movierecsys.be.Movie;

/**
 *
 * @author pgn
 */
public interface IMovieDao
{
    Movie createMovie(String title, int year) throws DalException;
    
    void deleteMovie(Movie movie) throws DalException;

    List<Movie> getAllMovies() throws DalException;

    void updateMovie(Movie movie) throws DalException;

    void writeAllMovies(List<Movie> allMovies, String fileName) throws DalException;
    
}
