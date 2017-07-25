package testMD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lin on 2017/7/8 18:33.
 */
public class TestMD5 {
    public static void main(String[] args) {
        MD5("aaaaaa");
    }

    private static String MD5(String sourceStr) {
        String result = "";
        try {
            byte[] c = sourceStr.getBytes();
            //生成md5加密算法照耀
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int j = 0; j < b.length; j++) {
                i = b[j];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
