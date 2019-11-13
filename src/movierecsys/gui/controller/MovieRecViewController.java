/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import movierecsys.be.Movie;
import movierecsys.gui.model.AppModel;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class MovieRecViewController implements Initializable {

    @FXML
    private TextField txtMovieTitle;
    @FXML
    private TextField txtMovieYear;
    @FXML
    private TextField txtSelectedMovieTitle;
    @FXML
    private TextField txtSelectedMovieYear;
    @FXML
    private TextField txtMovieSearch;
    @FXML
    private ListView<Movie> lstMovies;
    @FXML
    private TextField txtUserSearch;
    @FXML
    private ListView<?> lstUsers;
    @FXML
    private RadioButton radioRatingMinus5;
    @FXML
    private RadioButton radioRatingMinus3;
    @FXML
    private RadioButton radioRating1;
    @FXML
    private RadioButton radioRating3;
    @FXML
    private RadioButton radioRating5;
    @FXML
    private ListView<?> lstRecommendedMovies;
    
    private AppModel model = new AppModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            model.fetchData();
        } catch (IOException ex) {
            Logger.getLogger(MovieRecViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lstMovies.setItems(model.getMovies());
    }    

    @FXML
    private void handleAddMovie(ActionEvent event) {
    }

    @FXML
    private void handleUpdateMovie(ActionEvent event) {
    }

    @FXML
    private void handleDeleteMovie(ActionEvent event) {
        
        
    }

    @FXML
    private void handleSearchMovie(KeyEvent event) {
    }

    @FXML
    private void handleSearchUser(KeyEvent event) {
    }

    @FXML
    private void handleUserRateMovie(ActionEvent event) {
    }
    
}
