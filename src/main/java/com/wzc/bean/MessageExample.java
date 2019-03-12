package com.wzc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andFromidIsNull() {
            addCriterion("FROMID is null");
            return (Criteria) this;
        }

        public Criteria andFromidIsNotNull() {
            addCriterion("FROMID is not null");
            return (Criteria) this;
        }

        public Criteria andFromidEqualTo(Integer value) {
            addCriterion("FROMID =", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotEqualTo(Integer value) {
            addCriterion("FROMID <>", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidGreaterThan(Integer value) {
            addCriterion("FROMID >", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FROMID >=", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidLessThan(Integer value) {
            addCriterion("FROMID <", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidLessThanOrEqualTo(Integer value) {
            addCriterion("FROMID <=", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidIn(List<Integer> values) {
            addCriterion("FROMID in", values, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotIn(List<Integer> values) {
            addCriterion("FROMID not in", values, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidBetween(Integer value1, Integer value2) {
            addCriterion("FROMID between", value1, value2, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotBetween(Integer value1, Integer value2) {
            addCriterion("FROMID not between", value1, value2, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromnameIsNull() {
            addCriterion("FROMNAME is null");
            return (Criteria) this;
        }

        public Criteria andFromnameIsNotNull() {
            addCriterion("FROMNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFromnameEqualTo(String value) {
            addCriterion("FROMNAME =", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotEqualTo(String value) {
            addCriterion("FROMNAME <>", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameGreaterThan(String value) {
            addCriterion("FROMNAME >", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameGreaterThanOrEqualTo(String value) {
            addCriterion("FROMNAME >=", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameLessThan(String value) {
            addCriterion("FROMNAME <", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameLessThanOrEqualTo(String value) {
            addCriterion("FROMNAME <=", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameLike(String value) {
            addCriterion("FROMNAME like", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotLike(String value) {
            addCriterion("FROMNAME not like", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameIn(List<String> values) {
            addCriterion("FROMNAME in", values, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotIn(List<String> values) {
            addCriterion("FROMNAME not in", values, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameBetween(String value1, String value2) {
            addCriterion("FROMNAME between", value1, value2, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotBetween(String value1, String value2) {
            addCriterion("FROMNAME not between", value1, value2, "fromname");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNull() {
            addCriterion("TARGETID is null");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNotNull() {
            addCriterion("TARGETID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetidEqualTo(Integer value) {
            addCriterion("TARGETID =", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotEqualTo(Integer value) {
            addCriterion("TARGETID <>", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThan(Integer value) {
            addCriterion("TARGETID >", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARGETID >=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThan(Integer value) {
            addCriterion("TARGETID <", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThanOrEqualTo(Integer value) {
            addCriterion("TARGETID <=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidIn(List<Integer> values) {
            addCriterion("TARGETID in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotIn(List<Integer> values) {
            addCriterion("TARGETID not in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidBetween(Integer value1, Integer value2) {
            addCriterion("TARGETID between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotBetween(Integer value1, Integer value2) {
            addCriterion("TARGETID not between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetnameIsNull() {
            addCriterion("TARGETNAME is null");
            return (Criteria) this;
        }

        public Criteria andTargetnameIsNotNull() {
            addCriterion("TARGETNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTargetnameEqualTo(String value) {
            addCriterion("TARGETNAME =", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotEqualTo(String value) {
            addCriterion("TARGETNAME <>", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameGreaterThan(String value) {
            addCriterion("TARGETNAME >", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameGreaterThanOrEqualTo(String value) {
            addCriterion("TARGETNAME >=", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLessThan(String value) {
            addCriterion("TARGETNAME <", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLessThanOrEqualTo(String value) {
            addCriterion("TARGETNAME <=", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLike(String value) {
            addCriterion("TARGETNAME like", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotLike(String value) {
            addCriterion("TARGETNAME not like", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameIn(List<String> values) {
            addCriterion("TARGETNAME in", values, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotIn(List<String> values) {
            addCriterion("TARGETNAME not in", values, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameBetween(String value1, String value2) {
            addCriterion("TARGETNAME between", value1, value2, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotBetween(String value1, String value2) {
            addCriterion("TARGETNAME not between", value1, value2, "targetname");
            return (Criteria) this;
        }

        public Criteria andMsgbodyIsNull() {
            addCriterion("MSGBODY is null");
            return (Criteria) this;
        }

        public Criteria andMsgbodyIsNotNull() {
            addCriterion("MSGBODY is not null");
            return (Criteria) this;
        }

        public Criteria andMsgbodyEqualTo(String value) {
            addCriterion("MSGBODY =", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotEqualTo(String value) {
            addCriterion("MSGBODY <>", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyGreaterThan(String value) {
            addCriterion("MSGBODY >", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyGreaterThanOrEqualTo(String value) {
            addCriterion("MSGBODY >=", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyLessThan(String value) {
            addCriterion("MSGBODY <", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyLessThanOrEqualTo(String value) {
            addCriterion("MSGBODY <=", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyLike(String value) {
            addCriterion("MSGBODY like", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotLike(String value) {
            addCriterion("MSGBODY not like", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyIn(List<String> values) {
            addCriterion("MSGBODY in", values, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotIn(List<String> values) {
            addCriterion("MSGBODY not in", values, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyBetween(String value1, String value2) {
            addCriterion("MSGBODY between", value1, value2, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotBetween(String value1, String value2) {
            addCriterion("MSGBODY not between", value1, value2, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("MSGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("MSGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(String value) {
            addCriterion("MSGTYPE =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(String value) {
            addCriterion("MSGTYPE <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(String value) {
            addCriterion("MSGTYPE >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MSGTYPE >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(String value) {
            addCriterion("MSGTYPE <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(String value) {
            addCriterion("MSGTYPE <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLike(String value) {
            addCriterion("MSGTYPE like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotLike(String value) {
            addCriterion("MSGTYPE not like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<String> values) {
            addCriterion("MSGTYPE in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<String> values) {
            addCriterion("MSGTYPE not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(String value1, String value2) {
            addCriterion("MSGTYPE between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(String value1, String value2) {
            addCriterion("MSGTYPE not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgextrasIsNull() {
            addCriterion("MSGEXTRAS is null");
            return (Criteria) this;
        }

        public Criteria andMsgextrasIsNotNull() {
            addCriterion("MSGEXTRAS is not null");
            return (Criteria) this;
        }

        public Criteria andMsgextrasEqualTo(String value) {
            addCriterion("MSGEXTRAS =", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotEqualTo(String value) {
            addCriterion("MSGEXTRAS <>", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasGreaterThan(String value) {
            addCriterion("MSGEXTRAS >", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasGreaterThanOrEqualTo(String value) {
            addCriterion("MSGEXTRAS >=", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasLessThan(String value) {
            addCriterion("MSGEXTRAS <", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasLessThanOrEqualTo(String value) {
            addCriterion("MSGEXTRAS <=", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasLike(String value) {
            addCriterion("MSGEXTRAS like", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotLike(String value) {
            addCriterion("MSGEXTRAS not like", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasIn(List<String> values) {
            addCriterion("MSGEXTRAS in", values, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotIn(List<String> values) {
            addCriterion("MSGEXTRAS not in", values, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasBetween(String value1, String value2) {
            addCriterion("MSGEXTRAS between", value1, value2, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotBetween(String value1, String value2) {
            addCriterion("MSGEXTRAS not between", value1, value2, "msgextras");
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

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
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