import java.util.ArrayList;

//メイン画面の表示メソッド
public class Main {

//    Subscription_tableクラスのインスタンスを生成して配列に格納
    public static void main(String[]args){

        int totalMonth =0;
        int totalYear  =0;

//        仮データのインスタンス生成
        SubscriptionData amazonPrime    = new SubscriptionData(1,"amazonPrime", 1, 6000);
        SubscriptionData itune          = new SubscriptionData(2,"itune", 2, 1000);
        SubscriptionData youtubePremium = new SubscriptionData(3, "youtubePremium", 2, 1900);

//        listの作成
        ArrayList<SubscriptionData> sbscList = new ArrayList<>();

//        listに追加
        sbscList.add(amazonPrime);
        sbscList.add(itune);
        sbscList.add(youtubePremium);

        subscription_table_first_row.table_first_row();
//        ループで回して実行
        for (SubscriptionData subscriptionData : sbscList) {
            System.out.println(subscriptionData.getRow());
        }

//        月の合計値を算出
        for (SubscriptionData subscriptionData : sbscList) {
            totalMonth = totalMonth + subscriptionData.getMonthlyPrice();
        }
        System.out.println("月の合計金額は" + totalMonth + "です。");

//        年の合計額を算出
        for (SubscriptionData subscriptionData : sbscList) {
            totalYear = totalYear + subscriptionData.getYearlyPrice();
        }
        System.out.println("年の合計金額は" + totalYear + "です。");
    }
}
