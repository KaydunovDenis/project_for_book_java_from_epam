package g6.g6_2;

public interface CorporateSubscriberAction extends MobileSubscriberAction {
    String getPhoneNumberInfo(int number);
    void createPhoneNumber();
    boolean deletePhoneNumber();
}
