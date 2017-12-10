package com.worldunion.prophesy.model.account;

import com.worldunion.prophesy.generator.page.Page;
import java.util.ArrayList;
import java.util.List;

public class GroupResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public GroupResourceExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdIsNull() {
            addCriterion("FK_RESOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdIsNotNull() {
            addCriterion("FK_RESOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdEqualTo(String value) {
            addCriterion("FK_RESOURCE_ID =", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdNotEqualTo(String value) {
            addCriterion("FK_RESOURCE_ID <>", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdGreaterThan(String value) {
            addCriterion("FK_RESOURCE_ID >", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("FK_RESOURCE_ID >=", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdLessThan(String value) {
            addCriterion("FK_RESOURCE_ID <", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdLessThanOrEqualTo(String value) {
            addCriterion("FK_RESOURCE_ID <=", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdLike(String value) {
            addCriterion("FK_RESOURCE_ID like", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdNotLike(String value) {
            addCriterion("FK_RESOURCE_ID not like", value, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdIn(List<String> values) {
            addCriterion("FK_RESOURCE_ID in", values, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdNotIn(List<String> values) {
            addCriterion("FK_RESOURCE_ID not in", values, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdBetween(String value1, String value2) {
            addCriterion("FK_RESOURCE_ID between", value1, value2, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdNotBetween(String value1, String value2) {
            addCriterion("FK_RESOURCE_ID not between", value1, value2, "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdIsNull() {
            addCriterion("FK_GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdIsNotNull() {
            addCriterion("FK_GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdEqualTo(String value) {
            addCriterion("FK_GROUP_ID =", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdNotEqualTo(String value) {
            addCriterion("FK_GROUP_ID <>", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdGreaterThan(String value) {
            addCriterion("FK_GROUP_ID >", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("FK_GROUP_ID >=", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdLessThan(String value) {
            addCriterion("FK_GROUP_ID <", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdLessThanOrEqualTo(String value) {
            addCriterion("FK_GROUP_ID <=", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdLike(String value) {
            addCriterion("FK_GROUP_ID like", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdNotLike(String value) {
            addCriterion("FK_GROUP_ID not like", value, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdIn(List<String> values) {
            addCriterion("FK_GROUP_ID in", values, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdNotIn(List<String> values) {
            addCriterion("FK_GROUP_ID not in", values, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdBetween(String value1, String value2) {
            addCriterion("FK_GROUP_ID between", value1, value2, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdNotBetween(String value1, String value2) {
            addCriterion("FK_GROUP_ID not between", value1, value2, "fkGroupId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andFkResourceIdLikeInsensitive(String value) {
            addCriterion("upper(FK_RESOURCE_ID) like", value.toUpperCase(), "fkResourceId");
            return (Criteria) this;
        }

        public Criteria andFkGroupIdLikeInsensitive(String value) {
            addCriterion("upper(FK_GROUP_ID) like", value.toUpperCase(), "fkGroupId");
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