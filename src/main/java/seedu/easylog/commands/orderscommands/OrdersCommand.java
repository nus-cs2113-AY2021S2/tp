package seedu.easylog.commands.orderscommands;

import seedu.easylog.parser.OrdersParser;
import seedu.easylog.storage.Logging;
import seedu.easylog.storage.Receipt;
import seedu.easylog.ui.Ui;

/**
 * OrderCommand constructor.
 */
public abstract class OrdersCommand {

    public Ui ui = new Ui();
    public OrdersParser ordersParser = new OrdersParser();
    public Receipt receipt = new Receipt();
    public Logging logging = new Logging();
}
