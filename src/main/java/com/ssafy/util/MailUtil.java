package com.ssafy.util;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;

public class MailUtil {
	public static void sendMail(String email, String subject, String msg) throws Exception {

		// Mail Server 설정

		String charSet = "utf-8";

		String hostSMTP = "smtp.naver.com"; // SMTP 서버명

		String hostSMTPid = "네이버 아이디"; // 아이디

		String hostSMTPpwd = "네이버 비밀번호"; // 비밀번호
		// 보내는 사람

		String fromEmail = "보내는사람@메일.com";

		String fromName = "보내는사람 이름";

		// email 전송

		try {

			HtmlEmail mail = new HtmlEmail();

			mail.setDebug(true);

			mail.setCharset(charSet);

			mail.setSSLOnConnect(true); // SSL 사용 (TLS가 없는 경우 SSL 사용)

			mail.setHostName(hostSMTP);

			mail.setSmtpPort(587); // SMTP 포트 번호

			mail.setAuthentication(hostSMTPid, hostSMTPpwd);

			mail.setStartTLSEnabled(true); // TLS 사용

			mail.addTo(email);

			mail.setFrom(fromEmail, fromName, charSet);

			mail.setSubject(subject);

			mail.setHtmlMsg(msg);

			mail.send();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static String createKey() throws Exception {
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int index = rnd.nextInt(3);
			switch (index) {
			case 0:
				key.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				key.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				key.append((rnd.nextInt(10)));
				break;
			}
		}
		return key.toString();
	}

	public static String getNewPwd() throws Exception {
		char[] charSet = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',

				'!', '@', '#', '$', '%', '^', '&', '+', '=', '.' };

		StringBuffer newKey = new StringBuffer();

		for (int i = 0; i < 10; i++) {

			int idx = (int) (charSet.length * Math.random());

			newKey.append(charSet[idx]);

		}

		return newKey.toString();

	}

}
