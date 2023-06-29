package kr.ac.kopo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
/*
 * 해당 계좌의 입출금 내역
 *  입출금 내역의 고유번호인 RC_NO
 *  입출금 유형인 RC_TYPE
 *  입출금 대상인 RC_NAME
 *  입출금 금액인 RC_MONEY
 *  입출금 시간인 RC_TIME
 *  계좌 번호인 AC_NUMBER
 *  사용자 ID
 */

public class AccountDAO {

    public void createAccount(AccountVO account) {

        String sql = "INSERT INTO ACCOUNT (AC_NUMBER, ID, AC_PW, AC_NAME, AC_MONEY, AC_OP_DATE, AC_ED_DATE, STATE, PD_NUMBER, BANK_CD) "
                + "VALUES (?, ?, ?, ?, ?, sysdate, sysdate+365, ?, ?, ?)";

        try (Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        		) {
            pstmt.setString(1, account.getAc_number());
            pstmt.setString(2, account.getId());
            pstmt.setString(3, account.getAC_PW());
            pstmt.setString(4, account.getAC_NAME());
            pstmt.setInt(5, account.getAC_MONEY());
            pstmt.setString(6, account.getSTATE());
            pstmt.setInt(7, account.getPD_NUMBER());
            pstmt.setString(8, account.getBank_cd());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferMoney(String senderAcNumber, String receiverAcNumber, int sendMoney) {
        String senderSql = "UPDATE ACCOUNT SET AC_MONEY = AC_MONEY - ? WHERE AC_NUMBER = ?";
        String receiverSql = "UPDATE ACCOUNT SET AC_MONEY = AC_MONEY + ? WHERE AC_NUMBER = ?";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement senderPstmt = conn.prepareStatement(senderSql);
             PreparedStatement receiverPstmt = conn.prepareStatement(receiverSql);) {
            conn.setAutoCommit(false);

            senderPstmt.setInt(1, sendMoney);
            senderPstmt.setString(2, senderAcNumber);
            senderPstmt.executeUpdate();

            receiverPstmt.setInt(1, sendMoney);
            receiverPstmt.setString(2, receiverAcNumber);
            receiverPstmt.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getAccountMoney(int acNumber) {
        int balance = 0;
        String sql = "SELECT AC_MONEY FROM ACCOUNT WHERE AC_NUMBER = ?";

        try (Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, acNumber);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                balance = rs.getInt("AC_MONEY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    public void closeAccount(int acNumber) {
        String sql = "UPDATE ACCOUNT SET STATE = '해지', AC_ED_DATE = sysdate WHERE AC_NUMBER = ?";

        try (Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, acNumber);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<AccountVO> getAccountList(AccountVO accountVO) {
        List<AccountVO> accountList = new ArrayList<>();
        String sql = "SELECT * FROM ACCOUNT WHERE ID = ?";

        try (Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, accountVO.getId());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AccountVO account = new AccountVO();
                account.setAc_number(rs.getString("AC_NUMBER"));
                account.setId(rs.getString("ID"));
                account.setAC_PW(rs.getString("AC_PW"));
                account.setAC_NAME(rs.getString("AC_NAME"));
                account.setAC_MONEY(rs.getInt("AC_MONEY"));
                account.setAC_OP_DATE(rs.getDate("AC_OP_DATE"));
                account.setAC_ED_DATE(rs.getDate("AC_ED_DATE"));
                account.setSTATE(rs.getString("STATE"));
                account.setPD_NUMBER(rs.getInt("PD_NUMBER"));
                account.setBank_cd(rs.getString("BANK_CD"));
                accountList.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public AccountVO getAccountByAccountNumber(String accountNumber) {
        AccountVO account = null;
        String sql = "SELECT * FROM ACCOUNT WHERE AC_NUMBER = ?";

        try (Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, accountNumber);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account = new AccountVO();
                account.setAc_number(rs.getString("AC_NUMBER"));
                account.setId(rs.getString("ID"));
                account.setAC_PW(rs.getString("AC_PW"));
                account.setAC_NAME(rs.getString("AC_NAME"));
                account.setAC_MONEY(rs.getInt("AC_MONEY"));
                account.setAC_OP_DATE(rs.getDate("AC_OP_DATE"));
                account.setAC_ED_DATE(rs.getDate("AC_ED_DATE"));
                account.setSTATE(rs.getString("STATE"));
                account.setPD_NUMBER(rs.getInt("PD_NUMBER"));
                account.setBank_cd(rs.getString("BANK_CD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<AccountRecordVO> getAccountRecords(String acNumber) {
        List<AccountRecordVO> accountRecords = new ArrayList<>();
        String sql = "SELECT * FROM AC_RECORD WHERE AC_NUMBER = ? ORDER BY RC_TIME DESC";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, acNumber);

            ResultSet rs = pstmt.executeQuery();
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
                accountRecords.add(accountRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountRecords;
    }
    
}