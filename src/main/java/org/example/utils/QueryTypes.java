package org.example.utils;

public enum QueryTypes{
    INSERT("INSERT INTO test_table VALUES(?,?)"),
    DELETE("DELETE FROM test_table where name = ?"),
    SELECT("SELECT * FROM test_table"),
    SELECT_NAME_FROM_TEST_TABLE("SELECT name FROM test_table WHERE id = ?"),
    SELECT_ID_FROM_TEST_TABLE("SELECT id FROM test_table WHERE name = ?"),
    UPDATE("UPDATE test_table set name = ? where id = ?");

    private final String query;

    QueryTypes(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
