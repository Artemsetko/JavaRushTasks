package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws IOException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // out.writeObject(stream.getFD());
        // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // File file = new File((String) in.readObject());
        this.stream = new FileOutputStream(fileName, true);
        // in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(solution.stream);
        outputStream.writeObject(solution);
        outputStream.writeObject("11");
        outputStream.flush();
        outputStream.close();

        ObjectInputStream oistream = new ObjectInputStream(new FileInputStream(solution.fileName));
        Solution solution1 = (Solution) oistream.readObject();
        String eleven = (String) oistream.readObject();

        System.out.println("11".equals(eleven));
        System.out.println(solution.fileName.equals(solution1.fileName));

    }
}
