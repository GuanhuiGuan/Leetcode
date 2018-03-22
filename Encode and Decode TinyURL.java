public class Codec {
    String dict;
    Random rand = new Random();
    Map<String, String> map = new HashMap<>();
    
    public Codec() {
        dict = createDict();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = generateKey();
        while(map.containsKey(key)) key = generateKey();
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace("http://tinyurl.com/", "");
        return map.get(key);
    }
    
    public String createDict() {
        // create the dict string containing digits and letters
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) sb.append(i);
        for(char c = 'a'; c <= 'z'; c++) sb.append(c);
        for(char c = 'A'; c <= 'Z'; c++) sb.append(c);
        return sb.toString();
    }
    
    public String generateKey() {
        // generate a 6 digit key randomly drawn from dict
        int n = dict.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            sb.append(dict.charAt(rand.nextInt(n)));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));