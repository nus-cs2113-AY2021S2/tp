package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import reviews.Review;
import storage.Storage;
import stores.Store;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class DeleteReviewCommand extends Command {
    private int storeIndex;
    private int review;
    private int canteenIndex;

    public DeleteReviewCommand(int canteenIndex, int storeIndex, int review) {
        this.canteenIndex = canteenIndex;
        this.storeIndex = storeIndex;
        this.review = review;
    }

    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException {
        Canteen currentCanteen = canteens.get(canteenIndex);
        Store store = currentCanteen.getStore(storeIndex);
        store.deleteReview(review);
        ui.reviewDeleted();
        Storage.save(new FileWriter("data/storage.txt"),canteens);
    }

}
