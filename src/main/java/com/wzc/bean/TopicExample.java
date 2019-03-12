package com.wzc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopicExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("TID is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("TID is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("TID =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("TID <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("TID >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TID >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("TID <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("TID <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("TID in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("TID not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("TID between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("TID not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("ATTACHMENT is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("ATTACHMENT is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(Integer value) {
            addCriterion("ATTACHMENT =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(Integer value) {
            addCriterion("ATTACHMENT <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(Integer value) {
            addCriterion("ATTACHMENT >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATTACHMENT >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(Integer value) {
            addCriterion("ATTACHMENT <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(Integer value) {
            addCriterion("ATTACHMENT <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<Integer> values) {
            addCriterion("ATTACHMENT in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<Integer> values) {
            addCriterion("ATTACHMENT not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(Integer value1, Integer value2) {
            addCriterion("ATTACHMENT between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(Integer value1, Integer value2) {
            addCriterion("ATTACHMENT not between", value1, value2, "attachment");
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

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andCircleidIsNull() {
            addCriterion("CIRCLEID is null");
            return (Criteria) this;
        }

        public Criteria andCircleidIsNotNull() {
            addCriterion("CIRCLEID is not null");
            return (Criteria) this;
        }

        public Criteria andCircleidEqualTo(Integer value) {
            addCriterion("CIRCLEID =", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidNotEqualTo(Integer value) {
            addCriterion("CIRCLEID <>", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidGreaterThan(Integer value) {
            addCriterion("CIRCLEID >", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CIRCLEID >=", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidLessThan(Integer value) {
            addCriterion("CIRCLEID <", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidLessThanOrEqualTo(Integer value) {
            addCriterion("CIRCLEID <=", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidIn(List<Integer> values) {
            addCriterion("CIRCLEID in", values, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidNotIn(List<Integer> values) {
            addCriterion("CIRCLEID not in", values, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidBetween(Integer value1, Integer value2) {
            addCriterion("CIRCLEID between", value1, value2, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidNotBetween(Integer value1, Integer value2) {
            addCriterion("CIRCLEID not between", value1, value2, "circleid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andIsRecomIsNull() {
            addCriterion("IS_RECOM is null");
            return (Criteria) this;
        }

        public Criteria andIsRecomIsNotNull() {
            addCriterion("IS_RECOM is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecomEqualTo(String value) {
            addCriterion("IS_RECOM =", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomNotEqualTo(String value) {
            addCriterion("IS_RECOM <>", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomGreaterThan(String value) {
            addCriterion("IS_RECOM >", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomGreaterThanOrEqualTo(String value) {
            addCriterion("IS_RECOM >=", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomLessThan(String value) {
            addCriterion("IS_RECOM <", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomLessThanOrEqualTo(String value) {
            addCriterion("IS_RECOM <=", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomLike(String value) {
            addCriterion("IS_RECOM like", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomNotLike(String value) {
            addCriterion("IS_RECOM not like", value, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomIn(List<String> values) {
            addCriterion("IS_RECOM in", values, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomNotIn(List<String> values) {
            addCriterion("IS_RECOM not in", values, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomBetween(String value1, String value2) {
            addCriterion("IS_RECOM between", value1, value2, "isRecom");
            return (Criteria) this;
        }

        public Criteria andIsRecomNotBetween(String value1, String value2) {
            addCriterion("IS_RECOM not between", value1, value2, "isRecom");
            return (Criteria) this;
        }

        public Criteria andComTotalIsNull() {
            addCriterion("COM_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andComTotalIsNotNull() {
            addCriterion("COM_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andComTotalEqualTo(Integer value) {
            addCriterion("COM_TOTAL =", value, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalNotEqualTo(Integer value) {
            addCriterion("COM_TOTAL <>", value, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalGreaterThan(Integer value) {
            addCriterion("COM_TOTAL >", value, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("COM_TOTAL >=", value, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalLessThan(Integer value) {
            addCriterion("COM_TOTAL <", value, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalLessThanOrEqualTo(Integer value) {
            addCriterion("COM_TOTAL <=", value, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalIn(List<Integer> values) {
            addCriterion("COM_TOTAL in", values, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalNotIn(List<Integer> values) {
            addCriterion("COM_TOTAL not in", values, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalBetween(Integer value1, Integer value2) {
            addCriterion("COM_TOTAL between", value1, value2, "comTotal");
            return (Criteria) this;
        }

        public Criteria andComTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("COM_TOTAL not between", value1, value2, "comTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalIsNull() {
            addCriterion("VIEW_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andViewTotalIsNotNull() {
            addCriterion("VIEW_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andViewTotalEqualTo(Integer value) {
            addCriterion("VIEW_TOTAL =", value, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalNotEqualTo(Integer value) {
            addCriterion("VIEW_TOTAL <>", value, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalGreaterThan(Integer value) {
            addCriterion("VIEW_TOTAL >", value, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIEW_TOTAL >=", value, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalLessThan(Integer value) {
            addCriterion("VIEW_TOTAL <", value, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalLessThanOrEqualTo(Integer value) {
            addCriterion("VIEW_TOTAL <=", value, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalIn(List<Integer> values) {
            addCriterion("VIEW_TOTAL in", values, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalNotIn(List<Integer> values) {
            addCriterion("VIEW_TOTAL not in", values, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalBetween(Integer value1, Integer value2) {
            addCriterion("VIEW_TOTAL between", value1, value2, "viewTotal");
            return (Criteria) this;
        }

        public Criteria andViewTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("VIEW_TOTAL not between", value1, value2, "viewTotal");
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