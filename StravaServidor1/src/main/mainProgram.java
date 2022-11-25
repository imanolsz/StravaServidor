package main;

import java.rmi.Naming;

import remote.IremoteFacade;
import remote.remoteFacade;



public class mainProgram {

	public static void main(String[] args) {	
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		
		try {
			IremoteFacade remoteFacade = new remoteFacade();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * eAuction Server v1 '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # eAuction Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}

