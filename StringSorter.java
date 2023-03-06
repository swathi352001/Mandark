import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringSorter {
    
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("d34");
        strings.add("g54");
        strings.add("d12");
        strings.add("b87");
        strings.add("g1");
        strings.add("c65");
        strings.add("g40");
        strings.add("g5");
        strings.add("d77");

        List<String> L1 = new ArrayList<>();
        List<String> L2 = new ArrayList<>();
        
        
        
        for (char c = 'a'; c <= 'z'; c++) {
            List<String> stringsStartingWithChar = new ArrayList<>();
            for (String s : strings) {
                if (s.charAt(0) == c) {
                    stringsStartingWithChar.add(s);
                }
            }
            L1.addAll(stringsStartingWithChar);
            
            Collections.sort(stringsStartingWithChar, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    int n1 = Integer.parseInt(s1.substring(1));
                    int n2 = Integer.parseInt(s2.substring(1));
                    return Integer.compare(n2, n1);
                }
            });
            
            
            
            L2.addAll(stringsStartingWithChar);
        }
        
        System.out.println(L1); 
        System.out.println(L2); 
    }
}
