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
-- 0907