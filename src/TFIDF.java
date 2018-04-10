import java.util.ArrayList;

public class TFIDF {
    public static void algo(ArrayList<ArrayList<String>> docList){
        for(ArrayList<String> doc : docList){
            System.out.println(doc);
            for(String token : doc){
                Double TFScore = TF(doc, token);
                Double IDFScore = IDF(docList, token);
                if(IDFScore < 0){
                    IDFScore = IDFScore*-1;
                }
                System.out.print("字詞: "+token);
                System.out.print(" TF: ");
                System.out.printf("%1.3f", TFScore);
                System.out.print(" IDF: ");
                System.out.printf("%1.3f", IDFScore);
                System.out.print(" TF-IDF: ");
                System.out.printf("%1.3f", TFScore*IDFScore);
                System.out.println();
            }
        }
    }

    public static double TF(ArrayList<String> doc, String token){
        Double tokenSum = Double.valueOf(doc.size());
        Double appearTokenTime = 0.0;
        for(String key : doc){
            if(token.equals(key)){
                appearTokenTime++;
            }
        }
        return (appearTokenTime/tokenSum);
    }

    public static double IDF(ArrayList<ArrayList<String>> docList, String token){
        Double docSum = Double.valueOf(docList.size());
        Double appearDocTime = 0.0;
        for(ArrayList<String> doc : docList){
            for(String key : doc){
                if(token.equals(key)){
                    appearDocTime++;
                    break;
                }
            }
        }
        return Math.log(docSum/(appearDocTime+1))/Math.log(10);
    }
}
