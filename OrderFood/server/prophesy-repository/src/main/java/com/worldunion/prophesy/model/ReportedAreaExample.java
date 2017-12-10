package com.worldunion.prophesy.model;

import com.worldunion.prophesy.generator.page.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReportedAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public ReportedAreaExample() {
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

        public Criteria andReportedareaidIsNull() {
            addCriterion("REPORTEDAREAID is null");
            return (Criteria) this;
        }

        public Criteria andReportedareaidIsNotNull() {
            addCriterion("REPORTEDAREAID is not null");
            return (Criteria) this;
        }

        public Criteria andReportedareaidEqualTo(Long value) {
            addCriterion("REPORTEDAREAID =", value, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidNotEqualTo(Long value) {
            addCriterion("REPORTEDAREAID <>", value, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidGreaterThan(Long value) {
            addCriterion("REPORTEDAREAID >", value, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidGreaterThanOrEqualTo(Long value) {
            addCriterion("REPORTEDAREAID >=", value, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidLessThan(Long value) {
            addCriterion("REPORTEDAREAID <", value, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidLessThanOrEqualTo(Long value) {
            addCriterion("REPORTEDAREAID <=", value, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidIn(List<Long> values) {
            addCriterion("REPORTEDAREAID in", values, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidNotIn(List<Long> values) {
            addCriterion("REPORTEDAREAID not in", values, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidBetween(Long value1, Long value2) {
            addCriterion("REPORTEDAREAID between", value1, value2, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareaidNotBetween(Long value1, Long value2) {
            addCriterion("REPORTEDAREAID not between", value1, value2, "reportedareaid");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeIsNull() {
            addCriterion("REPORTEDAREACODE is null");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeIsNotNull() {
            addCriterion("REPORTEDAREACODE is not null");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeEqualTo(String value) {
            addCriterion("REPORTEDAREACODE =", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeNotEqualTo(String value) {
            addCriterion("REPORTEDAREACODE <>", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeGreaterThan(String value) {
            addCriterion("REPORTEDAREACODE >", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeGreaterThanOrEqualTo(String value) {
            addCriterion("REPORTEDAREACODE >=", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeLessThan(String value) {
            addCriterion("REPORTEDAREACODE <", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeLessThanOrEqualTo(String value) {
            addCriterion("REPORTEDAREACODE <=", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeLike(String value) {
            addCriterion("REPORTEDAREACODE like", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeNotLike(String value) {
            addCriterion("REPORTEDAREACODE not like", value, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeIn(List<String> values) {
            addCriterion("REPORTEDAREACODE in", values, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeNotIn(List<String> values) {
            addCriterion("REPORTEDAREACODE not in", values, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeBetween(String value1, String value2) {
            addCriterion("REPORTEDAREACODE between", value1, value2, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeNotBetween(String value1, String value2) {
            addCriterion("REPORTEDAREACODE not between", value1, value2, "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareanameIsNull() {
            addCriterion("REPORTEDAREANAME is null");
            return (Criteria) this;
        }

        public Criteria andReportedareanameIsNotNull() {
            addCriterion("REPORTEDAREANAME is not null");
            return (Criteria) this;
        }

        public Criteria andReportedareanameEqualTo(String value) {
            addCriterion("REPORTEDAREANAME =", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameNotEqualTo(String value) {
            addCriterion("REPORTEDAREANAME <>", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameGreaterThan(String value) {
            addCriterion("REPORTEDAREANAME >", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameGreaterThanOrEqualTo(String value) {
            addCriterion("REPORTEDAREANAME >=", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameLessThan(String value) {
            addCriterion("REPORTEDAREANAME <", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameLessThanOrEqualTo(String value) {
            addCriterion("REPORTEDAREANAME <=", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameLike(String value) {
            addCriterion("REPORTEDAREANAME like", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameNotLike(String value) {
            addCriterion("REPORTEDAREANAME not like", value, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameIn(List<String> values) {
            addCriterion("REPORTEDAREANAME in", values, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameNotIn(List<String> values) {
            addCriterion("REPORTEDAREANAME not in", values, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameBetween(String value1, String value2) {
            addCriterion("REPORTEDAREANAME between", value1, value2, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andReportedareanameNotBetween(String value1, String value2) {
            addCriterion("REPORTEDAREANAME not between", value1, value2, "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("ADDTIME is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("ADDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ADDTIME =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ADDTIME <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ADDTIME >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ADDTIME >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterionForJDBCDate("ADDTIME <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ADDTIME <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ADDTIME in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ADDTIME not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ADDTIME between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ADDTIME not between", value1, value2, "addtime");
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

        public Criteria andCheckidIsNull() {
            addCriterion("CHECKID is null");
            return (Criteria) this;
        }

        public Criteria andCheckidIsNotNull() {
            addCriterion("CHECKID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckidEqualTo(Long value) {
            addCriterion("CHECKID =", value, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidNotEqualTo(Long value) {
            addCriterion("CHECKID <>", value, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidGreaterThan(Long value) {
            addCriterion("CHECKID >", value, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidGreaterThanOrEqualTo(Long value) {
            addCriterion("CHECKID >=", value, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidLessThan(Long value) {
            addCriterion("CHECKID <", value, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidLessThanOrEqualTo(Long value) {
            addCriterion("CHECKID <=", value, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidIn(List<Long> values) {
            addCriterion("CHECKID in", values, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidNotIn(List<Long> values) {
            addCriterion("CHECKID not in", values, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidBetween(Long value1, Long value2) {
            addCriterion("CHECKID between", value1, value2, "checkid");
            return (Criteria) this;
        }

        public Criteria andCheckidNotBetween(Long value1, Long value2) {
            addCriterion("CHECKID not between", value1, value2, "checkid");
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

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSortnumIsNull() {
            addCriterion("SORTNUM is null");
            return (Criteria) this;
        }

        public Criteria andSortnumIsNotNull() {
            addCriterion("SORTNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSortnumEqualTo(Long value) {
            addCriterion("SORTNUM =", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumNotEqualTo(Long value) {
            addCriterion("SORTNUM <>", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumGreaterThan(Long value) {
            addCriterion("SORTNUM >", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumGreaterThanOrEqualTo(Long value) {
            addCriterion("SORTNUM >=", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumLessThan(Long value) {
            addCriterion("SORTNUM <", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumLessThanOrEqualTo(Long value) {
            addCriterion("SORTNUM <=", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumIn(List<Long> values) {
            addCriterion("SORTNUM in", values, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumNotIn(List<Long> values) {
            addCriterion("SORTNUM not in", values, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumBetween(Long value1, Long value2) {
            addCriterion("SORTNUM between", value1, value2, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumNotBetween(Long value1, Long value2) {
            addCriterion("SORTNUM not between", value1, value2, "sortnum");
            return (Criteria) this;
        }

        public Criteria andReportedareacodeLikeInsensitive(String value) {
            addCriterion("upper(REPORTEDAREACODE) like", value.toUpperCase(), "reportedareacode");
            return (Criteria) this;
        }

        public Criteria andReportedareanameLikeInsensitive(String value) {
            addCriterion("upper(REPORTEDAREANAME) like", value.toUpperCase(), "reportedareaname");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(STATUS) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
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