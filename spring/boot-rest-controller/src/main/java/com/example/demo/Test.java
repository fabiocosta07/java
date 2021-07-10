package com.example.demo;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */
    public static BigInteger[] insertionSort(BigInteger array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            BigInteger key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i].compareTo(key) > 0 ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
        return array;
    }
    public static List<String> bigSorting(List<String> unsorted) {
        // Write your code here
       List<BigInteger> lb = (List<BigInteger>) unsorted.stream().map(s -> {
           return new BigInteger(s);
        }).collect(Collectors.toList());
        BigInteger [] arr = insertionSort(lb.toArray(new BigInteger[0]));
        List<String> ls = Arrays.asList(arr).stream().map( s -> s.toString()).collect(Collectors.toList());
       return ls;
    }

}

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.bigSorting(unsorted);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
