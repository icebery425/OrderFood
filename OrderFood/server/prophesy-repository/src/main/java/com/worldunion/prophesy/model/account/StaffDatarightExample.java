package com.worldunion.prophesy.model.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StaffDatarightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffDatarightExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStaffdatarightidIsNull() {
            addCriterion("STAFFDATARIGHTID is null");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidIsNotNull() {
            addCriterion("STAFFDATARIGHTID is not null");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidEqualTo(Integer value) {
            addCriterion("STAFFDATARIGHTID =", value, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidNotEqualTo(Integer value) {
            addCriterion("STAFFDATARIGHTID <>", value, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidGreaterThan(Integer value) {
            addCriterion("STAFFDATARIGHTID >", value, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidGreaterThanOrEqualTo(Integer value) {
            addCriterion("STAFFDATARIGHTID >=", value, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidLessThan(Integer value) {
            addCriterion("STAFFDATARIGHTID <", value, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidLessThanOrEqualTo(Integer value) {
            addCriterion("STAFFDATARIGHTID <=", value, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidIn(List<Integer> values) {
            addCriterion("STAFFDATARIGHTID in", values, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidNotIn(List<Integer> values) {
            addCriterion("STAFFDATARIGHTID not in", values, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidBetween(Integer value1, Integer value2) {
            addCriterion("STAFFDATARIGHTID between", value1, value2, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffdatarightidNotBetween(Integer value1, Integer value2) {
            addCriterion("STAFFDATARIGHTID not between", value1, value2, "staffdatarightid");
            return (Criteria) this;
        }

        public Criteria andStaffidIsNull() {
            addCriterion("STAFFID is null");
            return (Criteria) this;
        }

        public Criteria andStaffidIsNotNull() {
            addCriterion("STAFFID is not null");
            return (Criteria) this;
        }

        public Criteria andStaffidEqualTo(Integer value) {
            addCriterion("STAFFID =", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidNotEqualTo(Integer value) {
            addCriterion("STAFFID <>", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidGreaterThan(Integer value) {
            addCriterion("STAFFID >", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidGreaterThanOrEqualTo(Integer value) {
            addCriterion("STAFFID >=", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidLessThan(Integer value) {
            addCriterion("STAFFID <", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidLessThanOrEqualTo(Integer value) {
            addCriterion("STAFFID <=", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidIn(List<Integer> values) {
            addCriterion("STAFFID in", values, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidNotIn(List<Integer> values) {
            addCriterion("STAFFID not in", values, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidBetween(Integer value1, Integer value2) {
            addCriterion("STAFFID between", value1, value2, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidNotBetween(Integer value1, Integer value2) {
            addCriterion("STAFFID not between", value1, value2, "staffid");
            return (Criteria) this;
        }

        public Criteria andDataidIsNull() {
            addCriterion("DATAID is null");
            return (Criteria) this;
        }

        public Criteria andDataidIsNotNull() {
            addCriterion("DATAID is not null");
            return (Criteria) this;
        }

        public Criteria andDataidEqualTo(Integer value) {
            addCriterion("DATAID =", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotEqualTo(Integer value) {
            addCriterion("DATAID <>", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidGreaterThan(Integer value) {
            addCriterion("DATAID >", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATAID >=", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidLessThan(Integer value) {
            addCriterion("DATAID <", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidLessThanOrEqualTo(Integer value) {
            addCriterion("DATAID <=", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidIn(List<Integer> values) {
            addCriterion("DATAID in", values, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotIn(List<Integer> values) {
            addCriterion("DATAID not in", values, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidBetween(Integer value1, Integer value2) {
            addCriterion("DATAID between", value1, value2, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotBetween(Integer value1, Integer value2) {
            addCriterion("DATAID not between", value1, value2, "dataid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidIsNull() {
            addCriterion("DATARIGHTTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidIsNotNull() {
            addCriterion("DATARIGHTTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidEqualTo(Integer value) {
            addCriterion("DATARIGHTTYPEID =", value, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidNotEqualTo(Integer value) {
            addCriterion("DATARIGHTTYPEID <>", value, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidGreaterThan(Integer value) {
            addCriterion("DATARIGHTTYPEID >", value, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATARIGHTTYPEID >=", value, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidLessThan(Integer value) {
            addCriterion("DATARIGHTTYPEID <", value, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidLessThanOrEqualTo(Integer value) {
            addCriterion("DATARIGHTTYPEID <=", value, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidIn(List<Integer> values) {
            addCriterion("DATARIGHTTYPEID in", values, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidNotIn(List<Integer> values) {
            addCriterion("DATARIGHTTYPEID not in", values, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidBetween(Integer value1, Integer value2) {
            addCriterion("DATARIGHTTYPEID between", value1, value2, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarighttypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("DATARIGHTTYPEID not between", value1, value2, "datarighttypeid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidIsNull() {
            addCriterion("DATARIGHTDIMID is null");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidIsNotNull() {
            addCriterion("DATARIGHTDIMID is not null");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidEqualTo(Integer value) {
            addCriterion("DATARIGHTDIMID =", value, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidNotEqualTo(Integer value) {
            addCriterion("DATARIGHTDIMID <>", value, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidGreaterThan(Integer value) {
            addCriterion("DATARIGHTDIMID >", value, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATARIGHTDIMID >=", value, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidLessThan(Integer value) {
            addCriterion("DATARIGHTDIMID <", value, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidLessThanOrEqualTo(Integer value) {
            addCriterion("DATARIGHTDIMID <=", value, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidIn(List<Integer> values) {
            addCriterion("DATARIGHTDIMID in", values, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidNotIn(List<Integer> values) {
            addCriterion("DATARIGHTDIMID not in", values, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidBetween(Integer value1, Integer value2) {
            addCriterion("DATARIGHTDIMID between", value1, value2, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andDatarightdimidNotBetween(Integer value1, Integer value2) {
            addCriterion("DATARIGHTDIMID not between", value1, value2, "datarightdimid");
            return (Criteria) this;
        }

        public Criteria andEntertimeIsNull() {
            addCriterion("ENTERTIME is null");
            return (Criteria) this;
        }

        public Criteria andEntertimeIsNotNull() {
            addCriterion("ENTERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEntertimeEqualTo(Date value) {
            addCriterionForJDBCDate("ENTERTIME =", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ENTERTIME <>", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ENTERTIME >", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENTERTIME >=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThan(Date value) {
            addCriterionForJDBCDate("ENTERTIME <", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENTERTIME <=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeIn(List<Date> values) {
            addCriterionForJDBCDate("ENTERTIME in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ENTERTIME not in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENTERTIME between", value1, value2, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENTERTIME not between", value1, value2, "entertime");
            return (Criteria) this;
        }

        public Criteria andChecktimeIsNull() {
            addCriterion("CHECKTIME is null");
            return (Criteria) this;
        }

        public Criteria andChecktimeIsNotNull() {
            addCriterion("CHECKTIME is not null");
            return (Criteria) this;
        }

        public Criteria andChecktimeEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME =", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME <>", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CHECKTIME >", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME >=", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeLessThan(Date value) {
            addCriterionForJDBCDate("CHECKTIME <", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME <=", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeIn(List<Date> values) {
            addCriterionForJDBCDate("CHECKTIME in", values, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CHECKTIME not in", values, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHECKTIME between", value1, value2, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHECKTIME not between", value1, value2, "checktime");
            return (Criteria) this;
        }

        public Criteria andAltertimeIsNull() {
            addCriterion("ALTERTIME is null");
            return (Criteria) this;
        }

        public Criteria andAltertimeIsNotNull() {
            addCriterion("ALTERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAltertimeEqualTo(Date value) {
            addCriterionForJDBCDate("ALTERTIME =", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ALTERTIME <>", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ALTERTIME >", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ALTERTIME >=", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeLessThan(Date value) {
            addCriterionForJDBCDate("ALTERTIME <", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ALTERTIME <=", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeIn(List<Date> values) {
            addCriterionForJDBCDate("ALTERTIME in", values, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ALTERTIME not in", values, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ALTERTIME between", value1, value2, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ALTERTIME not between", value1, value2, "altertime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEnteridIsNull() {
            addCriterion("ENTERID is null");
            return (Criteria) this;
        }

        public Criteria andEnteridIsNotNull() {
            addCriterion("ENTERID is not null");
            return (Criteria) this;
        }

        public Criteria andEnteridEqualTo(Long value) {
            addCriterion("ENTERID =", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridNotEqualTo(Long value) {
            addCriterion("ENTERID <>", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridGreaterThan(Long value) {
            addCriterion("ENTERID >", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridGreaterThanOrEqualTo(Long value) {
            addCriterion("ENTERID >=", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridLessThan(Long value) {
            addCriterion("ENTERID <", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridLessThanOrEqualTo(Long value) {
            addCriterion("ENTERID <=", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridIn(List<Long> values) {
            addCriterion("ENTERID in", values, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridNotIn(List<Long> values) {
            addCriterion("ENTERID not in", values, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridBetween(Long value1, Long value2) {
            addCriterion("ENTERID between", value1, value2, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridNotBetween(Long value1, Long value2) {
            addCriterion("ENTERID not between", value1, value2, "enterid");
            return (Criteria) this;
        }

        public Criteria andAlteridIsNull() {
            addCriterion("ALTERID is null");
            return (Criteria) this;
        }

        public Criteria andAlteridIsNotNull() {
            addCriterion("ALTERID is not null");
            return (Criteria) this;
        }

        public Criteria andAlteridEqualTo(Long value) {
            addCriterion("ALTERID =", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridNotEqualTo(Long value) {
            addCriterion("ALTERID <>", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridGreaterThan(Long value) {
            addCriterion("ALTERID >", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridGreaterThanOrEqualTo(Long value) {
            addCriterion("ALTERID >=", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridLessThan(Long value) {
            addCriterion("ALTERID <", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridLessThanOrEqualTo(Long value) {
            addCriterion("ALTERID <=", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridIn(List<Long> values) {
            addCriterion("ALTERID in", values, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridNotIn(List<Long> values) {
            addCriterion("ALTERID not in", values, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridBetween(Long value1, Long value2) {
            addCriterion("ALTERID between", value1, value2, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridNotBetween(Long value1, Long value2) {
            addCriterion("ALTERID not between", value1, value2, "alterid");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(STATUS) like", value.toUpperCase(), "status");
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