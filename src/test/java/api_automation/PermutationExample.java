package api_automation;

public class PermutationExample {
	
	
	public static void main(String[] args) {
        String input = "Rajiv";
        permute(input, "");
    }

    // Recursive function
    public static void permute(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // Remaining string after removing current character
            String remaining = str.substring(0, i) + str.substring(i + 1);

            permute(remaining, result + current);
        }
    }
}
