package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;
    public static final String UNIC_BINDING_CAT_NAME = "cat.string";
    public static final String UNIC_BINDING_DOG_NAME = "dog.string";

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            Remote stubCat = null;
            Remote stubDog = null;
            try {
                registry = LocateRegistry.createRegistry(2099);
                final Cat catService = new Cat("Lialka");
                final Dog dogService = new Dog("Sobak");
                stubCat = UnicastRemoteObject.exportObject(catService, 0);
                stubDog = UnicastRemoteObject.exportObject(dogService, 0);
                registry.bind(UNIC_BINDING_CAT_NAME, stubCat);
                registry.bind(UNIC_BINDING_DOG_NAME, stubDog);
            } catch (RemoteException e) {
                System.err.println(e);
            } catch (AlreadyBoundException e) {
                System.err.println(e);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}