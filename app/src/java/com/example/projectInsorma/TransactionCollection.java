package com.example.projectinsorma_maevymarvella;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TransactionCollection {

    public static ArrayList transaction = new ArrayList<Transactions>();

    public static ArrayList<Transactions> getList(){
        return transaction;
    }

    public static String getDateNow(){
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date now = new Date();
        return df.format(now);
    }

//    public static void generateDummyTransaction(){
//        transaction.add(new Transactions(0, 1, 1, "2020/12/12 01:02:02", "10"));
//        transaction.add(new Transactions(1, 2, 2, "2020/12/13 01:02:05", "2"));
//        transaction.add(new Transactions(0, 3,3,  "2020/12/13 01:02:07", "1"));
//        transaction.add(new Transactions(3, 4, 4, "2020/12/13 01:02:10", "3"));
//        transaction.add(new Transactions(1, 4, 5, "2020/12/13 01:02:10", "3"));
//    }


}
