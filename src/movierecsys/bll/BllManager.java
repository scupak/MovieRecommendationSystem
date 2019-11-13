/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.bll;

import java.io.IOException;

import java.util.List;
import movierecsys.be.Movie;
import movierecsys.dal.MovieDAO;


/**
 *
 * @author anton
 */
public class BllManager {
    MovieDAO dalmanager = new MovieDAO();
    
    public List<Movie>getAllMovies() throws IOException{
    
     return dalmanager.getAllMovies();
    
    
    }
    public void deleteMovie(Movie movie) throws IOException{
    
    dalmanager.deleteMovie(movie);
    
    
    
    }
    
}
