package kr.ac.kopo.Account;

import java.sql.Timestamp;

public class AccountRecordVO {
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
	 private int rcNo;
	    private String rcType;
	    private String rcName;
	    private int rcMoney;
	    private Timestamp rcTime;
	    private int rcBalance;
	    private String acNumber;
	    private String id;
	    private int rcNumber;
	    private String rcText;
		/**
		 * @return the rcNo
		 */
		public int getRcNo() {
			return rcNo;
		}
		/**
		 * @param rcNo the rcNo to set
		 */
		public void setRcNo(int rcNo) {
			this.rcNo = rcNo;
		}
		/**
		 * @return the rcType
		 */
		public String getRcType() {
			return rcType;
		}
		/**
		 * @param rcType the rcType to set
		 */
		public void setRcType(String rcType) {
			this.rcType = rcType;
		}
		/**
		 * @return the rcName
		 */
		public String getRcName() {
			return rcName;
		}
		/**
		 * @param rcName the rcName to set
		 */
		public void setRcName(String rcName) {
			this.rcName = rcName;
		}
		/**
		 * @return the rcMoney
		 */
		public int getRcMoney() {
			return rcMoney;
		}
		/**
		 * @param rcMoney the rcMoney to set
		 */
		public void setRcMoney(int rcMoney) {
			this.rcMoney = rcMoney;
		}
		/**
		 * @return the rcTime
		 */
		public Timestamp getRcTime() {
			return rcTime;
		}
		/**
		 * @param rcTime the rcTime to set
		 */
		public void setRcTime(Timestamp rcTime) {
			this.rcTime = rcTime;
		}
		/**
		 * @return the rcBalance
		 */
		public int getRcBalance() {
			return rcBalance;
		}
		/**
		 * @param rcBalance the rcBalance to set
		 */
		public void setRcBalance(int rcBalance) {
			this.rcBalance = rcBalance;
		}
		/**
		 * @return the acNumber
		 */
		public String getAcNumber() {
			return acNumber;
		}
		/**
		 * @param acNumber the acNumber to set
		 */
		public void setAcNumber(String acNumber) {
			this.acNumber = acNumber;
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the rcNumber
		 */
		public int getRcNumber() {
			return rcNumber;
		}
		/**
		 * @param rcNumber the rcNumber to set
		 */
		public void setRcNumber(int rcNumber) {
			this.rcNumber = rcNumber;
		}
		/**
		 * @return the rcText
		 */
		public String getRcText() {
			return rcText;
		}
		/**
		 * @param rcText the rcText to set
		 */
		public void setRcText(String rcText) {
			this.rcText = rcText;
		}
		public AccountRecordVO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AccountRecordVO(int rcNo, String rcType, String rcName, int rcMoney, Timestamp rcTime, int rcBalance,
				String acNumber, String id, int rcNumber, String rcText) {
			super();
			this.rcNo = rcNo;
			this.rcType = rcType;
			this.rcName = rcName;
			this.rcMoney = rcMoney;
			this.rcTime = rcTime;
			this.rcBalance = rcBalance;
			this.acNumber = acNumber;
			this.id = id;
			this.rcNumber = rcNumber;
			this.rcText = rcText;
		}
		@Override
		public String toString() {
			return "AccountRecordVO [rcNo=" + rcNo + ", rcType=" + rcType + ", rcName=" + rcName + ", rcMoney="
					+ rcMoney + ", rcTime=" + rcTime + ", rcBalance=" + rcBalance + ", acNumber=" + acNumber + ", id="
					+ id + ", rcNumber=" + rcNumber + ", rcText=" + rcText + "]";
		}

	    
}