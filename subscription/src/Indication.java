/*
 *画面表示クラス
 */
public class Indication {

    static SubscriptionList list = new SubscriptionList();

    //    一覧表示画面
    public static void summaryOutput() {

        int totalMonth = 0;
        int totalYear = 0;


        if (SubscriptionList.list == null || SubscriptionList.list.isEmpty()) {
            InputCommand.inputSubscriptionData();
        }

        subscriptionFirstRow.FirstRow();


//        ループで回して実行
        for (SubscriptionData subscriptionData : list.getSubscriptionList()) {
            System.out.println(subscriptionData.getRow());
        }

//        月の合計値を算出
        for (SubscriptionData subscriptionData : list.getSubscriptionList()) {
            totalMonth = totalMonth + subscriptionData.getMonthlyPrice();
        }
        System.out.println("月の合計金額は" + totalMonth + "です。");

//        年の合計額を算出
        for (SubscriptionData subscriptionData : list.getSubscriptionList()) {
            totalYear = totalYear + subscriptionData.getYearlyPrice();
        }
        System.out.println("年の合計金額は" + totalYear + "です。");

        InputCommand.summaryCommand();
    }

    //    詳細画面表示メソッド
    public static void detailOutput(int nextAction) {

        if (SubscriptionList.selectSubscriptionList(nextAction) == null) {
            System.out.println("条件に合致する要素は見つかりませんでした。");
            summaryOutput();
        }
        //1行目呼び出し
        subscriptionFirstRow.FirstRow();
        System.out.println(SubscriptionList.selectSubscriptionList(nextAction).getRow());
        InputCommand.deleteCommand(nextAction);
    }

    public static void registerOutput() {
        InputCommand.inputSubscriptionData();
        summaryOutput();
    }
}
