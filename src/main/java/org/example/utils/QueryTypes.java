package org.example.utils;

public enum QueryTypes {
    INSERT("INSERT INTO test_table VALUES(?,?)"),
    DELETE("DELETE FROM test_table where name = ?"),
    SELECT("SELECT * FROM test_table"),
    UPDATE("UPDATE test_table set name = ? where id = ?");

    private final String query;

    QueryTypes(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}