package seedu.easylog.commands.itemscommands;

import seedu.easylog.exceptions.NoItemsStatisticsCanBeGivenException;
import seedu.easylog.exceptions.WrongItemsStatsCommandException;
import seedu.easylog.model.ItemManager;

public class ItemsStatisticsCommand extends ItemsCommand {

    /**
     * Print out the most popular item (the item which has most number of sales).
     * If ties, all items having the most number of sales will be shown.
     *
     * @param itemManager item manager
     */
    public void execute(String extraDescription, ItemManager itemManager) throws NoItemsStatisticsCanBeGivenException,
            WrongItemsStatsCommandException {
        if (!extraDescription.isEmpty()) {
            throw new WrongItemsStatsCommandException();
        }
        int numberOfMostPopularItems = itemManager.countNumberOfMostPopularItems();

        String itemDescriptions = itemManager.getMostPopularItemDescriptions();

        if (numberOfMostPopularItems == 1) {
            ui.showStatisticsForMostPopularItem(itemDescriptions);
        } else if (numberOfMostPopularItems > 1) {
            ui.showStatisticsForMostPopularItems(itemDescriptions);
        } else {
            throw new NoItemsStatisticsCanBeGivenException();
        }
    }
}
