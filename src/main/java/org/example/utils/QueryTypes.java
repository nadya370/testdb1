package org.example.utils;

public enum QueryTypes{
    INSERT("INSERT INTO {0} VALUES(?,?)"),
    DELETE("DELETE FROM {0} where {1} = ?"),
    SELECT("SELECT {0} FROM {1}"),
    SELECT_FROM("SELECT {0} FROM {1} WHERE {2} = ?"),
    UPDATE("UPDATE {0} set {1} = ? where {2} = ?");

    private final String query;

    QueryTypes(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
