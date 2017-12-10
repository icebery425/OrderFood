package com.worldunion.prophesy.model;

import com.worldunion.prophesy.generator.page.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LogDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public LogDetailExample() {
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

        public Criteria andLogdetailidIsNull() {
            addCriterion("LOGDETAILID is null");
            return (Criteria) this;
        }

        public Criteria andLogdetailidIsNotNull() {
            addCriterion("LOGDETAILID is not null");
            return (Criteria) this;
        }

        public Criteria andLogdetailidEqualTo(Long value) {
            addCriterion("LOGDETAILID =", value, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidNotEqualTo(Long value) {
            addCriterion("LOGDETAILID <>", value, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidGreaterThan(Long value) {
            addCriterion("LOGDETAILID >", value, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidGreaterThanOrEqualTo(Long value) {
            addCriterion("LOGDETAILID >=", value, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidLessThan(Long value) {
            addCriterion("LOGDETAILID <", value, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidLessThanOrEqualTo(Long value) {
            addCriterion("LOGDETAILID <=", value, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidIn(List<Long> values) {
            addCriterion("LOGDETAILID in", values, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidNotIn(List<Long> values) {
            addCriterion("LOGDETAILID not in", values, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidBetween(Long value1, Long value2) {
            addCriterion("LOGDETAILID between", value1, value2, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogdetailidNotBetween(Long value1, Long value2) {
            addCriterion("LOGDETAILID not between", value1, value2, "logdetailid");
            return (Criteria) this;
        }

        public Criteria andLogidIsNull() {
            addCriterion("LOGID is null");
            return (Criteria) this;
        }

        public Criteria andLogidIsNotNull() {
            addCriterion("LOGID is not null");
            return (Criteria) this;
        }

        public Criteria andLogidEqualTo(Long value) {
            addCriterion("LOGID =", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotEqualTo(Long value) {
            addCriterion("LOGID <>", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThan(Long value) {
            addCriterion("LOGID >", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThanOrEqualTo(Long value) {
            addCriterion("LOGID >=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThan(Long value) {
            addCriterion("LOGID <", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThanOrEqualTo(Long value) {
            addCriterion("LOGID <=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidIn(List<Long> values) {
            addCriterion("LOGID in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotIn(List<Long> values) {
            addCriterion("LOGID not in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidBetween(Long value1, Long value2) {
            addCriterion("LOGID between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotBetween(Long value1, Long value2) {
            addCriterion("LOGID not between", value1, value2, "logid");
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

        public Criteria andTablenameIsNull() {
            addCriterion("TABLENAME is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("TABLENAME is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("TABLENAME =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("TABLENAME <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("TABLENAME >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLENAME >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("TABLENAME <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("TABLENAME <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("TABLENAME like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("TABLENAME not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("TABLENAME in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("TABLENAME not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("TABLENAME between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("TABLENAME not between", value1, value2, "tablename");
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

        public Criteria andDataidEqualTo(Long value) {
            addCriterion("DATAID =", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotEqualTo(Long value) {
            addCriterion("DATAID <>", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidGreaterThan(Long value) {
            addCriterion("DATAID >", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidGreaterThanOrEqualTo(Long value) {
            addCriterion("DATAID >=", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidLessThan(Long value) {
            addCriterion("DATAID <", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidLessThanOrEqualTo(Long value) {
            addCriterion("DATAID <=", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidIn(List<Long> values) {
            addCriterion("DATAID in", values, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotIn(List<Long> values) {
            addCriterion("DATAID not in", values, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidBetween(Long value1, Long value2) {
            addCriterion("DATAID between", value1, value2, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotBetween(Long value1, Long value2) {
            addCriterion("DATAID not between", value1, value2, "dataid");
            return (Criteria) this;
        }

        public Criteria andNowvalueIsNull() {
            addCriterion("NOWVALUE is null");
            return (Criteria) this;
        }

        public Criteria andNowvalueIsNotNull() {
            addCriterion("NOWVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andNowvalueEqualTo(String value) {
            addCriterion("NOWVALUE =", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueNotEqualTo(String value) {
            addCriterion("NOWVALUE <>", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueGreaterThan(String value) {
            addCriterion("NOWVALUE >", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueGreaterThanOrEqualTo(String value) {
            addCriterion("NOWVALUE >=", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueLessThan(String value) {
            addCriterion("NOWVALUE <", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueLessThanOrEqualTo(String value) {
            addCriterion("NOWVALUE <=", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueLike(String value) {
            addCriterion("NOWVALUE like", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueNotLike(String value) {
            addCriterion("NOWVALUE not like", value, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueIn(List<String> values) {
            addCriterion("NOWVALUE in", values, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueNotIn(List<String> values) {
            addCriterion("NOWVALUE not in", values, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueBetween(String value1, String value2) {
            addCriterion("NOWVALUE between", value1, value2, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andNowvalueNotBetween(String value1, String value2) {
            addCriterion("NOWVALUE not between", value1, value2, "nowvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueIsNull() {
            addCriterion("ORIGINALVALUE is null");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueIsNotNull() {
            addCriterion("ORIGINALVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueEqualTo(String value) {
            addCriterion("ORIGINALVALUE =", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueNotEqualTo(String value) {
            addCriterion("ORIGINALVALUE <>", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueGreaterThan(String value) {
            addCriterion("ORIGINALVALUE >", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINALVALUE >=", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueLessThan(String value) {
            addCriterion("ORIGINALVALUE <", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueLessThanOrEqualTo(String value) {
            addCriterion("ORIGINALVALUE <=", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueLike(String value) {
            addCriterion("ORIGINALVALUE like", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueNotLike(String value) {
            addCriterion("ORIGINALVALUE not like", value, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueIn(List<String> values) {
            addCriterion("ORIGINALVALUE in", values, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueNotIn(List<String> values) {
            addCriterion("ORIGINALVALUE not in", values, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueBetween(String value1, String value2) {
            addCriterion("ORIGINALVALUE between", value1, value2, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueNotBetween(String value1, String value2) {
            addCriterion("ORIGINALVALUE not between", value1, value2, "originalvalue");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andTablenameLikeInsensitive(String value) {
            addCriterion("upper(TABLENAME) like", value.toUpperCase(), "tablename");
            return (Criteria) this;
        }

        public Criteria andNowvalueLikeInsensitive(String value) {
            addCriterion("upper(NOWVALUE) like", value.toUpperCase(), "nowvalue");
            return (Criteria) this;
        }

        public Criteria andOriginalvalueLikeInsensitive(String value) {
            addCriterion("upper(ORIGINALVALUE) like", value.toUpperCase(), "originalvalue");
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