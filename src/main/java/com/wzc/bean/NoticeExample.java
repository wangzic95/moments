package com.wzc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNull() {
            addCriterion("NOTICE_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNotNull() {
            addCriterion("NOTICE_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleEqualTo(String value) {
            addCriterion("NOTICE_TITLE =", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotEqualTo(String value) {
            addCriterion("NOTICE_TITLE <>", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThan(String value) {
            addCriterion("NOTICE_TITLE >", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_TITLE >=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThan(String value) {
            addCriterion("NOTICE_TITLE <", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_TITLE <=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLike(String value) {
            addCriterion("NOTICE_TITLE like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotLike(String value) {
            addCriterion("NOTICE_TITLE not like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIn(List<String> values) {
            addCriterion("NOTICE_TITLE in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotIn(List<String> values) {
            addCriterion("NOTICE_TITLE not in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleBetween(String value1, String value2) {
            addCriterion("NOTICE_TITLE between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotBetween(String value1, String value2) {
            addCriterion("NOTICE_TITLE not between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridIsNull() {
            addCriterion("NOTICE_USERID is null");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridIsNotNull() {
            addCriterion("NOTICE_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridEqualTo(Integer value) {
            addCriterion("NOTICE_USERID =", value, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridNotEqualTo(Integer value) {
            addCriterion("NOTICE_USERID <>", value, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridGreaterThan(Integer value) {
            addCriterion("NOTICE_USERID >", value, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("NOTICE_USERID >=", value, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridLessThan(Integer value) {
            addCriterion("NOTICE_USERID <", value, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridLessThanOrEqualTo(Integer value) {
            addCriterion("NOTICE_USERID <=", value, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridIn(List<Integer> values) {
            addCriterion("NOTICE_USERID in", values, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridNotIn(List<Integer> values) {
            addCriterion("NOTICE_USERID not in", values, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridBetween(Integer value1, Integer value2) {
            addCriterion("NOTICE_USERID between", value1, value2, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("NOTICE_USERID not between", value1, value2, "noticeUserid");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameIsNull() {
            addCriterion("NOTICE_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameIsNotNull() {
            addCriterion("NOTICE_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameEqualTo(String value) {
            addCriterion("NOTICE_USERNAME =", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameNotEqualTo(String value) {
            addCriterion("NOTICE_USERNAME <>", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameGreaterThan(String value) {
            addCriterion("NOTICE_USERNAME >", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_USERNAME >=", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameLessThan(String value) {
            addCriterion("NOTICE_USERNAME <", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_USERNAME <=", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameLike(String value) {
            addCriterion("NOTICE_USERNAME like", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameNotLike(String value) {
            addCriterion("NOTICE_USERNAME not like", value, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameIn(List<String> values) {
            addCriterion("NOTICE_USERNAME in", values, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameNotIn(List<String> values) {
            addCriterion("NOTICE_USERNAME not in", values, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameBetween(String value1, String value2) {
            addCriterion("NOTICE_USERNAME between", value1, value2, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeUsernameNotBetween(String value1, String value2) {
            addCriterion("NOTICE_USERNAME not between", value1, value2, "noticeUsername");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNull() {
            addCriterion("NOTICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNotNull() {
            addCriterion("NOTICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeEqualTo(String value) {
            addCriterion("NOTICE_TYPE =", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotEqualTo(String value) {
            addCriterion("NOTICE_TYPE <>", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThan(String value) {
            addCriterion("NOTICE_TYPE >", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE >=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThan(String value) {
            addCriterion("NOTICE_TYPE <", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE <=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLike(String value) {
            addCriterion("NOTICE_TYPE like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotLike(String value) {
            addCriterion("NOTICE_TYPE not like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIn(List<String> values) {
            addCriterion("NOTICE_TYPE in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotIn(List<String> values) {
            addCriterion("NOTICE_TYPE not in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE not between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidIsNull() {
            addCriterion("NOTICE_FILEID is null");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidIsNotNull() {
            addCriterion("NOTICE_FILEID is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidEqualTo(Integer value) {
            addCriterion("NOTICE_FILEID =", value, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidNotEqualTo(Integer value) {
            addCriterion("NOTICE_FILEID <>", value, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidGreaterThan(Integer value) {
            addCriterion("NOTICE_FILEID >", value, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidGreaterThanOrEqualTo(Integer value) {
            addCriterion("NOTICE_FILEID >=", value, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidLessThan(Integer value) {
            addCriterion("NOTICE_FILEID <", value, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidLessThanOrEqualTo(Integer value) {
            addCriterion("NOTICE_FILEID <=", value, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidIn(List<Integer> values) {
            addCriterion("NOTICE_FILEID in", values, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidNotIn(List<Integer> values) {
            addCriterion("NOTICE_FILEID not in", values, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidBetween(Integer value1, Integer value2) {
            addCriterion("NOTICE_FILEID between", value1, value2, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andNoticeFileidNotBetween(Integer value1, Integer value2) {
            addCriterion("NOTICE_FILEID not between", value1, value2, "noticeFileid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}