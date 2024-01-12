public class Indication {

    static SubscriptionList list = new SubscriptionList();

    //    一覧表示画面
    public static void summaryOutput() {

        int totalMonth = 0;
        int totalYear = 0;


        if (SubscriptionList.subscriptionList == null || SubscriptionList.subscriptionList.isEmpty()) {
            list.listMake();
        }

        subscription_table_first_row.table_first_row();

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

        Command.summaryCommand();
    }

    //    詳細画面表示メソッド
    public static void detailOutput(int nextAction) {

//       1行目呼び出し
        subscription_table_first_row.table_first_row();

        // 条件に合致する SubscriptionData オブジェクトを抽出
//        SubscriptionData foundItem = null;
//        for (SubscriptionData item : SubscriptionList.subscriptionList) {
//            if (item.getId() == 1) { // IDが1の要素を探す
//                foundItem = item;
//                break; // 見つかったらループを抜ける
//            }
//        }

//        if (foundItem != null) {
//            System.out.println("条件に合致する要素が見つかりました: " + foundItem);
//        } else {
//            System.out.println("条件に合致する要素は見つかりませんでした。");
//        }

        list.selectSubscriptionList(nextAction - 1);

        Command.deleteCommand(nextAction -1);
    }
}
