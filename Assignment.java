package Nokia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Assignment
{
    static volatile Map<Character, Integer> m = new ConcurrentHashMap<>();

    static void print_recursively(File[] my_arr, int my_index, int sub_level, List<File> listOfFile)
    {
        if (my_index == my_arr.length)
            return;
        for (int i = 0; i < sub_level; i++)
        {
            System.out.print("\t");
        }
        if (my_arr[my_index].isFile())
        {
            System.out.println(my_arr[my_index].getName());
            listOfFile.add(my_arr[my_index]);
        }
        else if (my_arr[my_index].isDirectory())
        {
            System.out.println("[" + my_arr[my_index].getName() + "]");
            print_recursively(my_arr[my_index].listFiles(), 0, sub_level + 1, listOfFile);
        }
        print_recursively(my_arr, ++my_index, sub_level, listOfFile);
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the Path of Directory From where Character Need to be counted:");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Reading data using readLine
        String path_main = null;
        try
        {
            path_main = reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Please Enter the valid path,ie .For Example :C:\\Assign");
        }


        //Populating static map with lower case latin letters. Occurences of each character is made as 0 initially
        String alphabetArray = "abcdefghijklmnopqrstuvwxyz";
        CountingCharacters c = new CountingCharacters();
        for (Character a : alphabetArray.toCharArray()) //Populating static map with lowerCase Latin Alphabets
        {
            m.put(a, 0);
        }


        File main_dir = new File(path_main);
        List<File> listOfFile = new ArrayList<>();
        //Getting all the files
        if (main_dir.exists() && main_dir.isDirectory())
        {
            File my_arr[] = main_dir.listFiles();
            System.out.println(" Directory Tree is: ");
            print_recursively(my_arr, 0, 0, listOfFile); //Printing all the files from directory and subdirectory.Also, getting listOffiles populated with files.
            //Executor service intialised with processro number
            ExecutorService exec = Executors.newFixedThreadPool(
                    Runtime.getRuntime().availableProcessors());
            for (File file : listOfFile)
            {
                exec.submit(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    c.countNoOfLowerCaseCharacters(file, m);
                                }


                            }
                );
                try
                {
                    exec.awaitTermination(1000, MILLISECONDS);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            exec.shutdown();

            System.out.println("Populated Map is : ");
            for (Map.Entry<Character, Integer> entry : m.entrySet())
            {
                System.out.println(entry.getKey() + " --> " + entry.getValue());

            }
        }


    }

}