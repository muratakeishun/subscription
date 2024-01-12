import java.util.ArrayList;

public class SubscriptionList {

    static ArrayList<SubscriptionData> subscriptionList;

    public void listMake() {
        //        仮データのインスタンス生成
        SubscriptionData amazonPrime = new SubscriptionData(1, "amazonPrime", 1, 6000);
        SubscriptionData itune = new SubscriptionData(2, "itune", 2, 1000);
        SubscriptionData youtubePremium = new SubscriptionData(3, "youtubePremium", 2, 1900);

        //        listの作成
        subscriptionList = new ArrayList<>();

        //        listに追加
        subscriptionList.add(amazonPrime);
        subscriptionList.add(itune);
        subscriptionList.add(youtubePremium);
    }

    public ArrayList<SubscriptionData> getSubscriptionList() {

        return subscriptionList;
    }

    public void selectSubscriptionList(int i) {
        if (subscriptionList != null && i >= 0 && i < subscriptionList.size()) {
            SubscriptionData data = subscriptionList.get(i);
            System.out.println(data.getRow());
        } else {
            System.out.println("そのIDは存在しません。");
        }
    }

    public static void deleteSubscriptionList(int i) {

        subscriptionList.remove(i);

        Indication.summaryOutput();
    }
}
