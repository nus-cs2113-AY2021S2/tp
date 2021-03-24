package seedu.drugs;

import seedu.duke.exceptions.drugexceptions.WrongInputException;
import seedu.duke.ui.DrugUI;

import java.util.ArrayList;

public class DrugAction {
    public ArrayList<Drug> Drugs = new ArrayList<>();

    public void addDrugs(String name, String price, String quantity) throws WrongInputException {
        try {
            double priceDouble = Double.parseDouble(price); //check if price is a double
            if (name.isEmpty() || quantity.isEmpty()) {
                throw new WrongInputException("empty");
            }
            Drugs.add(new Drug(name, priceDouble, quantity));
            DrugUI.drugAddedMessage(name);
        } catch (NumberFormatException e) {
            throw new WrongInputException("price");
        }
    }

    public void deleteDrugs(String name) throws WrongInputException {
        try {
            boolean isContaining = false;
            for (int i = 0; i < Drugs.size(); ++i) {
                if (Drugs.get(i).getName().equals(name)) {
                    String drugName = Drugs.get(i).getName();
                    DrugUI.deleteDrugMessage(drugName);
                    Drugs.remove(Drugs.get(i));
                    isContaining = true;
                    break;
                }
            }
            if(!isContaining) {
                throw new WrongInputException("doesNotExist");
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new WrongInputException("empty");
        }
    }
    public void printList() {
        if (Drugs.size() != 0) {
            DrugUI.drugListMessage();
            for (int i = 1; i <= Drugs.size(); ++i) {
                System.out.println(i + ". " + Drugs.get(i - 1).getName() + " " + Drugs.get(i - 1).getPrice() + " " + Drugs.get(i - 1).getQuantity());
            }
        } else {
            DrugUI.emptyDrugListMessage();
        }
    }

    public void checkDrugsSize() throws WrongInputException {
        if (Drugs.size() == 0) {
            throw new WrongInputException("emptyList");
        }
    }

}




