create table shouldRepayInfo(
    
     ID bigint NOT NULL AUTO_INCREMENT  COMMENT 'ID',
     ApplyID bigint COMMENT '贷款申请id',
     ContractID bigint  COMMENT '贷款合同id',
     
     ShouldRepayAmount decimal(18,2) default 0.00 COMMENT '应还本金金额',
     FactRepayAmount decimal(18,2) default 0.00 COMMENT '实还本金金额',
    
     ShouldRepayInterst decimal(18,2) default 0.00 COMMENT '应还利息',
     FactRepayInterst decimal(18,2) default 0.00 COMMENT '实还利息',
    
     ShouldRepayLateAmount decimal(18,2) default 0.00 COMMENT '应还逾期本金罚息金额',
     FactRepayLateAmount decimal(18,2) default 0.00 COMMENT '实还逾期本金罚息金额',
     
     ShouldRepayLateInterst decimal(18,2) default 0.00 COMMENT '应还逾期罚息利息金额',
     FactRepayLateInterst decimal(18,2) default 0.00 COMMENT '实还逾期罚息利息金额',
     
     CollectLoanInterest decimal(18,2) default 0.00 COMMENT '手续费',
     
     repayDate datetime  default null COMMENT '还款时间',
     loanTime integer default 0 COMMENT '期限',
     style integer  default 0  COMMENT '状态 --1 已结清，2 逾期，3 待还，4，提前结清',
     PRIMARY KEY(ID)
    
)