package Nokia;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class CountingCharacters extends  Thread
{
    synchronized void countNoOfLowerCaseCharacters(File file,Map<Character,Integer>m)
    {
        try
        {// Condition holds true till
            // there is character in a string
            Scanner myReader= new Scanner(file);
            while(myReader.hasNextLine())
            {
                String data= myReader.nextLine();
                for (int i=0;i<data.length();i++)
                {
                    if (m.containsKey(data.charAt(i)))
                    {
                        m.put(data.charAt(i),m.get(data.charAt(i))+1);
                    }
                }
            }
        }
        catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

    }



}

