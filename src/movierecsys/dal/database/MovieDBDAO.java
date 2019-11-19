/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal.database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import movierecsys.be.Movie;
import movierecsys.dal.DalException;
import movierecsys.dal.IMovieDao;

/**
 *
 * @author pgn
 */
public class MovieDBDAO implements IMovieDao
{

    private DatabaseConnector dbCon;
    
    public MovieDBDAO() throws IOException
    {
        dbCon = new DatabaseConnector();
    }
    
    
    public static void main(String[] args) throws DalException, IOException
    {
        MovieDBDAO movieDao = new MovieDBDAO();
/*
        List<Movie> allMovies = movieDao.getAllMovies();
        for (Movie allMovy : allMovies)
        {
            System.out.println(allMovy);
        }
*/
               movieDao.createMovie("frozen", 1999);

    }

    @Override
    public List<Movie> getAllMovies() throws DalException
    {
        try (Connection con = dbCon.getConnection())
        {
            String sql = "SELECT * FROM Movie;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Movie> allMovies = new ArrayList<>();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                Movie mov = new Movie(id, year, title);
                allMovies.add(mov);
            }
            return allMovies;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new DalException();
        }
    }

    @Override
    public void deleteMovie(Movie movie) throws DalException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMovie(Movie movie) throws DalException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeAllMovies(List<Movie> allMovies, String fileName) throws DalException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movie createMovie(String title, int year) throws DalException
    {
        try(Connection con = dbCon.getConnection()){
        String sql = "INSERT INTO movie VALUES ('" + title + "',"+ year +");";
        Statement st = con.createStatement();
        int affectedRows = st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        
        if(affectedRows == 1){
            ResultSet rs = st.getGeneratedKeys();
            
           int id = rs.getInt(1);
            
            Movie mov = new Movie(id,year,title);
            return mov;
        
        }
        
        }catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
    }

}
