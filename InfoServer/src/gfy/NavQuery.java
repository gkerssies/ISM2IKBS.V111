/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.image.TileObserver;
import java.io.Serializable;

/**
 *
 * @author Janssen-laptop
 */
public class NavQuery implements Serializable{
  
  private String Title;
  private String Description;
  private int uid;
  
  public NavQuery(String Title,String Description,int uid)
  {
    this.Title = Title;
    this.Description = Description;
    this.uid = uid;
  }
}
