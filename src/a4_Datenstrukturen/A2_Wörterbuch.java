package a4_Datenstrukturen;
import java.util.*;
public class A2_Wörterbuch {
    public static void main(String[] args) {
        HashMap<String, String> vocabulary = new HashMap<String, String>();

        addWord(vocabulary, "en1", "de1");
        addWord(vocabulary, "en1", "new-de1");
        addWord(vocabulary, "en2", "de2");

        System.out.println(getTranslation(vocabulary,"en1"));
        System.out.println(getTranslation(vocabulary,"de1"));

        deleteWord(vocabulary, "en1");
        System.out.println(getTranslation(vocabulary,"en1"));

        System.out.println(getTranslation(vocabulary,"de2"));
        deleteWord(vocabulary, "de2");
        System.out.println(getTranslation(vocabulary,"de2"));
    }

    //---------- ADD NEW WORD
    static void addWord(HashMap<String, String> vocabulary, String en, String de) {
        vocabulary.put(en, de);
    }

    //---------- TRANSLATE
    static String getTranslation(HashMap<String, String> vocabulary, String word) {
        if (vocabulary.containsKey(word)) return vocabulary.get(word);
        else if (vocabulary.containsValue(word)) return getKey(vocabulary, word);
        else return "Der Wortschatz enthält dieses Wort nicht.";
    }

    //---------- DELETE
    static void deleteWord(HashMap<String, String> vocabulary, String word) {
        if (vocabulary.containsKey(word)) vocabulary.remove(word);
        else if (vocabulary.containsValue(word)) vocabulary.remove(getKey(vocabulary, word));
        else System.out.println("Der Wortschatz enthält dieses Wort nicht.");
    }

    // -------- CHECK DATABASE (Entries)
    static <K, V> K getKey(HashMap<K, V> vocabulary, V value) {
        for (var entry: vocabulary.entrySet()) {
            if (Objects.equals(value, entry.getValue())) return entry.getKey();
        }
        return null;
    }
}
/*
new-de1
Der Wortschatz enthält dieses Wort nicht.
Der Wortschatz enthält dieses Wort nicht.
en2
Der Wortschatz enthält dieses Wort nicht.*/