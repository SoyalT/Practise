# Practise
Problem statment : Create a Java application performing the following task. The application should read all files in a
directory (including subdirectories) provided as a command line argument. The program should
count the occurrences of lower-case Latin characters [a-z] in the files. The occurrences should be
counted for each character separately (it is enough to support ASCII encoding). Print the output
to stdout.

Example:

Fork multiple threads to efficiently process any number of files (you can assume that a directory
can contain 100 000 files at most). The program should be able to process all the files using limited
amount of memory (e.g., 512Mb). Do not use third-party libraries. Implement the application as a
Maven project.
> tree dir
dir
|__ file1.txt
|__ subdir
|__ file2.txt
> cat dir/file1.txt
abcdefaAAA
> cat dir/subdir/file2.txt
AgBgChDhEF+123


Time taken to solve : 2hrs (saturday,18/06/2022)

wait time for map population is givne as : 1000ms to executor

TestCase Executed : 
1) Files in directory were considered for calculating occurences of lowe case letter
2) Files in sub-directory were considered for calculating occurences of lowe case letter
3) Printing all files in directory aswell sub-directory

*Screen shots of some of the test case exceution is attached![Screenshot (525)](https://user-images.githubusercontent.com/34856822/174466230-c06e215b-e649-4952-aefb-15e8d699ec5f.png)

![Screenshot (524)](https://user-images.githubusercontent.com/34856822/174466238-0ac0f830-5895-408b-acf9-843c859af601.png)

