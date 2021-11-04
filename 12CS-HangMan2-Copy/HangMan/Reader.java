import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Reader Class - Reads words and definitions from URLs
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class Reader  
{
    //read words from URL and store to list
    public static void readInto(ArrayList<String> list) throws Exception {
        String url = "https://gist.githubusercontent.com/HasheeLeo/e5bd5bbc5213d25340de4809de31c52e/raw/2547c78f0a4a59b6343e87a2d98e71a44731b448/common-words.txt";
        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(wordsURL.openStream()));
        String word;
        while ((word = in.readLine()) != null) 
            list.add(word);
        in.close();
    }
    
    //read word definitions from URL and store to list
    public static void readInto2(ArrayList<String> defList) throws Exception {
        String url = "https://raw.githubusercontent.com/Tanya-Gu/WordDefinition/main/WordsDefi";
        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(wordsURL.openStream()));
        String def;
        while ((def = in.readLine()) != null) 
            defList.add(def);
        in.close();
    }
}
