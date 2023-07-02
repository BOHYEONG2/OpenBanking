package kr.ac.kopo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class AccountRecordDAO {

    public void insertTransaction(AccountRecordVO accountRecord) {
         String sql = "INSERT INTO AC_RECORD (RC_NO, RC_TYPE, RC_NAME, RC_MONEY, RC_TIME, RC_BALANCE, AC_NUMBER, ID, RC_NUMBER, RC_TEXT) "
                + "VALUES (AC_RECORD_seq.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?)";
        	
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        		) {

            pstmt.setString(1, accountRecord.getRcType());
            pstmt.setString(2, accountRecord.getRcName());
            pstmt.setInt(3, accountRecord.getRcMoney());
            pstmt.setInt(4, accountRecord.getRcBalance());
            pstmt.setString(5, accountRecord.getAcNumber());
            pstmt.setString(6, accountRecord.getId());
            pstmt.setInt(7, accountRecord.getRcNumber());
            pstmt.setString(8, accountRecord.getRcText());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public List<AccountRecordVO> getAccountRecordsById(String id) {
        List<AccountRecordVO> accountRecords = new ArrayList<>();
        String sql = "SELECT * FROM AC_RECORD WHERE ID = ? ORDER BY RC_TIME DESC";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            int balance = 0; // 초기 잔액은 0으로 설정
            while (rs.next()) {
                AccountRecordVO accountRecord = new AccountRecordVO();
                accountRecord.setRcNo(rs.getInt("RC_NO"));
                accountRecord.setRcType(rs.getString("RC_TYPE"));
                accountRecord.setRcName(rs.getString("RC_NAME"));
                accountRecord.setRcMoney(rs.getInt("RC_MONEY"));
                accountRecord.setRcTime(rs.getTimestamp("RC_TIME"));
                accountRecord.setRcBalance(rs.getInt("RC_BALANCE"));
                accountRecord.setAcNumber(rs.getString("AC_NUMBER"));
                accountRecord.setId(rs.getString("ID"));
                accountRecord.setRcNumber(rs.getInt("RC_NUMBER"));
                accountRecord.setRcText(rs.getString("RC_TEXT"));
                balance += accountRecord.getRcMoney(); // 잔액에 입출금액을 누적
                accountRecord.setRcBalance(balance); // 누적된 잔액을 설정
                accountRecords.add(accountRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountRecords;
    }

    public List<AccountRecordVO> getAccountRecords(String acNumber) {
        List<AccountRecordVO> accountRecords = new ArrayList<>();
        String sql = "SELECT * FROM AC_RECORD WHERE AC_NUMBER = ? ORDER BY RC_TIME DESC";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, acNumber);

            ResultSet rs = pstmt.executeQuery();
            int balance = 0; // 초기 잔액은 0으로 설정
            while (rs.next()) {
                AccountRecordVO accountRecord = new AccountRecordVO();
                accountRecord.setRcNo(rs.getInt("RC_NO"));
                accountRecord.setRcType(rs.getString("RC_TYPE"));
                accountRecord.setRcName(rs.getString("RC_NAME"));
                accountRecord.setRcMoney(rs.getInt("RC_MONEY"));
                accountRecord.setRcTime(rs.getTimestamp("RC_TIME"));
                accountRecord.setRcBalance(rs.getInt("RC_BALANCE"));
                accountRecord.setAcNumber(rs.getString("AC_NUMBER"));
                accountRecord.setId(rs.getString("ID"));
                accountRecord.setRcNumber(rs.getInt("RC_NUMBER"));
                accountRecord.setRcText(rs.getString("RC_TEXT"));
 //               balance = accountRecord.getRcBalance();
                balance += accountRecord.getRcMoney(); // 잔액에 입출금액을 누적
  //              accountRecords.add(accountRecord);
                accountRecord.setRcBalance(balance); // 누적된 잔액을 설정
                accountRecords.add(accountRecord);
  /*              // 잔액 계산
                int money = rs.getInt("RC_MONEY");
                balance += money;

                accountRecord.setRcBalance(balance);
                accountRecords.add(accountRecord);
                */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountRecords;
    }
}