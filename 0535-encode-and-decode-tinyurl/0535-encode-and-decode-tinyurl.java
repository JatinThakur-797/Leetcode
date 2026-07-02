public class Codec {
    String com = "http://tinyurl.com/";
    Map<String, String> map = new HashMap<>();

     public static String getShortKey(String s) {
        if (s == null || s.isEmpty()) return "00000";

        long hash = 0;
        long p = 31;        
        long m = 1_000_000_009L;

       for (int i = 0; i < s.length(); i++) {
            hash = (hash * p + s.charAt(i)) % m;
        }

        String shortKey = Long.toString(hash, 36);

        return shortKey;
    }
    public String encode(String longUrl) {
        String key = getShortKey(longUrl);
        map.put(key, longUrl);
        return com+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String sub = shortUrl.substring(19, shortUrl.length());
        return map.get(sub);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));