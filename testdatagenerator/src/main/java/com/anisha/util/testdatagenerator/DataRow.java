package com.anisha.util.testdatagenerator;

import java.util.List;

public class DataRow {
    List<String> columns;

    @java.beans.ConstructorProperties({"columns"})
    DataRow(final List<String> columns) {
        this.columns = columns;
    }

    public static DataRowBuilder builder() {
        return new DataRowBuilder();
    }

    public List<String> getColumns() {
        return this.columns;
    }

    public void setColumns(final List<String> columns) {
        this.columns = columns;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DataRow)) {
            return false;
        }
        final DataRow other = (DataRow) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        final Object this$columns = this.getColumns();
        final Object other$columns = other.getColumns();
        if (this$columns == null ? other$columns != null : !this$columns.equals(other$columns)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $columns = this.getColumns();
        result = result * PRIME + ($columns == null ? 43 : $columns.hashCode());
        return result;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DataRow;
    }

    @Override
    public String toString() {
        return "DataRow(columns=" + this.getColumns() + ")";
    }

    public static class DataRowBuilder {
        private List<String> columns;

        DataRowBuilder() {
        }

        public DataRow.DataRowBuilder columns(final List<String> columns) {
            this.columns = columns;
            return this;
        }

        public DataRow build() {
            return new DataRow(columns);
        }

        @Override
        public String toString() {
            return "DataRow.DataRowBuilder(columns=" + this.columns + ")";
        }
    }
}
