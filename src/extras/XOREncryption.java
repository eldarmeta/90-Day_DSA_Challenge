public class XOREncryption {
    public static String xorEncrypt(String input, char key) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : input.toCharArray()) {
            encrypted.append((char)(c ^ key));
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        String message = "SecretMessage123";
        char key = 'K'; // любой символ, например буква K

        String encrypted = xorEncrypt(message, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = xorEncrypt(encrypted, key); // расшифровка тем же методом
        System.out.println("Decrypted: " + decrypted);
    }
}
