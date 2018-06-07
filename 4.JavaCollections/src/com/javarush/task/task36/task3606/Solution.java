package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        ClassLoaderFromPath classLoader = new ClassLoaderFromPath();
        File[] list = new File(packageName).listFiles();
        for (File f : list) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                String packageName = this.packageName.substring(this.packageName.indexOf("com")).replace("/", ".");
                Class clazz = classLoader.load(f.toPath(), packageName);

                int score = 0;

                Class[] interfaces = clazz.getInterfaces();
                for (Class anInterface : interfaces) {
                    if (anInterface.getSimpleName().equals("HiddenClass")) {
                        score++;
                    }
                }

                Constructor[] constructors = clazz.getDeclaredConstructors();
                for (Constructor constructor : constructors) {
                    if (constructor.getParameterCount() == 0) {
                        score++;
                    }
                }

                if (score == 2){
                    hiddenClasses.add(clazz);
                }

            }
        }
    }


    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class hiddenClass : hiddenClasses) {
            try {
                if(hiddenClass.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                    Constructor[] constructors = hiddenClass.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterCount() == 0){
                            constructor.setAccessible(true);
                            return ((HiddenClass) constructor.newInstance());
                        }
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
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

