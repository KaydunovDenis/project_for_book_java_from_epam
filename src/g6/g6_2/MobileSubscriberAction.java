package g6.g6_2;

public interface MobileSubscriberAction {
    void createContract();
    void createAccount();
    void editSubscriberInfo();
    String getSubscriberInfo();
    double checkBalance();
    String getPaymentDetails();
    boolean changeTariffPlan();
    boolean changeOperator();
    boolean replenishAccounts();
    boolean closeAccount();
}

