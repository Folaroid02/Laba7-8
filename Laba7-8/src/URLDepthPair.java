import java.net.*;

public class URLDepthPair {

    private URL URL;
    private int depth;

    public URLDepthPair(URL url, int d) throws MalformedURLException {
        URL = new URL(url.toString());
        depth = d;
    }
    @Override
    public String toString()
    {
        return "URL: " + URL.toString() + ", Depth: " + depth;
    }
    public URL getURL() {

        return URL;
    }
    public int getDepth() {

        return depth;
    }
    public String getHost() {
        return URL.getHost();
    }
    public String getDocPath() {

        return URL.getPath();
    }
}