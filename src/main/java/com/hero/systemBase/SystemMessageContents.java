package com.hero.systemBase;

/**
 * 系统接口(终端使用)通讯消息常量定义
 * @author chenwenwei
 * @time 2018.10.20
 */
public class SystemMessageContents {

	/**
	 * 错误码
	 * 
	 */
	public static class ErrorCode {
		/**
		 * ************************数据通用信息处理错误码**********************************
		 */
		public static final int MESSAGE_COMMON_CODE = 201; // 消息通用错误码标记
		public static final int MESSAGE_COMMON_PARAM_ERROR = 202; // 请求参数不完整
		public static final int MESSAGE_COMMON_DATA_TYPE_ERROR = 203; // 数据类型有误
		public static final int MESSAGE_COMMON_DATA_NULL_ERROR = 204; // 数据为空
		public static final int MESSAGE_COMMON_DATA_JSON2VO_ERROR = 205; // JSON数据转化为VO对象异常
		public static final int MESSAGE_DIR_PATH_PROGRESS_ERROR = 206; // 目录组装失败
		public static final int MESSAGE_SERVER_RESPONSE_NULL = 207; // 服务器返回数据为空,响应异常
		public static final int MESSAGE_SERVER_PAGEINFO_RESPONSE_NULL = 208; // 查询分页请求参数有误
		public static final int MESSAGE_SERVER_INVID_TOKEN_ERROR = 209; // 系统token过期或者非法凭证请求有误
		public static final int MESSAGE_SERVER_IDENTITY_CHECK_ERROR = 210; // 身份验证失败
		public static final int MESSAGE_SERVER_REMOTE_CONTRAL_MSG_ERROR = 211; // 透传消息失败（远程控制消息）
		public static final int MESSAGE_SERVER_INVID_CHECK_ERROR = 212; // 系统密码安全有效性检测失败
		public static final int MESSAGE_USERS_CONFIG_PASSWORD_ERROR = 213; // 修改密码时错误
		public static final int MESSAGE_SERVER_UPDATEDATE_EMPTY = 214; // 待修改记录为0条
		public static final int MESSAGE_SERVER_PARAM_EMPTY = 215; // 待修改记录为0条

		/**
		 * ************************用户信息相关错误码************************************
		 */
		public static final int MESSAGE_USERS_REGISTER_ERROR = 301; // 用户注册失败
		public static final int MESSAGE_USERS_NOT_EXTIS_ERROR = 302; // 用户不存在
		public static final int MESSAGE_USERS_ALREADY_EXTIS_ERROR = 303; // 用户已存在
		public static final int MESSAGE_USERS_LOGIN_ERROR = 305; // 用户登录失败，手机号码或者密码错误
		public static final int MESSAGE_USERS_FREEZED_ERROR = 304; // 用户已经被冻结
		public static final int MESSAGE_USERS_NAME_NULL_ERROR = 306; // 用户名为空
		public static final int MESSAGE_USERS_PWD_NULL_ERROR = 307; // 密码为空
		public static final int MESSAGE_USERS_MOBILE_ALREADY_EXTIS_ERROR = 308; // 手机号码已经注册
		public static final int MESSAGE_USERS_EMAIL_ALREADY_EXTIS_ERROR = 309; // 邮箱已经注册
		public static final int MESSAGE_USERS_MOBILE_NULL_ERROR = 310; // 手机号码已经注册
		public static final int MESSAGE_USERS_MOBILE_NOT_EXTIS_ERROR = 311; // 手机号码不存在
		public static final int MESSAGE_USERS_OLDPWD_NULL_ERROR = 312; // 用户旧密码为空
		public static final int MESSAGE_USERS_SYSTEM_ERROR = 313; // 系统操作用户内部错误
		public static final int MESSAGE_USERS_TOKEN_ERROR = 314; // 系统用户凭证token参数有误
		public static final int MESSAGE_USERS_SYNCINFO_ERROR = 315; // 系统用户数据信息未同步
		public static final int MESSAGE_USERS_AUTH_DOING_ERROR = 316; // 系统用户账号在审核中
		public static final int MESSAGE_USERS_AUTH_FAILED_ERROR = 317; // 系统用户账号审核失败,重新申请审核
		public static final int MESSAGE_USERS_ADD_SUB_FAILED_ERROR = 318; // 分配子账户失败
		public static final int MESSAGE_USERS_ADD_SUB_MORETHAN_MAX_VALUE_ERROR = 319; // 分配子账户已超过最大值
		public static final int MESSAGE_ADDRESS_ALREADY_EXTIS_ERROR = 320; // 收货地址不存在
		public static final int MESSAGE_WY_USERS_NOT_EXTIS_ERROR = 321; // 角色有误
		public static final int MESSAGE_YZX_NOT_EXTIS_ERROR = 360; 
		public static final int MESSAGE_FINGER_IS_OVER_EXTIS_ERROR = 361; 
		public static final int MESSAGE_PARK_ISNOT_OPEN_ERROR = 363; 

		/**
		 * ************************用户意见反馈相关错误码**********************************
		 */
		public static final int MESSAGE_FEEDBACK_SUBMIT_ERROR = 401; // 用户意见反馈提交失败
		public static final int MESSAGE_FEEDBACK_CONTENT_PARAM_ERROR = 402; // 用户意见请求内容参数有误

		/*************************** APP版本更新 **********************************************/
		public static final int NO_LATEST_VERSION = 402; // 没有最新版本
		public static final int MESSAGE_APP_INFO_ERROR = 403; // app信息有误
		public static final int MESSAGE_APP_ALREADY_UPDATED_ERROR = 404; // 当前app已经是最新版本
		public static final int MESSAGE_APP_JPUSH_IS_EXSITS = 405; // 激光已经注册

		/**
		 * ************************用户第三方授权信息相关错误码*******************************
		 */
		public static final int MESSAGE_USERS_OTHERS_AUTH_ERROR = 501; // 终端乐谱用户授权错误码

		public static final int MESSAGE_NOT_DRIVING_ORDER = 502; // 该单已经被接了
		public static final int MESSAGE_NOT_DRIVING_CANCEL_ORDER = 503; // 订单取消失败

		/**
		 * ************************用户呼叫相关错误码************************************
		 */
		public static final int MESSAGE_CALL_NUMBER_ERROR = 601; // 呼叫号码有误
		public static final int MESSAGE_CALL_TO_USERS_NOT_FIND_ERROR = 602; // 呼叫的房间号匹配不到对应用户

		/**
		 * ************************物业相关错误码**************************************
		 */
		public static final int MESSAGE_PROPERTY_DEVICE_NOT_AUTH_ORDER = 702; // 终端设备未授权
		public static final int MESSAGE_PROPERTY_QUATER_NOT_EXITS = 703; // 物业小区不存在
		public static final int MESSAGE_PROPERTY_DEVICE_NOT_EXITS = 704;// 根据mac地址无法查询到设备
		public static final int MESSAGE_PROPERTY_BLOCK_CELL_UNIT_NOT_EXITS = 705;// 没有楼栋单元住户信息

	}

	/**
	 * 成功（正确）码
	 * 
	 * @author chenwenwei
	 * 
	 */
	public static class SuccessCode {

		public static final int MESSAGE_SUCCESS_CODE = 101; // 消息通用成功码标记

	}
}
