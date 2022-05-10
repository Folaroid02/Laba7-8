import java.net.MalformedURLException;
import java.util.LinkedList;
import java.net.URL;

public class Crawler{
    public static void crawl(String startURL, int maxDepth, int numThreads)
            throws MalformedURLException {
        //Инициализируем пул адресов
        UrlPool pool = new UrlPool(maxDepth);
        //Формируем корневой элемент(глубина 0)
        URL rootURL = new URL(startURL);
        URLDepthPair urlPair = new URLDepthPair(rootURL, 0);
        pool.addPair(urlPair);
        // Запускаем потоки. 1 - по умолчанию.
        for (int i = 0; i < numThreads; i++) {
            CrawlerTask c = new CrawlerTask(i+1,pool);
            Thread t = new Thread(c);
            t.start();
        }
        // Ожидаем завершения работы всех потоков
        while (pool.getWaitCount() != numThreads) {
            try {
                Thread.sleep(100); // 0.1 second
            } catch (InterruptedException ie) {
                System.out.println("Some thing went wrong!");
            }
        }
        System.out.println( "\n" + "Result list of sites: ");
        // формат вывода: URL: https://habr.com/ru/about/, Depth: 0
        LinkedList<URLDepthPair> foundUrls = pool.allSitesSeen();
        for (URLDepthPair pair : foundUrls) {
            System.out.println(pair.toString());
        }
    }
    public static void main(String[] args) {

        String startURL = "";
        int maxDepth = 0;
        int threadsNum = 1;
        switch (args.length) {
            case 4:
                //Количество потоков, с которыми будем работать
                threadsNum = Integer.parseInt(args[3]);
                if(threadsNum<1)
                    threadsNum=1;
            case 2:
                startURL = args[0];
                maxDepth = Integer.parseInt(args[1]);
                break;
            default:
                System.out.println("usage: java Crawler <URL> <maximum_depth> (-t <num_threads>)");
                System.exit(1);
                break;
        }
        try {
            crawl(startURL, maxDepth, threadsNum);
        }
        catch (MalformedURLException e) {
            System.err.println("Error: The URL " + args[0] + " is not valid");
            System.exit(1);
        }
        System.exit(0);
    }
}