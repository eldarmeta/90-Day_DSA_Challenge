import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public final class CryptoTask {
    private static final int SALT_LEN = 16;
    private static final int IV_LEN = 12;
    private static final int KEY_LEN = 256;
    private static final int TAG_LEN = 128;
    private static final int PBKDF2_ITERS = 200_000;
    private static final SecureRandom RNG = new SecureRandom();

    public static String encrypt(String plaintext, char[] password) {
        try {
            byte[] salt = random(SALT_LEN);
            SecretKeySpec key = derive(password, salt);
            byte[] iv = random(IV_LEN);
            Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
            c.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(TAG_LEN, iv));
            byte[] ct = c.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return "v1$" + b64(salt) + "$" + b64(iv) + "$" + b64(ct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String payload, char[] password) {
        try {
            String[] p = payload.split("\\$");
            if (p.length != 4 || !"v1".equals(p[0])) throw new IllegalArgumentException("bad payload");
            byte[] salt = b64d(p[1]);
            byte[] iv = b64d(p[2]);
            byte[] ct = b64d(p[3]);
            SecretKeySpec key = derive(password, salt);
            Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
            c.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(TAG_LEN, iv));
            byte[] pt = c.doFinal(ct);
            return new String(pt, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static SecretKeySpec derive(char[] password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password, salt, PBKDF2_ITERS, KEY_LEN);
        byte[] k = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
        return new SecretKeySpec(k, "AES");
    }

    private static byte[] random(int n) {
        byte[] b = new byte[n];
        RNG.nextBytes(b);
        return b;
    }

    private static String b64(byte[] b) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(b);
    }

    private static byte[] b64d(String s) {
        return Base64.getUrlDecoder().decode(s);
    }

    public static void main(String[] args) {
        String text = args.length > 0 ? args[0] : "{\"k\":\"v\"}";
        char[] pass = (args.length > 1 ? args[1] : "s3cret").toCharArray();
        String enc = encrypt(text, pass);
        String dec = decrypt(enc, pass);
        System.out.println(enc);
        System.out.println(dec);
    }
}
