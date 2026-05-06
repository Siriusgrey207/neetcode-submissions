class Solution {
    // 1. we can start with the encoding method.
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        // Initialise a String builder.
        StringBuilder encoded = new StringBuilder();

        // Loop through the list of strings and append the length of the string, # and the string itself
        // to the string builder.
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }

        // Convert to String and return.
        return encoded.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();
        // Initialise a pointer to the first char of the string and the list of words
        // we will be returning.
        int i = 0;
        List<String> words = new ArrayList<>();

        // First for loop checks if I has passed the end of str
        while(i < str.length()) {
            // j also points at the start.
            int j = i;

            // Increment j until we have the length of the next word. Now j points at '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get the length of the word and turn it into an int
            int wordLength = Integer.parseInt(str.substring(i, j));
            i = j + 1; // Point to the start of the word.
            words.add(str.substring(i, i + wordLength));
            i += wordLength;
        }

        return words;
    }
}


// class Solution {
//     public String encode(List<String> strs) {
//         if (strs.isEmpty()) return "";
//         StringBuilder encoded = new StringBuilder();
//         for (String str: strs) {
//             encoded.append(str.length()).append("#").append(str);
//         }
//         return encoded.toString();
//     }

//     public List<String> decode(String str) {
//         if (str.isEmpty()) return new ArrayList<>();

//         List<String> words = new ArrayList<>();
//         int i = 0;
//         while (i < str.length()) {
//             int j = i;
//             while (str.charAt(j) != '#') {
//                 j++;
//             }
//             int wordLength = Integer.parseInt(str.substring(i, j));
//             i = j + 1;
//             words.add(str.substring(i, i + wordLength));
//             i += wordLength;
//         }
//         return words;
//     }
// }

