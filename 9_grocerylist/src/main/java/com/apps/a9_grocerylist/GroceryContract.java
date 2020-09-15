package com.apps.a9_grocerylist;

import android.provider.BaseColumns;

// Defines string constants to hold table name and column
public class GroceryContract {
    private GroceryContract() {
    }

    public static final class GroceryEntry implements BaseColumns {
        public static final String TABLE_NAME = "groceryList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
