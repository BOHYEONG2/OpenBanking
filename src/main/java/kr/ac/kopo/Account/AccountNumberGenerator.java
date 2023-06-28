package kr.ac.kopo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import util.ConnectionFactory;

public class AccountNumberGenerator {

    public static String generateAccountNumber() {
        Random random = new Random(); //난수생성
        boolean accountNumberExists = true;
        String accountNumber = "";

        while (accountNumberExists) { //중복확인
            StringBuilder accountNumberBuilder = new StringBuilder("2042");
            for (int i = 0; i < 6; i++) {
                accountNumberBuilder.append(random.nextInt(10));
            }	

            // 생성된 계좌 번호를 사용하여 계좌가 있는지 확인
            accountNumber = accountNumberBuilder.toString();
            AccountDAO dao = new AccountDAO();
            AccountVO account = dao.getAccountByAccountNumber(accountNumber);

            if (account == null) {
                accountNumberExists = false;
            }
        }

        return accountNumber;
    }
}