package com.javarush.task.task38.task3805;

/* 
Улучшения в Java 7 (multiple exceptions)
*/

public class Solution {
    private Connection connection;

    public Solution() throws SolutionException {
        try {
            connection = new ConnectionMock();
            connection.connect();
        } catch (WrongDataException | ConnectionException e) {

        }
    }

    public void write(Object data) throws SolutionException {
        try {
            connection.write(data);
        } catch (WrongDataException | ConnectionException e) {
        }
    }

    public Object read() throws SolutionException {
        try {
            return connection.read();
        } catch (WrongDataException | ConnectionException e) {

        }
        return null;
    }

    public void disconnect() throws SolutionException {
        try {
            connection.disconnect();
        } catch (WrongDataException | ConnectionException e) {
            throw new SolutionException("WrongDataException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            throw new WrongDataException();
        } catch (WrongDataException e){
            System.out.println(e.getClass().getSimpleName());
        }
    }
}
