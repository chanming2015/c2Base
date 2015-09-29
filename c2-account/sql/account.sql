DROP TABLE IF EXISTS `run_account`;
CREATE TABLE `run_account` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(20) NOT NULL UNIQUE,
  `account_balance` decimal(10,2) NOT NULL DEFAULT '0',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) DEFAULT b'0',
  `version` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ali_notice`;
CREATE TABLE `ali_notice` (
  `id` bigint(20) NOT NULL,
  `trade_status` varchar(20) default null COMMENT '交易状态',
  `notify_id` varchar(64) not null COMMENT '通知校验 ID',
  `notify_time` datetime not null COMMENT '通知时间',
  `notify_type` varchar(25) not null COMMENT '通知类型 ',
  `sign_type` varchar(8) not null COMMENT '签名方式',
  `out_trade_no` varchar(20) default null COMMENT '商户网站唯一订单号',
  `subject` varchar(24) default null COMMENT '商品名称',
  `payment_type` varchar(4) default null COMMENT '支付类型',
  `trade_no` varchar(64) default null COMMENT'交易流水号',
  `seller_id` varchar(30) default null COMMENT'卖家支付宝用户号',
  `seller_email` varchar(100) default null COMMENT'卖家支付宝账号',
  `buyer_id` varchar(30) default null COMMENT'买家支付宝用户号',
  `buyer_email` varchar(100) default null COMMENT'买家支付宝账号',
  `total_fee` varchar(10) default null COMMENT'交易金额',
  `quantity` varchar(4) default null COMMENT'购买数量',
  `price` varchar(10) default null COMMENT'商品单价',
  `body` varchar(512) default null COMMENT'商品描述',
  `gmt_create` datetime default null COMMENT'交易创建时间',
  `gmt_payment` datetime default null COMMENT'交易付款时间',
  `refund_status` varchar(20) default null COMMENT'退款状态',
  `gmt_refund` datetime default null COMMENT'退款时间 ',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) DEFAULT b'0',
  `version` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ali_refund_notice`;
CREATE TABLE `ali_refund_notice` (
  `id` bigint(20) NOT NULL,
  `notify_id` varchar(64) not null COMMENT '通知校验 ID',
  `notify_time` datetime not null COMMENT '通知时间',
  `notify_type` varchar(25) not null COMMENT '通知类型 ',
  `batch_no` varchar(20) not null COMMENT '退款批次号',
  `success_num` varchar(4) not null COMMENT '退款成功总数',
  `result_details` varchar(128) default null COMMENT '退款结果明细',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) DEFAULT b'0',
  `version` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
-- 0907

DROP TABLE IF EXISTS `scan_pay_res_data`;
CREATE TABLE `scan_pay_res_data` (
 `id` bigint(20) NOT NULL,
  `return_code` varchar(16) not null COMMENT '返回状态码',
  `return_msg` varchar(128) default null COMMENT '返回信息',
  `appid` varchar(32) default null COMMENT '公众账号ID',
  `mch_id` varchar(32) default null COMMENT '商户号 ',
  `nonce_str` varchar(32) default null COMMENT '随机字符串',
  `sign` varchar(32) default null COMMENT '签名',
  `result_code` varchar(16) default null COMMENT '业务结果',
  `err_code` varchar(32) default null COMMENT '错误代码',
  `err_code_des` varchar(128) default null COMMENT'错误代码描述',
  `device_info` varchar(32) default null COMMENT'设备号',
  `openid` varchar(128) default null COMMENT'用户标识',
  `is_subscribe` char(1) default null COMMENT'是否关注公众账号',
  `trade_type` varchar(16) default null COMMENT'交易类型',
  `bank_type` varchar(16) default null COMMENT'付款银行',
  `total_fee` mediumint(7) default null COMMENT'总金额',
  `coupon_fee` mediumint(7) default null COMMENT'代金券或立减优惠金额',
  `fee_type` varchar(8) default null COMMENT'货币种类',
  `transaction_id` varchar(32) default null COMMENT'微信支付订单号',
  `out_trade_no` varchar(32) default null COMMENT'商户订单号',
  `attach` varchar(128) default null COMMENT'附加数据',
  `time_end` datetime default null COMMENT'支付完成时间',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) DEFAULT b'0',
  `version` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
-- 0921

DROP TABLE IF EXISTS `refund_res_data`;
CREATE TABLE `refund_res_data` (
 `id` bigint(20) NOT NULL,
  `return_code` varchar(16) not null COMMENT '返回状态码',
  `return_msg` varchar(128) default null COMMENT '返回信息',
  `appid` varchar(32) default null COMMENT '公众账号ID',
  `mch_id` varchar(32) default null COMMENT '商户号 ',
  `device_info` varchar(32) default null COMMENT'设备号',
  `nonce_str` varchar(32) default null COMMENT '随机字符串',
  `sign` varchar(32) default null COMMENT '签名',
  `result_code` varchar(16) default null COMMENT '业务结果',
  `err_code` varchar(32) default null COMMENT '错误代码',
  `err_code_des` varchar(128) default null COMMENT'错误代码描述',
  `transaction_id` varchar(32) default null COMMENT'微信订单号',
  `out_trade_no` varchar(32) default null COMMENT'商户订单号',
  `out_refund_no` varchar(32) default null COMMENT'商户退款单号',
  `refund_id` varchar(32) default null COMMENT'微信退款单号',
  `refund_fee` mediumint(7) default null COMMENT'退款金额',
  `coupon_refund_fee` mediumint(7) default null COMMENT'代金券或立减优惠退款金额',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) DEFAULT b'0',
  `version` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
--0929