import java.util.Scanner;

public class InputCommand {

    static Scanner scanner = new Scanner(System.in);


    public static void summaryCommand() {
        int nextAction;

        while (true) {
            System.out.println("実行したい操作を選択してください。");
            System.out.println("コマンドは半角英数で入力してください。");
            System.out.println("0 : 終了する");
            System.out.println("1 : 新規登録");
            System.out.println("2 : 詳細表示");

            // 入力された内容を格納
            nextAction = scanner.nextInt();

            // コマンドに応じて処理を分ける
            switch (nextAction) {
                case 0:
                    System.out.println("終了いたします。");
                    return;

                case 1:
                    Indication.registerOutput();
                    break;

                case 2:
                    detailsCommand();
                    break;

                default:
                    ErrorMessage.errorMessage();
            }
        }
    }

    public static void detailsCommand() {

        System.out.println("詳細表示したいidを入力してください。");
        System.out.println("戻りたい場合は「0」を入力してください。");
        int nextAction = scanner.nextInt();

//          コマンドが0だったら一覧に戻る
        if (0 == nextAction) {
            System.out.println("一覧へ戻ります。");
            Indication.summaryOutput();
        } else{
            System.out.println("id" + nextAction + "の詳細です。");
            Indication.detailOutput(nextAction);

        }
    }

    public static void deleteCommand(int i) {

        System.out.println("本当に削除しますか？");
        System.out.println("戻りたい場合は「0」を,削除したい場合は「1」を入力してください。");
        int selectDelete = scanner.nextInt();
        switch (selectDelete) {
            case 0:
                System.out.println("一覧へ戻ります。");
                Indication.summaryOutput();

            case 1:
                SubscriptionList.deleteSubscriptionList(i);
        }
    }

    /*
     *入力と登録するメソッド
     */
    public static void inputSubscriptionData() {
        System.out.println("登録するデータを入力してください。");

        System.out.println("サブスクの名前を入力してください。");
        String name = scanner.next();

        System.out.println("そのサブスクが年額料金なら1,月額料金なら2を入力してください。");
        int type = scanner.nextInt();

        System.out.println("そのサブスクの料金を入力してください。。");
        int price = scanner.nextInt();

        SubscriptionData newData = new SubscriptionData(name, type, price);
        SubscriptionList.addList(newData);
        SubscriptionList.writeFile();
        System.out.println("登録されました。\n");
    }
}
