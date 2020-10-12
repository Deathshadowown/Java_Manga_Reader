/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Main.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/11 17:00:28 by svan-nie          #+#    #+#             */
/*   Updated: 2020/10/11 17:00:28 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package src;

// import java.awt.Image;
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;
// import javax.imageio.ImageIO;
// import java.awt.Desktop;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try {
            int count = 0;
            File directory = new File("manga_Folder");
            int fileCount = directory.list().length;
            String fileNames[] = directory.list();
            int interateOverFileCount = fileCount;
            String mangaName = null;
            System.out.println("File Count: "+fileCount);
            System.out.println("File Count: "+interateOverFileCount);
            while(true)
            {
                interateOverFileCount = fileCount;
                interateOverFileCount--;
                System.out.println("Type List to get the list of Manga in the folder, and Exit to quit");
                System.out.println("Please Enter Manga Name");
                mangaName = scan.nextLine();
                if (mangaName.toLowerCase().equals("quit")){
                    System.exit(2);
                }
                while (interateOverFileCount >= 0){
                    if (mangaName.toLowerCase().equals("list")){
                        System.out.println("Manga List");
                        System.out.println("######################################################################");
                        while(interateOverFileCount >= 0){
                            System.out.println(fileNames[interateOverFileCount]);
                            interateOverFileCount--;
                        }
                        System.out.println("######################################################################");
                        break;
                    }
                    if (mangaName.equals(fileNames[interateOverFileCount])){
                        System.out.println("First File Name: "+ fileNames[interateOverFileCount]);
                        count++;
                        break;
                    }
                    interateOverFileCount--;
            }
            if (count == 1)
            break;
            }
            System.out.println();
            System.out.println("You have Selected: "+mangaName+" to read enjoy.");
            System.out.println();
            File mangaDirectory = new File("Manga_Folder/"+mangaName);
            int mangaDirectoryCount = mangaDirectory.list().length;
            String mangaDirectoryNames[] = mangaDirectory.list();
            
            System.out.println("Manga Chapters inside folder: "+mangaDirectoryCount);
            mangaDirectoryCount--;
            // System.out.println();
            System.out.println();
            System.out.println("MangaChapter starts from 0 so if mangachapter has 3 chapters it ends at 2");
            System.out.println();
            int mangaChapter = 0;
            while(true){
                System.out.println();
                System.out.println("Manga Chapters inside folder: "+mangaDirectoryCount);
                System.out.println();
                System.out.print("Witch Chapter Would you like to Read: ");
                mangaChapter = scan.nextInt();
                System.out.println();
                if(mangaChapter >= 0 && mangaChapter < mangaDirectoryCount)
                break;
                if (mangaChapter > mangaDirectoryCount || mangaChapter < mangaDirectoryCount)
                System.out.println("Please Select a chapter that is within the chapter amount.");
            }
            System.out.println();
            String nextChapter = null;
            int counter = 0;
            System.out.println("what mangaChapter am i on"+ mangaChapter);
            while (mangaChapter <= mangaDirectoryCount){
                if (counter == 0){
                    File userMangaChapter = new File("Manga_Folder/"+mangaName+"/"+mangaDirectoryNames[mangaChapter]);
                    int userMangaChapterCount = userMangaChapter.list().length;
                    String userMangaChapterName[] = userMangaChapter.list();
                    String path = "C:\\Users\\Deathshadow\\projects\\Java_Projects\\java_manga_reader\\"+"Manga_Folder\\"+mangaName+"\\"+mangaDirectoryNames[mangaChapter]+"\\"+userMangaChapterName[0];
                    Runtime.getRuntime().exec("rundll32.exe C:\\WINDOWS\\System32\\shimgvw.dll,ImageView_Fullscreen "+path);
                    mangaChapter++;
                    counter++;
                }
                System.out.println();
                System.out.println("you Reading Chapter: "+ mangaChapter);
                System.out.println();
                System.out.print("Type next when you done reading your chapter.: ");
                nextChapter = scan.nextLine();
                if (nextChapter.toLowerCase().equals("next")){
                    File userMangaChapter = new File("Manga_Folder/"+mangaName+"/"+mangaDirectoryNames[mangaChapter]);
                    int userMangaChapterCount = userMangaChapter.list().length;
                    String userMangaChapterName[] = userMangaChapter.list();
                    String path = "C:\\Users\\Deathshadow\\projects\\Java_Projects\\java_manga_reader\\"+"Manga_Folder\\"+mangaName+"\\"+mangaDirectoryNames[mangaChapter]+"\\"+userMangaChapterName[0];
                    Runtime.getRuntime().exec("rundll32.exe C:\\WINDOWS\\System32\\shimgvw.dll,ImageView_Fullscreen "+path);
                    mangaChapter++;
                }
            }
            System.out.println();
            System.out.println("you have reached the end of the manga you reading.");
        } catch (InputMismatchException e){
            System.out.println("Please Enter a valid Chapter Number.");
        } 
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Error Please Contract support.");
            System.exit(2);
        }
    }
}