package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker;
    private SimpleConnector simpleConnector;
    private String resourceString;

    public SecurityProxyConnector(String resourceString) {
        this.resourceString = resourceString;
        this.securityChecker = new SecurityCheckerImpl();
        this.simpleConnector = new SimpleConnector(this.resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck())
            simpleConnector.connect();
    }
}
