import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Token {
    public static void applyToken(ArrayList<String> doc, String term) throws IOException {
        StringBuilder builder = new StringBuilder();
        EnglishAnalyzer analyzer = new EnglishAnalyzer();
        TokenStream tokenStream = null;

        for(String w : term.split(" ")){
            tokenStream = analyzer.tokenStream("content", new StringReader(w));
            tokenStream.reset();
            CharTermAttribute attr = tokenStream.addAttribute(CharTermAttribute.class);
            while (tokenStream.incrementToken()) {
                String t = new String(attr.buffer(), 0, attr.length());
                doc.add(t);
            }
            tokenStream.close();
        }
        analyzer.close();
    }
}
