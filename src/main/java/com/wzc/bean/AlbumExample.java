package com.wzc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlbumExample() {
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

        public Criteria andAlbumNameIsNull() {
            addCriterion("ALBUM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNotNull() {
            addCriterion("ALBUM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameEqualTo(String value) {
            addCriterion("ALBUM_NAME =", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotEqualTo(String value) {
            addCriterion("ALBUM_NAME <>", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThan(String value) {
            addCriterion("ALBUM_NAME >", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThanOrEqualTo(String value) {
            addCriterion("ALBUM_NAME >=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThan(String value) {
            addCriterion("ALBUM_NAME <", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThanOrEqualTo(String value) {
            addCriterion("ALBUM_NAME <=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLike(String value) {
            addCriterion("ALBUM_NAME like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotLike(String value) {
            addCriterion("ALBUM_NAME not like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIn(List<String> values) {
            addCriterion("ALBUM_NAME in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotIn(List<String> values) {
            addCriterion("ALBUM_NAME not in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameBetween(String value1, String value2) {
            addCriterion("ALBUM_NAME between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotBetween(String value1, String value2) {
            addCriterion("ALBUM_NAME not between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverIsNull() {
            addCriterion("ALBUM_COVER is null");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverIsNotNull() {
            addCriterion("ALBUM_COVER is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverEqualTo(String value) {
            addCriterion("ALBUM_COVER =", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverNotEqualTo(String value) {
            addCriterion("ALBUM_COVER <>", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverGreaterThan(String value) {
            addCriterion("ALBUM_COVER >", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverGreaterThanOrEqualTo(String value) {
            addCriterion("ALBUM_COVER >=", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverLessThan(String value) {
            addCriterion("ALBUM_COVER <", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverLessThanOrEqualTo(String value) {
            addCriterion("ALBUM_COVER <=", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverLike(String value) {
            addCriterion("ALBUM_COVER like", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverNotLike(String value) {
            addCriterion("ALBUM_COVER not like", value, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverIn(List<String> values) {
            addCriterion("ALBUM_COVER in", values, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverNotIn(List<String> values) {
            addCriterion("ALBUM_COVER not in", values, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverBetween(String value1, String value2) {
            addCriterion("ALBUM_COVER between", value1, value2, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumCoverNotBetween(String value1, String value2) {
            addCriterion("ALBUM_COVER not between", value1, value2, "albumCover");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridIsNull() {
            addCriterion("ALBUM_USERID is null");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridIsNotNull() {
            addCriterion("ALBUM_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridEqualTo(Integer value) {
            addCriterion("ALBUM_USERID =", value, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridNotEqualTo(Integer value) {
            addCriterion("ALBUM_USERID <>", value, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridGreaterThan(Integer value) {
            addCriterion("ALBUM_USERID >", value, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALBUM_USERID >=", value, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridLessThan(Integer value) {
            addCriterion("ALBUM_USERID <", value, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridLessThanOrEqualTo(Integer value) {
            addCriterion("ALBUM_USERID <=", value, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridIn(List<Integer> values) {
            addCriterion("ALBUM_USERID in", values, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridNotIn(List<Integer> values) {
            addCriterion("ALBUM_USERID not in", values, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridBetween(Integer value1, Integer value2) {
            addCriterion("ALBUM_USERID between", value1, value2, "albumUserid");
            return (Criteria) this;
        }

        public Criteria andAlbumUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("ALBUM_USERID not between", value1, value2, "albumUserid");
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