/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.overriding;

/**
 *
 * @author Anil Allewar
 */
public class TestAbstractFactory {

    public static void main(String[] args) {
    	
    	DataInfo.DataManager dm = new DataInfo().getDataManager();
        DataInfo[] di = null;
        
        String dbFileName = "db.db";
        if (args.length == 1) {
            //assume local is set to true
	    dm.setConnection(true);
            DataInfo.LocalMode lm = (DataInfo.LocalMode)dm.getLocalConnection(); 
            di = lm.loadDB(dbFileName); 
        } else {  
           //Note: dm.local = false is default setting
           DataInfo.RemoteMode rm = (DataInfo.RemoteMode)dm.getRemoteConnection();
           rm.connect2WWW("www.javacamp.org/db/");
           di = rm.loadDB(dbFileName); 
        }
        //use one set of methods to deal with loaded data.
        //You don't need to worry about connection from this point.
        //Like di.find(), di.search() etc.
    }
}
