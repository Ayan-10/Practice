package test;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algocommons {
    public static void main(String[] args) throws IOException {
        String wikiText = "== {{int:filedesc}} ==\n{{Information\n|description={{en|1=Character \u8c4c"+
                " rendered from Noto Serif CJK JP with rustbrown border on peach}}\n" +
                "|date=2019-11-15 05:37:11\n" +
                "|source={{own}}\n" +
                "|author=ArielGlenn\n}}\n{{Location|40.42199722222222|-122.08399999999999}}\n\n\n" +
                "=={{int:license-header}}==\n" +
                "{{self|cc-by-sa-4.0}}\n" +
                "\n" +
                "{{Uploaded from Mobile|platform=Android|version=3.0.0-debug-master~117a7805a}}\n" +
                "{{Uncategorized|year=2021|month=May|day=9}}";
        String test = "abcd==jn==\nkknnn";

        String editedLocation = "\n{{Location|-1333.42199722222222|69.08399999999999}}\n";
        if(wikiText.contains("filedesc") &&
                wikiText.contains("Location")) {
            String fromLocationtoEnd = wikiText.substring(wikiText.indexOf("{{Location"));

            String firstHalf = wikiText.substring(0, wikiText.indexOf("{{Location"));
            String lastHalf = fromLocationtoEnd.substring(fromLocationtoEnd.indexOf("}}") + 2);


            String newWikiText = firstHalf + editedLocation + lastHalf;
            System.out.print(newWikiText);
        }else if(wikiText.contains("filedesc") &&
                !wikiText.contains("Location")){
            int startOfSecondSec = StringUtils.ordinalIndexOf(wikiText, "==", 3);
           if(startOfSecondSec != -1) {
               String firstHalf = wikiText.substring(0, startOfSecondSec);
               String lastHalf = wikiText.substring(startOfSecondSec);
               String newWikiText = firstHalf + editedLocation + lastHalf;
               System.out.println(newWikiText);
           }else{
               String newWikiText = wikiText + editedLocation;
               System.out.println(newWikiText);
           }
        }else if(!wikiText.contains("filedesc") &&
                !wikiText.contains("Location")){
            String newWikiText = "== {{int:filedesc}} ==" +editedLocation+wikiText;
            System.out.println(newWikiText);
        }else if(!wikiText.contains("filedesc") &&
                wikiText.contains("Location")){
            String newWikiText = "== {{int:filedesc}} ==" +editedLocation+wikiText;
            System.out.println(newWikiText);
        }
    }
}
