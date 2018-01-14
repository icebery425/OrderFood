package com.worldunion.prophesy.model.base;

import com.worldunion.prophesy.generator.page.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OrganizationExample() {
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

        public Criteria andOrganizationidIsNull() {
            addCriterion("ORGANIZATIONID is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIsNotNull() {
            addCriterion("ORGANIZATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidEqualTo(Long value) {
            addCriterion("ORGANIZATIONID =", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotEqualTo(Long value) {
            addCriterion("ORGANIZATIONID <>", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThan(Long value) {
            addCriterion("ORGANIZATIONID >", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThanOrEqualTo(Long value) {
            addCriterion("ORGANIZATIONID >=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThan(Long value) {
            addCriterion("ORGANIZATIONID <", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThanOrEqualTo(Long value) {
            addCriterion("ORGANIZATIONID <=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIn(List<Long> values) {
            addCriterion("ORGANIZATIONID in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotIn(List<Long> values) {
            addCriterion("ORGANIZATIONID not in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidBetween(Long value1, Long value2) {
            addCriterion("ORGANIZATIONID between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotBetween(Long value1, Long value2) {
            addCriterion("ORGANIZATIONID not between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIsNull() {
            addCriterion("ORGANIZATIONCODE is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIsNotNull() {
            addCriterion("ORGANIZATIONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE =", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE <>", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeGreaterThan(String value) {
            addCriterion("ORGANIZATIONCODE >", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE >=", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLessThan(String value) {
            addCriterion("ORGANIZATIONCODE <", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE <=", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLike(String value) {
            addCriterion("ORGANIZATIONCODE like", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotLike(String value) {
            addCriterion("ORGANIZATIONCODE not like", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIn(List<String> values) {
            addCriterion("ORGANIZATIONCODE in", values, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotIn(List<String> values) {
            addCriterion("ORGANIZATIONCODE not in", values, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONCODE between", value1, value2, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONCODE not between", value1, value2, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIsNull() {
            addCriterion("ORGANIZATIONNAME is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIsNotNull() {
            addCriterion("ORGANIZATIONNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameEqualTo(String value) {
            addCriterion("ORGANIZATIONNAME =", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotEqualTo(String value) {
            addCriterion("ORGANIZATIONNAME <>", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameGreaterThan(String value) {
            addCriterion("ORGANIZATIONNAME >", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONNAME >=", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLessThan(String value) {
            addCriterion("ORGANIZATIONNAME <", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONNAME <=", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLike(String value) {
            addCriterion("ORGANIZATIONNAME like", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotLike(String value) {
            addCriterion("ORGANIZATIONNAME not like", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIn(List<String> values) {
            addCriterion("ORGANIZATIONNAME in", values, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotIn(List<String> values) {
            addCriterion("ORGANIZATIONNAME not in", values, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONNAME between", value1, value2, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONNAME not between", value1, value2, "organizationname");
            return (Criteria) this;
        }

        public Criteria andParentorgidIsNull() {
            addCriterion("PARENTORGID is null");
            return (Criteria) this;
        }

        public Criteria andParentorgidIsNotNull() {
            addCriterion("PARENTORGID is not null");
            return (Criteria) this;
        }

        public Criteria andParentorgidEqualTo(Long value) {
            addCriterion("PARENTORGID =", value, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidNotEqualTo(Long value) {
            addCriterion("PARENTORGID <>", value, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidGreaterThan(Long value) {
            addCriterion("PARENTORGID >", value, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENTORGID >=", value, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidLessThan(Long value) {
            addCriterion("PARENTORGID <", value, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidLessThanOrEqualTo(Long value) {
            addCriterion("PARENTORGID <=", value, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidIn(List<Long> values) {
            addCriterion("PARENTORGID in", values, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidNotIn(List<Long> values) {
            addCriterion("PARENTORGID not in", values, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidBetween(Long value1, Long value2) {
            addCriterion("PARENTORGID between", value1, value2, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andParentorgidNotBetween(Long value1, Long value2) {
            addCriterion("PARENTORGID not between", value1, value2, "parentorgid");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIsNull() {
            addCriterion("ORGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIsNotNull() {
            addCriterion("ORGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgtypeEqualTo(String value) {
            addCriterion("ORGTYPE =", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotEqualTo(String value) {
            addCriterion("ORGTYPE <>", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeGreaterThan(String value) {
            addCriterion("ORGTYPE >", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGTYPE >=", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLessThan(String value) {
            addCriterion("ORGTYPE <", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLessThanOrEqualTo(String value) {
            addCriterion("ORGTYPE <=", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLike(String value) {
            addCriterion("ORGTYPE like", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotLike(String value) {
            addCriterion("ORGTYPE not like", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIn(List<String> values) {
            addCriterion("ORGTYPE in", values, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotIn(List<String> values) {
            addCriterion("ORGTYPE not in", values, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeBetween(String value1, String value2) {
            addCriterion("ORGTYPE between", value1, value2, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotBetween(String value1, String value2) {
            addCriterion("ORGTYPE not between", value1, value2, "orgtype");
            return (Criteria) this;
        }

        public Criteria andFinadeptidIsNull() {
            addCriterion("FINADEPTID is null");
            return (Criteria) this;
        }

        public Criteria andFinadeptidIsNotNull() {
            addCriterion("FINADEPTID is not null");
            return (Criteria) this;
        }

        public Criteria andFinadeptidEqualTo(Long value) {
            addCriterion("FINADEPTID =", value, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidNotEqualTo(Long value) {
            addCriterion("FINADEPTID <>", value, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidGreaterThan(Long value) {
            addCriterion("FINADEPTID >", value, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidGreaterThanOrEqualTo(Long value) {
            addCriterion("FINADEPTID >=", value, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidLessThan(Long value) {
            addCriterion("FINADEPTID <", value, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidLessThanOrEqualTo(Long value) {
            addCriterion("FINADEPTID <=", value, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidIn(List<Long> values) {
            addCriterion("FINADEPTID in", values, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidNotIn(List<Long> values) {
            addCriterion("FINADEPTID not in", values, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidBetween(Long value1, Long value2) {
            addCriterion("FINADEPTID between", value1, value2, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andFinadeptidNotBetween(Long value1, Long value2) {
            addCriterion("FINADEPTID not between", value1, value2, "finadeptid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("COMPANYID is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("COMPANYID is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Long value) {
            addCriterion("COMPANYID =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Long value) {
            addCriterion("COMPANYID <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Long value) {
            addCriterion("COMPANYID >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Long value) {
            addCriterion("COMPANYID >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Long value) {
            addCriterion("COMPANYID <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Long value) {
            addCriterion("COMPANYID <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Long> values) {
            addCriterion("COMPANYID in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Long> values) {
            addCriterion("COMPANYID not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Long value1, Long value2) {
            addCriterion("COMPANYID between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Long value1, Long value2) {
            addCriterion("COMPANYID not between", value1, value2, "companyid");
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

        public Criteria andOrglevelIsNull() {
            addCriterion("ORGLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andOrglevelIsNotNull() {
            addCriterion("ORGLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andOrglevelEqualTo(Short value) {
            addCriterion("ORGLEVEL =", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelNotEqualTo(Short value) {
            addCriterion("ORGLEVEL <>", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelGreaterThan(Short value) {
            addCriterion("ORGLEVEL >", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelGreaterThanOrEqualTo(Short value) {
            addCriterion("ORGLEVEL >=", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelLessThan(Short value) {
            addCriterion("ORGLEVEL <", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelLessThanOrEqualTo(Short value) {
            addCriterion("ORGLEVEL <=", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelIn(List<Short> values) {
            addCriterion("ORGLEVEL in", values, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelNotIn(List<Short> values) {
            addCriterion("ORGLEVEL not in", values, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelBetween(Short value1, Short value2) {
            addCriterion("ORGLEVEL between", value1, value2, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelNotBetween(Short value1, Short value2) {
            addCriterion("ORGLEVEL not between", value1, value2, "orglevel");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidIsNull() {
            addCriterion("SRCORGANIZATIONID is null");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidIsNotNull() {
            addCriterion("SRCORGANIZATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidEqualTo(Long value) {
            addCriterion("SRCORGANIZATIONID =", value, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidNotEqualTo(Long value) {
            addCriterion("SRCORGANIZATIONID <>", value, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidGreaterThan(Long value) {
            addCriterion("SRCORGANIZATIONID >", value, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidGreaterThanOrEqualTo(Long value) {
            addCriterion("SRCORGANIZATIONID >=", value, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidLessThan(Long value) {
            addCriterion("SRCORGANIZATIONID <", value, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidLessThanOrEqualTo(Long value) {
            addCriterion("SRCORGANIZATIONID <=", value, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidIn(List<Long> values) {
            addCriterion("SRCORGANIZATIONID in", values, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidNotIn(List<Long> values) {
            addCriterion("SRCORGANIZATIONID not in", values, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidBetween(Long value1, Long value2) {
            addCriterion("SRCORGANIZATIONID between", value1, value2, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andSrcorganizationidNotBetween(Long value1, Long value2) {
            addCriterion("SRCORGANIZATIONID not between", value1, value2, "srcorganizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLikeInsensitive(String value) {
            addCriterion("upper(ORGANIZATIONCODE) like", value.toUpperCase(), "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLikeInsensitive(String value) {
            addCriterion("upper(ORGANIZATIONNAME) like", value.toUpperCase(), "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLikeInsensitive(String value) {
            addCriterion("upper(ORGTYPE) like", value.toUpperCase(), "orgtype");
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