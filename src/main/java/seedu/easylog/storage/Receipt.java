package seedu.easylog.storage;

import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Deals with receipt related features.
 */
public class Receipt extends Storage {

    public static int receiptCounter = 1;

    /**
     * Generate a receipt file in .txt format.
     * @param orderIndex order index of order to generate the order details into a receipt.
     * @param orderManager manipulate orders.
     * @throws IOException when there is an error while creating the file for the receipt.
     */
    public void generateReceipt(int orderIndex, OrderManager orderManager) throws IOException {
        String customerName = orderManager.getCustomerName(orderIndex);
        ui.showGeneratingReceipt(customerName);
        logging.writeInfoLevelLog("Starting generation of receipt.");
        File receiptDirectory = new File("Receipts");
        if (!receiptDirectory.exists()) { // if the directory does not exist
            logging.writeInfoLevelLog("Receipt directory not found and being created now.");
            receiptDirectory.mkdir();
        }
        String receiptName = customerName + receiptCounter;
        String receiptFilePath = "Receipts/" + receiptName + ".txt";
        File receipt = new File(receiptFilePath);
        receipt.createNewFile();
        logging.writeInfoLevelLog("Receipt file has been created.");
        FileWriter fw = new FileWriter(receiptFilePath);
        Order orderToAddToReceipt = orderManager.getOrder(orderIndex);
        logging.writeInfoLevelLog("Writing order details to receipt.");
        fw.write(ui.showReceiptHeader());
        fw.write(orderManager.getIndividualOrderPrintFormat(orderToAddToReceipt));
        fw.close();
        logging.writeInfoLevelLog("Order details has been written to the receipt.");
        ui.showReceiptGenerated(customerName);
        logging.writeInfoLevelLog("Receipt has been successfully generated.");
        ++receiptCounter;
        logging.writeInfoLevelLog("Incrementing receiptCounter.");
    }

    /**
     * Set the receipt counter from save file to ensure consistency.
     * @param receiptCount receipt count obtained from save file.
     */
    public void setReceiptCounter(int receiptCount) {
        receiptCounter = receiptCount;
    }
}
