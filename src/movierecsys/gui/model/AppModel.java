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
    private ObservableList<Movie> inmates = FXCollections.observableArrayList();
    
    public void fetchData() throws IOException{
    
    inmates.clear();
    inmates.addAll(bll.getAllMovies());
    
    
    }

    public ObservableList<Movie> getInmates() {
        return inmates;
    }
    
    public void deleteMovie(Movie movie){
    
    bll.deleteMovie(movie);
    
    
    
    }
    
   
    
    
}
