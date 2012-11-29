/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.oat.pattern.tree;

/**
 *
 * @author obu
 */
public interface IPathTree {
    //Some constants here
    String PathSeparator  = "/";
    String ContainerLabel = "c";
    String ItemLabel      = "i";
    
    //giving a long number, a path should be generated
    //This path can be used for file system, database, or any 
    //other situation that requires a tree structure
    String getPath(long id);
    
    
    
}
