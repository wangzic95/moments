package com.wzc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CircleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CircleExample() {
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

        public Criteria andCircleNameIsNull() {
            addCriterion("CIRCLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCircleNameIsNotNull() {
            addCriterion("CIRCLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCircleNameEqualTo(String value) {
            addCriterion("CIRCLE_NAME =", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotEqualTo(String value) {
            addCriterion("CIRCLE_NAME <>", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameGreaterThan(String value) {
            addCriterion("CIRCLE_NAME >", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameGreaterThanOrEqualTo(String value) {
            addCriterion("CIRCLE_NAME >=", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameLessThan(String value) {
            addCriterion("CIRCLE_NAME <", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameLessThanOrEqualTo(String value) {
            addCriterion("CIRCLE_NAME <=", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameLike(String value) {
            addCriterion("CIRCLE_NAME like", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotLike(String value) {
            addCriterion("CIRCLE_NAME not like", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameIn(List<String> values) {
            addCriterion("CIRCLE_NAME in", values, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotIn(List<String> values) {
            addCriterion("CIRCLE_NAME not in", values, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameBetween(String value1, String value2) {
            addCriterion("CIRCLE_NAME between", value1, value2, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotBetween(String value1, String value2) {
            addCriterion("CIRCLE_NAME not between", value1, value2, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleUseridIsNull() {
            addCriterion("CIRCLE_USERID is null");
            return (Criteria) this;
        }

        public Criteria andCircleUseridIsNotNull() {
            addCriterion("CIRCLE_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andCircleUseridEqualTo(Integer value) {
            addCriterion("CIRCLE_USERID =", value, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridNotEqualTo(Integer value) {
            addCriterion("CIRCLE_USERID <>", value, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridGreaterThan(Integer value) {
            addCriterion("CIRCLE_USERID >", value, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("CIRCLE_USERID >=", value, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridLessThan(Integer value) {
            addCriterion("CIRCLE_USERID <", value, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridLessThanOrEqualTo(Integer value) {
            addCriterion("CIRCLE_USERID <=", value, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridIn(List<Integer> values) {
            addCriterion("CIRCLE_USERID in", values, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridNotIn(List<Integer> values) {
            addCriterion("CIRCLE_USERID not in", values, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridBetween(Integer value1, Integer value2) {
            addCriterion("CIRCLE_USERID between", value1, value2, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("CIRCLE_USERID not between", value1, value2, "circleUserid");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameIsNull() {
            addCriterion("CIRCLE_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameIsNotNull() {
            addCriterion("CIRCLE_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameEqualTo(String value) {
            addCriterion("CIRCLE_USERNAME =", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameNotEqualTo(String value) {
            addCriterion("CIRCLE_USERNAME <>", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameGreaterThan(String value) {
            addCriterion("CIRCLE_USERNAME >", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("CIRCLE_USERNAME >=", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameLessThan(String value) {
            addCriterion("CIRCLE_USERNAME <", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameLessThanOrEqualTo(String value) {
            addCriterion("CIRCLE_USERNAME <=", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameLike(String value) {
            addCriterion("CIRCLE_USERNAME like", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameNotLike(String value) {
            addCriterion("CIRCLE_USERNAME not like", value, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameIn(List<String> values) {
            addCriterion("CIRCLE_USERNAME in", values, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameNotIn(List<String> values) {
            addCriterion("CIRCLE_USERNAME not in", values, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameBetween(String value1, String value2) {
            addCriterion("CIRCLE_USERNAME between", value1, value2, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleUsernameNotBetween(String value1, String value2) {
            addCriterion("CIRCLE_USERNAME not between", value1, value2, "circleUsername");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionIsNull() {
            addCriterion("CIRCLE_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionIsNotNull() {
            addCriterion("CIRCLE_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionEqualTo(String value) {
            addCriterion("CIRCLE_DESCRIPTION =", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionNotEqualTo(String value) {
            addCriterion("CIRCLE_DESCRIPTION <>", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionGreaterThan(String value) {
            addCriterion("CIRCLE_DESCRIPTION >", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("CIRCLE_DESCRIPTION >=", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionLessThan(String value) {
            addCriterion("CIRCLE_DESCRIPTION <", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionLessThanOrEqualTo(String value) {
            addCriterion("CIRCLE_DESCRIPTION <=", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionLike(String value) {
            addCriterion("CIRCLE_DESCRIPTION like", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionNotLike(String value) {
            addCriterion("CIRCLE_DESCRIPTION not like", value, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionIn(List<String> values) {
            addCriterion("CIRCLE_DESCRIPTION in", values, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionNotIn(List<String> values) {
            addCriterion("CIRCLE_DESCRIPTION not in", values, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionBetween(String value1, String value2) {
            addCriterion("CIRCLE_DESCRIPTION between", value1, value2, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCircleDescriptionNotBetween(String value1, String value2) {
            addCriterion("CIRCLE_DESCRIPTION not between", value1, value2, "circleDescription");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoIsNull() {
            addCriterion("CIRCLE_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoIsNotNull() {
            addCriterion("CIRCLE_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoEqualTo(String value) {
            addCriterion("CIRCLE_PHOTO =", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoNotEqualTo(String value) {
            addCriterion("CIRCLE_PHOTO <>", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoGreaterThan(String value) {
            addCriterion("CIRCLE_PHOTO >", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("CIRCLE_PHOTO >=", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoLessThan(String value) {
            addCriterion("CIRCLE_PHOTO <", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoLessThanOrEqualTo(String value) {
            addCriterion("CIRCLE_PHOTO <=", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoLike(String value) {
            addCriterion("CIRCLE_PHOTO like", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoNotLike(String value) {
            addCriterion("CIRCLE_PHOTO not like", value, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoIn(List<String> values) {
            addCriterion("CIRCLE_PHOTO in", values, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoNotIn(List<String> values) {
            addCriterion("CIRCLE_PHOTO not in", values, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoBetween(String value1, String value2) {
            addCriterion("CIRCLE_PHOTO between", value1, value2, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCirclePhotoNotBetween(String value1, String value2) {
            addCriterion("CIRCLE_PHOTO not between", value1, value2, "circlePhoto");
            return (Criteria) this;
        }

        public Criteria andCircleStateIsNull() {
            addCriterion("CIRCLE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andCircleStateIsNotNull() {
            addCriterion("CIRCLE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andCircleStateEqualTo(String value) {
            addCriterion("CIRCLE_STATE =", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateNotEqualTo(String value) {
            addCriterion("CIRCLE_STATE <>", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateGreaterThan(String value) {
            addCriterion("CIRCLE_STATE >", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateGreaterThanOrEqualTo(String value) {
            addCriterion("CIRCLE_STATE >=", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateLessThan(String value) {
            addCriterion("CIRCLE_STATE <", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateLessThanOrEqualTo(String value) {
            addCriterion("CIRCLE_STATE <=", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateLike(String value) {
            addCriterion("CIRCLE_STATE like", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateNotLike(String value) {
            addCriterion("CIRCLE_STATE not like", value, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateIn(List<String> values) {
            addCriterion("CIRCLE_STATE in", values, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateNotIn(List<String> values) {
            addCriterion("CIRCLE_STATE not in", values, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateBetween(String value1, String value2) {
            addCriterion("CIRCLE_STATE between", value1, value2, "circleState");
            return (Criteria) this;
        }

        public Criteria andCircleStateNotBetween(String value1, String value2) {
            addCriterion("CIRCLE_STATE not between", value1, value2, "circleState");
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