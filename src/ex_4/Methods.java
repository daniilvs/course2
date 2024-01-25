package ex_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.CharSequence.compare;
import static java.lang.String.format;

public class Methods {
    private static List<String> getWords(String filename) throws IOException {
        var splitter = Pattern.compile("[\\p{Punct}\\d\\s«…»–]+");
        return Files.lines(Path.of(filename))
                .flatMap(splitter::splitAsStream)
                .filter(w -> !w.isEmpty())
                .collect(Collectors.toList());
    }

    private static List<String> getWordsSorted(String input) throws IOException {
        return getWords(input).stream()
                .map(String::toLowerCase)
                .sorted()
                .toList();
    }

    private static void writeResultToFile(String filename, List<String> lines) throws IOException {
        Files.write(Path.of(filename), lines);
    }

    // Unique words
    public static void uniqueWordsA(String input, String output) throws IOException {
        HashSet<String> unique = new HashSet<String>(getWords(input));
        List<String> result = new ArrayList<>(unique);
        result.sort(Collections.reverseOrder(Comparator.comparing(String::length)));
        writeResultToFile(output, result);
    }

    public static void uniqueWordsB(String input, String output) throws IOException {
        HashSet<String> unique = new HashSet<String>(getWords(input));
        Pattern pattern = Pattern.compile("\\b[а-яА-Яa-zA-Z0-9]{4,7}\\b", Pattern.UNICODE_CHARACTER_CLASS);
        List<String> result = unique.stream()
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());
        writeResultToFile(output, result);
    }

    // words' usage
    public static void countWordsA(String input, String output) throws IOException {
        List<String> words = getWordsSorted(input);
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < words.size()) {
            while (j + 1 < words.size() && Objects.equals(words.get(j), words.get(j + 1))) {
                j++;
            }
            j++;
            res.add(String.format("%s: %d", words.get(i), j - i));
            i = j;
        }
        writeResultToFile(output, res);
    }

    private static List<String> countWithMap(List<String> words) {
        HashMap<String, Integer> mapa = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (!mapa.containsKey(w)) {
                mapa.put(w, 1);
            }
            else {
                int prev = mapa.get(w);
                mapa.replace(w, prev, prev+1);
            }
        }
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            res.add(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }
        return res;
    }

    public static void countWordsB(String input, String output) throws IOException {
        List<String> words = getWordsSorted(input);
        List<String> res = countWithMap(words);
        writeResultToFile(output, res);
    }

    public static void countWordsC(String input, String output) throws IOException {
        List<String> words = getWordsSorted(input);
        Pattern pattern = Pattern.compile("\\b[а-яА-Яa-zA-Z0-9]{4,7}\\b", Pattern.UNICODE_CHARACTER_CLASS);
        List<String> fourTet = words.stream()
                .filter(pattern.asPredicate())
                .toList();
        List<String> res = countWithMap(fourTet);
        writeResultToFile(output, res);
    }

    public static void countWordsD(String input, String output) throws IOException {
        List<String> words = getWordsSorted(input);
        List<String> res = countWithMap(words);
        writeResultToFile(output, res.stream().sorted().toList());
    }

    // counting chars
    public static void countCharsUsage(String input, String output) throws IOException {
        List<String> words = getWordsSorted(input);
        HashMap<Integer, Integer> mapa = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String w : words) {
            int l = w.length();
            if (!mapa.containsKey(l)) {
                mapa.put(l, 1);
            }
            else {
                int prev = mapa.get(l);
                mapa.replace(l, prev, prev+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            res.add(String.format("%d: %d", entry.getKey(), entry.getValue()));
        }
        writeResultToFile(output, res);
    }

    public static void countAllChars(String input, String output) throws IOException {
        List<String> words = getWordsSorted(input);
        int quantity = 0;
        for (String w : words) {
            quantity += w.length();
        }
        Files.write(Path.of(output), format("Number of characters: %d", quantity).getBytes());
    }

    private static LinkedHashMap<Character, Integer> countCharsMap(String input) throws FileNotFoundException {
        String theString = "";
        File file = new File(input);
        Scanner scanner = new Scanner(file);
        theString = scanner.nextLine();
        while (scanner.hasNextLine()) {
            theString = theString + "\n" + scanner.nextLine();
        }
        char[] charArray = theString.toCharArray();
        Arrays.sort(charArray);
        LinkedHashMap<Character, Integer> mapa = new LinkedHashMap<>();
        for (char c : charArray) {
            if (!mapa.containsKey(c)) {
                mapa.put(c, 1);
            }
            else {
                int prev = mapa.get(c);
                mapa.replace(c, prev, prev+1);
            }
        }
        return mapa;
    }

    public static void characterUsageA(String input, String output) throws IOException {
        var mapa = countCharsMap(input);
        List<String> res = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : mapa.entrySet()) {
            res.add(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }
        writeResultToFile(output, res);
    }


    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list.sort(Collections.reverseOrder());
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void characterUsageB(String input, String output) throws IOException {
        var mapa = countCharsMap(input);
        List<String> res = new ArrayList<>();
        var sorted = sortByValue(mapa);
        for (Map.Entry<Character, Integer> entry : sorted.entrySet()) {
            res.add(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }
        writeResultToFile(output, res);
    }

    public static void main(String[] args) throws IOException {
//        uniqueWordsA("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_unique_a.txt");
//        uniqueWordsB("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_unique_b.txt");
//        countWordsA("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_count_a.txt");
//        countWordsB("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_count_b.txt");
//        countWordsC("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_count_c.txt");
//        countWordsD("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_count_d.txt");
//        countCharsUsage("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_countCharsUsage.txt");
//        countAllChars("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_countAllChars.txt");
        characterUsageA("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_characterUsageA.txt");
        characterUsageB("src/ex_4/resources/lenin.txt", "src/ex_4/out/out_characterUsageB.txt");
    }
}
