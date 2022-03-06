/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirkozaper.from.hr.xmlrpc;

import java.io.IOException;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

/**
 *
 * @author mirko
 */
public class Main {
    public static void main(String[] args) throws IOException, XmlRpcException {
        System.out.println("Starting XML-RPC server ...");
        WebServer server=new WebServer(8080);
        
        PropertyHandlerMapping phm=new PropertyHandlerMapping();
        phm.addHandler("Temperature", Temperature.class);
        server.getXmlRpcServer().setHandlerMapping(phm);
        
        XmlRpcServerConfigImpl serverConfig=(XmlRpcServerConfigImpl)server.getXmlRpcServer().getConfig();
        serverConfig.setEnabledForExtensions(true);
        
        server.start();
        System.out.println("XML-RPC server successfully started");
        
    }
    
    
}
