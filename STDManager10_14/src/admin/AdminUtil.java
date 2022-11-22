package admin;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdminUtil {

	//비밀번호 암호화
	public static String pwdEncrypt(String pwd) {
		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(pwd.getBytes());
		pwd= String.format("%064x", new BigInteger(1, md.digest()));
		return pwd;
	}
	
}
