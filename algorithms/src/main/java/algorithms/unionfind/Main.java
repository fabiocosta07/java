package algorithms.unionfind;

import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Main {
/*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Uf uf = new QuickFindUf(n);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + "" + q);
            }


        }
    }
*/

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/algorithms/quickfind2.txt");

        try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String currentLine = null;
            currentLine = reader.readLine();

            int n = Integer.parseInt(currentLine);

            Uf uf = new QuickUnionUf(n);

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            System.out.println("Union");
            while ((currentLine = reader.readLine()) != null){
                String[] unions = currentLine.split(" ");
                int p = Integer.parseInt(unions[0]);
                int q = Integer.parseInt(unions[1]);
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
            }
            stopWatch.stop();

            System.out.println("Time elapsed="+stopWatch.getTime(TimeUnit.MILLISECONDS));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}