package com.example.android.inventoryappstage1.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class StockContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private StockContract() {
    }

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryappstage1";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.inventoryappstage1/items/ is a valid path for
     * looking at item data. content://com.example.android.inventoryappstage1/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_ITEM = "items";

    /**
     * Inner class that defines constant values for the items database table.
     * Each entry in the table represents a single item.
     */
    public static final class ItemEntry implements BaseColumns {

        /**
         * The content URI to access the item data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ITEM);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of items.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEM;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single item.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEM;

        /**
         * Name of database table for items
         */
        public static final String TABLE_NAME = "items";

        /**
         * Unique ID number for the item (only for use in the database table).
         * Type: INTEGER
         */
        public static final String _ID = BaseColumns._ID;


        /**
         * CATEGORY of the items
         * Type: TEXT
         */
        public static final String COLUMN_ITEM_CATEGORY = "category";

        /**
         * Name of the items
         * Type: TEXT
         */
        public static final String COLUMN_ITEM_NAME = "name";

        /**
         * Price of the item.
         * Type: TEXT
         */
        public static final String COLUMN_ITEM_PRICE = "price";

        /**
         * Quantity of the item.
         * Type: TEXT
         */
        public static final String COLUMN_ITEM_QUANTITY = "quantity";

        /**
         * Supplier Name of the item.
         * Type: TEXT
         */
        public static final String COLUMN_ITEM_SUPPLIER_NAME = "supplierName";

        /**
         * Supplier number  of the item.
         * Type: TEXT
         */
        public static final String COLUMN_ITEM_SUPPLIER_PHONE_NUMBER = "supplierPhoneNumber";

        /**
         * Possible values for the category of the item.
         */
        public static final int ITEM_UNKNOWN = 0;
        public static final int ITEM_CAMERA = 1;
        public static final int ITEM_PHONE = 2;
        public static final int ITEM_HEADPHONES = 3;
        public static final int ITEM_COMPUTERS = 4;


        /**
         * Returns whether or not the given category is {@link #ITEM_UNKNOWN}, {@link #ITEM_CAMERA},
         * or {@link #ITEM_PHONE} or {@link #ITEM_HEADPHONES} or {@link #ITEM_COMPUTERS}
         * or {@link}.
         */
        public static boolean isValidCategory(int item) {
            if (item == ITEM_UNKNOWN || item == ITEM_CAMERA || item == ITEM_PHONE ||
                    item == ITEM_HEADPHONES || item == ITEM_COMPUTERS) {
                return true;
            }
            return false;
        }

    }
}