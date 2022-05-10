import java.util.HashSet;
import java.util.LinkedList;
import java.net.URL;

public class UrlPool {
    // Список всех сайтов, которые мы успешно просмотрели
    static LinkedList<URLDepthPair> allSitesSeen = new LinkedList<URLDepthPair>();
    // Список всех сайтов, которые мы хотим просмотреть
    static LinkedList<URLDepthPair> toVisit = new LinkedList<URLDepthPair>();
    int maxDepth;
    int waitCount;
    static HashSet<URL> seenURLs = new HashSet<URL>();
    public UrlPool(int maxDepth) {
        this.maxDepth = maxDepth;
        waitCount = 0;
    }
    public synchronized URLDepthPair getNextPair() {
        while (toVisit.size() == 0) {
            try {
                waitCount++;
                wait();
                waitCount--;
            } catch (InterruptedException e) {
            }
        }
        URLDepthPair nextPair = toVisit.removeFirst();
        return nextPair;
    }
    public synchronized void addPair(URLDepthPair pair) {
        if (seenURLs.contains(pair.getURL())) {
            return;
        }
        allSitesSeen.add(pair);
        seenURLs.add(pair.getURL());
        if (pair.getDepth() < maxDepth) {
            toVisit.add(pair);
            notify();
        }
    }
    public synchronized int getWaitCount() {

        return waitCount;
    }
    public synchronized int getMaxDepth() {

        return maxDepth;
    }
    public LinkedList<URLDepthPair> allSitesSeen() {
        return allSitesSeen;
    }
}