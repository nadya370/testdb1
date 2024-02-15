package org.example.utils;

public enum QueryTypes{
    INSERT("INSERT INTO test_table VALUES(?,?)"),
    DELETE("DELETE FROM test_table where name = ?"),
    SELECT("SELECT * FROM test_table"),
    SELECT_FROM_TEST_TABLE(""),
    UPDATE("UPDATE test_table set name = ? where id = ?");

    private String query;

    QueryTypes(String query) {
        this.query = query;
    }

    public void setQuery(String studentInfo) {
        this.query = studentInfo;
    }

    public String getQuery() {
        return query;
    }

}
