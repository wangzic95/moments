package com.wzc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentsExample() {
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

        public Criteria andCommentUseridIsNull() {
            addCriterion("COMMENT_USERID is null");
            return (Criteria) this;
        }

        public Criteria andCommentUseridIsNotNull() {
            addCriterion("COMMENT_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUseridEqualTo(Integer value) {
            addCriterion("COMMENT_USERID =", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridNotEqualTo(Integer value) {
            addCriterion("COMMENT_USERID <>", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridGreaterThan(Integer value) {
            addCriterion("COMMENT_USERID >", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_USERID >=", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridLessThan(Integer value) {
            addCriterion("COMMENT_USERID <", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridLessThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_USERID <=", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridIn(List<Integer> values) {
            addCriterion("COMMENT_USERID in", values, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridNotIn(List<Integer> values) {
            addCriterion("COMMENT_USERID not in", values, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_USERID between", value1, value2, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_USERID not between", value1, value2, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameIsNull() {
            addCriterion("COMMENT_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameIsNotNull() {
            addCriterion("COMMENT_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameEqualTo(String value) {
            addCriterion("COMMENT_USERNAME =", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameNotEqualTo(String value) {
            addCriterion("COMMENT_USERNAME <>", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameGreaterThan(String value) {
            addCriterion("COMMENT_USERNAME >", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENT_USERNAME >=", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameLessThan(String value) {
            addCriterion("COMMENT_USERNAME <", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameLessThanOrEqualTo(String value) {
            addCriterion("COMMENT_USERNAME <=", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameLike(String value) {
            addCriterion("COMMENT_USERNAME like", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameNotLike(String value) {
            addCriterion("COMMENT_USERNAME not like", value, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameIn(List<String> values) {
            addCriterion("COMMENT_USERNAME in", values, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameNotIn(List<String> values) {
            addCriterion("COMMENT_USERNAME not in", values, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameBetween(String value1, String value2) {
            addCriterion("COMMENT_USERNAME between", value1, value2, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentUsernameNotBetween(String value1, String value2) {
            addCriterion("COMMENT_USERNAME not between", value1, value2, "commentUsername");
            return (Criteria) this;
        }

        public Criteria andCommentBodyIsNull() {
            addCriterion("COMMENT_BODY is null");
            return (Criteria) this;
        }

        public Criteria andCommentBodyIsNotNull() {
            addCriterion("COMMENT_BODY is not null");
            return (Criteria) this;
        }

        public Criteria andCommentBodyEqualTo(String value) {
            addCriterion("COMMENT_BODY =", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotEqualTo(String value) {
            addCriterion("COMMENT_BODY <>", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyGreaterThan(String value) {
            addCriterion("COMMENT_BODY >", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENT_BODY >=", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyLessThan(String value) {
            addCriterion("COMMENT_BODY <", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyLessThanOrEqualTo(String value) {
            addCriterion("COMMENT_BODY <=", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyLike(String value) {
            addCriterion("COMMENT_BODY like", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotLike(String value) {
            addCriterion("COMMENT_BODY not like", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyIn(List<String> values) {
            addCriterion("COMMENT_BODY in", values, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotIn(List<String> values) {
            addCriterion("COMMENT_BODY not in", values, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyBetween(String value1, String value2) {
            addCriterion("COMMENT_BODY between", value1, value2, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotBetween(String value1, String value2) {
            addCriterion("COMMENT_BODY not between", value1, value2, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidIsNull() {
            addCriterion("COMMENT_ANNID is null");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidIsNotNull() {
            addCriterion("COMMENT_ANNID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidEqualTo(Integer value) {
            addCriterion("COMMENT_ANNID =", value, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidNotEqualTo(Integer value) {
            addCriterion("COMMENT_ANNID <>", value, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidGreaterThan(Integer value) {
            addCriterion("COMMENT_ANNID >", value, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_ANNID >=", value, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidLessThan(Integer value) {
            addCriterion("COMMENT_ANNID <", value, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidLessThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_ANNID <=", value, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidIn(List<Integer> values) {
            addCriterion("COMMENT_ANNID in", values, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidNotIn(List<Integer> values) {
            addCriterion("COMMENT_ANNID not in", values, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_ANNID between", value1, value2, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentAnnidNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_ANNID not between", value1, value2, "commentAnnid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidIsNull() {
            addCriterion("COMMENT_TARGETID is null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidIsNotNull() {
            addCriterion("COMMENT_TARGETID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidEqualTo(Integer value) {
            addCriterion("COMMENT_TARGETID =", value, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidNotEqualTo(Integer value) {
            addCriterion("COMMENT_TARGETID <>", value, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidGreaterThan(Integer value) {
            addCriterion("COMMENT_TARGETID >", value, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_TARGETID >=", value, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidLessThan(Integer value) {
            addCriterion("COMMENT_TARGETID <", value, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidLessThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_TARGETID <=", value, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidIn(List<Integer> values) {
            addCriterion("COMMENT_TARGETID in", values, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidNotIn(List<Integer> values) {
            addCriterion("COMMENT_TARGETID not in", values, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_TARGETID between", value1, value2, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetidNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_TARGETID not between", value1, value2, "commentTargetid");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameIsNull() {
            addCriterion("COMMENT_TARGETNAME is null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameIsNotNull() {
            addCriterion("COMMENT_TARGETNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameEqualTo(String value) {
            addCriterion("COMMENT_TARGETNAME =", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameNotEqualTo(String value) {
            addCriterion("COMMENT_TARGETNAME <>", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameGreaterThan(String value) {
            addCriterion("COMMENT_TARGETNAME >", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENT_TARGETNAME >=", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameLessThan(String value) {
            addCriterion("COMMENT_TARGETNAME <", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameLessThanOrEqualTo(String value) {
            addCriterion("COMMENT_TARGETNAME <=", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameLike(String value) {
            addCriterion("COMMENT_TARGETNAME like", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameNotLike(String value) {
            addCriterion("COMMENT_TARGETNAME not like", value, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameIn(List<String> values) {
            addCriterion("COMMENT_TARGETNAME in", values, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameNotIn(List<String> values) {
            addCriterion("COMMENT_TARGETNAME not in", values, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameBetween(String value1, String value2) {
            addCriterion("COMMENT_TARGETNAME between", value1, value2, "commentTargetname");
            return (Criteria) this;
        }

        public Criteria andCommentTargetnameNotBetween(String value1, String value2) {
            addCriterion("COMMENT_TARGETNAME not between", value1, value2, "commentTargetname");
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