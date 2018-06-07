package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        HashSet<Animal> resultSet = new HashSet<>();
        File[] list = new File(pathToAnimals).listFiles();
        for (File f : list) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                String packageName = Solution.class.getPackage().getName() + ".data";
                Class clazz = new ClassLoaderFromPath().load(f.toPath(), packageName);

                int score = 0;

                //find Interface Animal
                Class[] interfaces = clazz.getInterfaces();
                for (Class anInterface : interfaces) {
                    if (anInterface.getSimpleName().toString().equals("Animal")) {
                        score++;
                        break;
                    }
                }

                //find constructor with no-args.
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor constructor : constructors) {
                    if (constructor.getParameterCount() == 0) {
                        score++;
                    }
                }

                //add to result Set
                if (score == 2) {
                    try {
                        Animal animal = (Animal) clazz.newInstance();
                        resultSet.add(animal);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return resultSet;
    }

    public static class ClassLoaderFromPath extends ClassLoader {

        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] classBytes = Files.readAllBytes(path);
                return defineClass(className, classBytes, 0, classBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
