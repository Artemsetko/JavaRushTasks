package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        Solution solution = new Solution();

        os.writeObject(solution);
        os.writeInt(solution.node);
        os.writeInt(solution.edges.size());
        for (Solution edge : solution.edges) {
            os.writeObject(edge);
        }
        os.flush();

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        Solution solution1 = (Solution) ois.readObject();
        solution1.node = ois.readInt();
        int size = ois.readInt();
        solution1.edges = new LinkedList<Solution>();
        for (int i = 0; i < size; i++) {
            solution1.edges.add((Solution) ois.readObject());
        }


    }
}
