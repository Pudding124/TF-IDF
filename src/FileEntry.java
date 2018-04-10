import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileEntry {
    public static void main(String[] args){
        try{
            File file = new File("C:\\Users\\surpr\\Desktop\\TF-IDF測試資料"); //file path
            File[] source = file.listFiles();
            ArrayList<ArrayList<String>> docList = new  ArrayList<ArrayList<String>>();
            for(File txt : source){
                FileReader fr = new FileReader(txt);
                BufferedReader br = new BufferedReader(fr);
                ArrayList<String> doc = new ArrayList<String>();
                Double wordSum = 0.0;
                while(br.ready()){
                    String tmp = br.readLine();
                    Token.applyToken(doc, tmp);
                }
                docList.add(doc);
                fr.close();
            }
            TFIDF.algo(docList);
        }catch(IOException e){
            System.out.print("Read file miss:"+ e);
        }
    }
}