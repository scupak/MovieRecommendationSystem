/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.gui.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import movierecsys.be.Movie;
import movierecsys.bll.BllManager;
/**
 *
 * @author anton
 */
public class AppModel {
    
   private BllManager bll =  new BllManager();
    private ObservableList<Movie> movies = FXCollections.observableArrayList();
    
    public void fetchData() throws IOException{
    
    movies.clear();
    movies.addAll(bll.getAllMovies());
    
    
    }

    public ObservableList<Movie> getMovies() {
        return movies;
    }
    
    public void deleteMovie(Movie movie) throws IOException{
    
    bll.deleteMovie(movie);
    
    
    
    }
    
   
    
    
}
