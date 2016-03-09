package com.hanyx.hjoyblog.util;

/**
 * ȫ�ֳ�������
 * @author ��Ԫ��
 */
public final class GlobalConstraints {
	
	private GlobalConstraints() {};
	
	/** ���б��е�����״̬ - δ�� */
	public static final short BEAN_DATA_STATE_NOTUSED = 0;
	/** ���б��е�����״̬ - ʹ�� */
	public static final short BEAN_DATA_STATE_ISUSED = 1;
	
	/** �û����н�ɫID - ����Ա */
	public static final short USER_ROLE_ID_ADMINISTRATOR = 0;
	/** �û����н�ɫID - �ÿ� */
	public static final short USER_ROLE_ID_GUEST = 1;
	
	/** Session�й���Ա����Ϣ */
	public static final String SESSION_KEY_USER = "HJOY_USER_INFO";
	
	/** Cookie����Ϣ */
	public static final String COOKIE_KEY_AUTO_LOGIN = "HJOY_BLOG_AUTO_LOGIN";
	public static final String COOKIE_VALUE_AUTO_LOGIN = "TRUE";
	
	/** ������� */
	public interface ErrorCode {
		/** δ֪�쳣����ʾ��Ϣ */
		public static final String UNKNOW_ERROR_MESSAGE = "δ֪�쳣";
		
		/** �û���������Ϊ�� */
		public static final int EMPTY_NAME_OR_PWD = 10001;
		/** �û������������ */
		public static final int WRONG_NAME_OR_PWD = 10002;
		/** �Զ���¼ʧ�� */
		public static final int AUTO_LOGIN_FAILD = 10003;
		/**�����޴�����*/
		public static final int NOT_EXSIT_DATA = 90000;
	}
	
	/** ����·�� */
	public interface REQUEST_URL {
		/** ��ת��¼ҳ�� */
		public static final String TOLOGIN = "/admin/index.do";
		/** ��¼���� */
		public static final String LOGIN = "/admin/login.do";
	}
	
	/** ϵͳ����Key */
	public interface SYS_PARAM {
		/** �������� */
		public static final String BLOG_NAME = "blog_name";
	}
}
