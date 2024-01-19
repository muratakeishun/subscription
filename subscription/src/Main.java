import com.sun.source.tree.BreakTree;

//画面の表示クラス
public class Main {

    //    一覧表示画面
    public static void main(String[] args) {
        //csvファイルの読み込み
        SubscriptionList.readFile();
        Indication.summaryOutput();
    }
}
