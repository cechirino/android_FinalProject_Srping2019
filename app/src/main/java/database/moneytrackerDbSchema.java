package database;

public class moneytrackerDbSchema {

    public static final class budgetTable{
        public static final String Name = "budgets";

        public static final class Cols{
            public static final  String budgetID = "budgetID";
            public static final String budgetName = "budgetName";
            public static final String goal = "goal";
            public static final String amountBudget = "goalBudget";
        }
    }


    public static final class expemsesTabel{
        public static final String Name = "Expenses";

        public static final  class Cols{
            public static final String expensesID = "espenseID";
            public static final String expensesName = "expensesName";
            public static final String amountExpense = "amountExpense";
            public static final String dueDate = "dueDate";
        }
    }

    public static final class accountTable{
        public static final String Name = "Accounts";

        public static final class Cols{
            public static final String accountID = "accountID";
            public static final String accountName = "accountName";
            public static final String amountAccount = "amountAccount";
            public static final String type = "type";
        }
    }

}


