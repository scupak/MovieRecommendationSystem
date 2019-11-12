/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.be;

import java.io.Serializable;

/**
 *
 * @author pgn
 */
public class Movie implements Serializable
{

    private final int id;
    private String title;
    private int year;

    public Movie(int id, int year, String title)
    {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
        return "Movie{" + "id=" + id + ", title=" + title + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof Movie){
            
            
            Movie other = (Movie) obj;
            
            return (this.id == other.getId());
        
        
        }
        else{
        
        return super.equals(obj);
        
        
        }
        
    }
    
    
    
    
    

}
