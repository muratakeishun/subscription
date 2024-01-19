/*
 *画面表示クラス
 */
public class Indication {

    static SubscriptionList list = new SubscriptionList();

    private static String firstRow = "サブスクID,サブスク名,サブスクタイプ,金額";
    static int maxIdLength = 0;
    static int maxNameLength = 0;
    static int maxTypeLength = 0;
    static int maxPriceLength = 0;

    /*
     *一覧表示画面
     */
    public static void summaryOutput() {

        int totalMonth = 0;
        int totalYear = 0;

        //listの中身が空だったら登録画面に飛ばす
        if (SubscriptionList.list == null || SubscriptionList.list.isEmpty()) {
            InputCommand.inputSubscriptionData();
        }

        //各値をとってきて文字列に変換、文字列の長さを算出
        for (SubscriptionData subscriptionData : list.getSubscriptionList()) {
            maxIdLength = Math.max(maxIdLength, String.valueOf(subscriptionData.getSubscriptionId()).length());
            maxNameLength = Math.max(maxNameLength, subscriptionData.getSubscriptionName().length());
            maxTypeLength = Math.max(maxTypeLength, subscriptionData.getSubscriptionTypeString().length());
            maxPriceLength = Math.max(maxPriceLength, String.valueOf(subscriptionData.getSubscriptionPrice()).length());
        }

        // フォーマット文字列を作成
        String format = "|%" + maxIdLength + "s|%" + maxNameLength + "s|%" + maxTypeLength + "s|%" + maxPriceLength + "s|";

        // 1行目呼び出し
        System.out.println(firstRow);

        // ループで回して実行
        for (SubscriptionData subscriptionData : list.getSubscriptionList()) {
            System.out.println(subscriptionData.getRowFormatted(format));
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

    /*
     *詳細画面表示メソッド
     */
    public static void detailOutput(int nextAction) {

        if (SubscriptionList.selectSubscriptionList(nextAction) == null) {
            System.out.println("条件に合致する要素は見つかりませんでした。");
            summaryOutput();
        }
        //1行目呼び出し
        System.out.println(firstRow);
        System.out.println(SubscriptionList.selectSubscriptionList(nextAction).getRowFormatted("%d|%s|%s|%d"));
        InputCommand.deleteCommand(nextAction);
    }

    /*
     *登録画面出力
     */
    public static void registerOutput() {
        InputCommand.inputSubscriptionData();
        summaryOutput();
    }
}
