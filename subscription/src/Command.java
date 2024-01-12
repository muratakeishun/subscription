import java.util.Scanner;

public class Command {

    static Scanner scanner = new Scanner(System.in);


    public static void summaryCommand() {


//        ユーザーからが入力されるまで処理をループさせる
        while (true) {
            System.out.println("実行したい操作を選択してください。");
            System.out.println("コマンドは半角英数で入力してください。");
            System.out.println("0 : 終了する");
            System.out.println("1 : 新規登録");
            System.out.println("2 : 詳細表示");

            //            入力された内容を格納
            int nextAction = scanner.nextInt();

            //            コマンドに応じて処理を分ける
            switch (nextAction) {
                case 0:
                    System.out.println("終了いたします。");
                    break;

                case 1:
                    break;

                case 2:
                    detailsCommand();
                    break;
            }
            break;
        }
        scanner.close();
    }

    public static void detailsCommand() {

        System.out.println("詳細表示したいidを入力してください。");
        System.out.println("戻りたい場合は「0」を入力してください。");
        int nextAction = scanner.nextInt();

//          コマンドが0だったら一覧に戻る
        if (0 == nextAction) {
            System.out.println("一覧へ戻ります。");
            Indication.summaryOutput();
        } else {
            System.out.println("id" + nextAction + "の詳細です。");
            Indication.detailOutput(nextAction);
        }
    }

//    public static void deleteOrUpdate() {
//        System.out.println("実行したい操作を選択してください。");
//        System.out.println("コマンドは半角英数で入力してください。");
//        System.out.println("0 : ID選択に戻る");
//        System.out.println("1 : 削除");
//
//        //            入力された内容を格納
//        int nextAction = scanner.nextInt();
//
////            コマンドに応じて処理を分ける
//        switch (nextAction) {
//            case 0:
//                System.out.println("終了いたします。");

//                detailsCommand();
//            case 1:
//                deleteCommand();
//
//        }
//    }

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
}
