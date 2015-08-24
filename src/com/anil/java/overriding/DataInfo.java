/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.overriding;

/**
 *
 * @author Anil Allewar
 */
public class DataInfo {
	
	interface Local {
		  DataInfo[] loadDB(String filename);
		}

		interface Remote extends Local{
		  void connect2WWW(String url);
		}

		class LocalMode implements Local {
		  public DataInfo[] loadDB(String name) {
		    System.out.print("Load from a local database ");
		    return null;
		  }
		}

		class RemoteMode implements Remote {
		  public void connect2WWW(String url) {
		    System.out.println("Connect to a remote site ");
		  }
		  public DataInfo[] loadDB(String name) {
		     System.out.println("Load from a remote database ");
		     return null;
		  }
		}

//		 The Abstract Factory
		interface ConnectionFactory {
		  Local getLocalConnection();
		  Remote getRemoteConnection();
		}

		class DataManager implements ConnectionFactory {
		    boolean local = false;
		    DataInfo[] data;
		    //...
		    public Local getLocalConnection() {
		        return new LocalMode();
		    }
		    public Remote getRemoteConnection() {
		        return new RemoteMode();
		    }
		    public  void loadData() {
		         if(local){
		            Local conn = getLocalConnection();
		            data = conn.loadDB("db.db");
		         }else {
		            Remote conn = getRemoteConnection();
		            conn.connect2WWW("www.some.where.com");
		            data = conn.loadDB("db.db");
		         }
		         
		     }
			 // work on data 
		   
		    public void setConnection(boolean b) {
		       local = b;
		    }
		}
		
		public DataManager getDataManager(){
			return new DataManager();
		}
}

