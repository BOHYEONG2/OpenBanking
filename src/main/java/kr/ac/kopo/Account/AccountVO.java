package kr.ac.kopo.Account;

import java.util.Date;


public class AccountVO {

		
		private String ac_number;
	    private String id;
	    private String AC_PW;
	    private String AC_NAME;
	    private int AC_MONEY;
	    private String bankCode;
	    private Date AC_OP_DATE;
	    private Date AC_ED_DATE;
	    private String STATE;
	    private int PD_NUMBER;
	    private String bank_cd;
	    private String name;
	    
	    
		public AccountVO(String name) {
			super();
			this.name = name;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		public AccountVO() {
			super();

		}
		/**
		 * @return the ac_number
		 */
		public String getAc_number() {
			return ac_number;
		}
		/**
		 * @param ac_number the ac_number to set
		 */
		public void setAc_number(String ac_number) {
			this.ac_number = ac_number;
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
		 * @return the aC_PW
		 */
		public String getAC_PW() {
			return AC_PW;
		}
		/**
		 * @param aC_PW the aC_PW to set
		 */
		public void setAC_PW(String aC_PW) {
			AC_PW = aC_PW;
		}
		/**
		 * @return the aC_NAME
		 */
		public String getAC_NAME() {
			return AC_NAME;
		}
		/**
		 * @param aC_NAME the aC_NAME to set
		 */
		public void setAC_NAME(String aC_NAME) {
			AC_NAME = aC_NAME;
		}
		/**
		 * @return the aC_MONEY
		 */
		public int getAC_MONEY() {
			return AC_MONEY;
		}
		/**
		 * @param aC_MONEY the aC_MONEY to set
		 */
		public void setAC_MONEY(int aC_MONEY) {
			AC_MONEY = aC_MONEY;
		}
		/**
		 * @return the bankCode
		 */
		public String getBankCode() {
			return bankCode;
		}
		/**
		 * @param bankCode the bankCode to set
		 */
		public void setBankCode(String bankCode) {
			this.bankCode = bankCode;
		}
		/**
		 * @return the aC_OP_DATE
		 */
		public Date getAC_OP_DATE() {
			return AC_OP_DATE;
		}
		/**
		 * @param aC_OP_DATE the aC_OP_DATE to set
		 */
		public void setAC_OP_DATE(Date aC_OP_DATE) {
			AC_OP_DATE = aC_OP_DATE;
		}
		/**
		 * @return the aC_ED_DATE
		 */
		public Date getAC_ED_DATE() {
			return AC_ED_DATE;
		}
		/**
		 * @param aC_ED_DATE the aC_ED_DATE to set
		 */
		public void setAC_ED_DATE(Date aC_ED_DATE) {
			AC_ED_DATE = aC_ED_DATE;
		}
		/**
		 * @return the sTATE
		 */
		public String getSTATE() {
			return STATE;
		}
		/**
		 * @param sTATE the sTATE to set
		 */
		public void setSTATE(String sTATE) {
			STATE = sTATE;
		}
		/**
		 * @return the pD_NUMBER
		 */
		public int getPD_NUMBER() {
			return PD_NUMBER;
		}
		/**
		 * @param pD_NUMBER the pD_NUMBER to set
		 */
		public void setPD_NUMBER(int pD_NUMBER) {
			PD_NUMBER = pD_NUMBER;
		}
		/**
		 * @return the bank_cd
		 */
		public String getBank_cd() {
			return bank_cd;
		}
		/**
		 * @param bank_cd the bank_cd to set
		 */
		public void setBank_cd(String bank_cd) {
			this.bank_cd = bank_cd;
		}
		@Override
		public String toString() {
			return "AccountVO [ac_number=" + ac_number + ", id=" + id + ", AC_PW=" + AC_PW + ", AC_NAME=" + AC_NAME
					+ ", AC_MONEY=" + AC_MONEY + ", bankCode=" + bankCode + ", AC_OP_DATE=" + AC_OP_DATE
					+ ", AC_ED_DATE=" + AC_ED_DATE + ", STATE=" + STATE + ", PD_NUMBER=" + PD_NUMBER + ", bank_cd="
					+ bank_cd + "]";
		}
		public AccountVO(String ac_number, String id, String aC_PW, String aC_NAME, int aC_MONEY, String bankCode,
				Date aC_OP_DATE, Date aC_ED_DATE, String sTATE, int pD_NUMBER, String bank_cd) {
			super();
			this.ac_number = ac_number;
			this.id = id;
			AC_PW = aC_PW;
			AC_NAME = aC_NAME;
			AC_MONEY = aC_MONEY;
			this.bankCode = bankCode;
			AC_OP_DATE = aC_OP_DATE;
			AC_ED_DATE = aC_ED_DATE;
			STATE = sTATE;
			PD_NUMBER = pD_NUMBER;
			this.bank_cd = bank_cd;
		}
		
	
		
	    
}